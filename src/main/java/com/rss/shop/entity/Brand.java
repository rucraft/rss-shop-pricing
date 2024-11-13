package com.rss.shop.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "BRAND")
public class Brand {
	
	@Id
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
	private List<Price> prices;

}

