package com.rss.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rss.shop.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}