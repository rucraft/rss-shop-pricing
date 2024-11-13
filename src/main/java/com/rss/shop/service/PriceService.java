package com.rss.shop.service;

import com.rss.shop.dto.PriceDto;

import com.rss.shop.exception.PriceNotFoundException;
import com.rss.shop.exception.InvalidDataFormatException;

/**
 * Pricing service
 */
public interface PriceService {

	/**
	 * Find price (pvp) by params
	 *
	 * @param priceDate Price date to find
	 * @param productId productId to find
	 * @param brandId   brandId to find
	 * @return PriceDto
	 */
	PriceDto findPricePvp(String priceDate, Long productId, Long brandId)
			throws PriceNotFoundException, InvalidDataFormatException;

}
