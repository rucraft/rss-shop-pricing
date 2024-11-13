package com.rss.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "PRICE")
public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "START_DATE", nullable = false)
	private LocalDateTime startDate;

	@NotNull
	@Column(name = "END_DATE", nullable = false)
	private LocalDateTime endDate;

	@NotNull
	@Column(name = "PRICE_LIST", nullable = false)
	private Integer priceList;

	@NotNull
	@Column(name = "PRODUCT_ID", nullable = false)
	private Long productId;

	@NotNull
	@Column(name = "PRIORITY", nullable = false)
	private Integer priority;

	@NotNull
	@Column(name = "PRICE", nullable = false, precision = 6, scale = 2)
	private BigDecimal price;

	@Size(max = 5)
	@NotNull
	@Column(name = "CURR", nullable = false, length = 5)
	private String curr;
	
	// FK
	@ManyToOne
	@JoinColumn(name = "BRAND_ID", referencedColumnName = "id")
	private Brand brand;

}
