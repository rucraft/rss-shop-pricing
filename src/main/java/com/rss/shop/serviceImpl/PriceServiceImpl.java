package com.rss.shop.serviceImpl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rss.shop.dto.PriceDto;
import com.rss.shop.exception.PriceNotFoundException;
import com.rss.shop.exception.InvalidDataFormatException;
import com.rss.shop.repository.PriceRepository;
import com.rss.shop.service.PriceService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Pricing service
 */
@Service
public class PriceServiceImpl implements PriceService {

	private static final Logger log = LoggerFactory.getLogger(PriceServiceImpl.class);
	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm");

	@Autowired
	private PriceRepository priceRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PriceDto findPricePvp(String priceDateStr, Long productId, Long brandId)
			throws PriceNotFoundException, InvalidDataFormatException {

		validateInputData(priceDateStr, productId, brandId);
		LocalDateTime priceDate = LocalDateTime.parse(priceDateStr, DATE_TIME_FORMATTER);
		List<com.rss.shop.entity.Price> prices = priceRepository.findByParams(priceDate, productId, brandId);

		if (prices.isEmpty()) {
			throw new PriceNotFoundException();
		}

		// Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad
		// (mayor valor numérico).
		prices.stream().sorted((f1, f2) -> Integer.compare(f2.getPriority(), f1.getPriority()));
		com.rss.shop.entity.Price pvpPrice = prices.get(prices.size()-1);
		PriceDto priceDto = modelMapper.map(pvpPrice, PriceDto.class);
		return priceDto;
	}

	/**
	 * Validate input data
	 *
	 * @param priceDateStr Price date string
	 * @param productId    Product id
	 * @param brandId      Brand id
	 * @throws InvalidDataFormatException The invalid input data exception
	 */
	private void validateInputData(String priceDateStr, Long productId, Long brandId) throws InvalidDataFormatException {
		boolean validData = true;
		try {
			if (productId <= 0 || brandId <= 0) {
				validData = false;
			}
			LocalDateTime priceDate = LocalDateTime.parse(priceDateStr, DATE_TIME_FORMATTER);
		} catch (Exception e) {
			validData = false;
		} finally {
			log.info("Throw InvalidInputDataFormatException");
		}

		if (!validData) {
			log.info("Throw InvalidInputDataFormatException");
			throw new InvalidDataFormatException();
		}
	}
}
