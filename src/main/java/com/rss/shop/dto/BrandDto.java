package com.rss.shop.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

import com.rss.shop.entity.Price;

/**
 * A DTO for the {@link com.store.entity.Brand} entity
 */
@Data
public class BrandDto implements Serializable {
    
	private Long id;
    private String name;
    private String description;

    private List<Price> prices;
    
}