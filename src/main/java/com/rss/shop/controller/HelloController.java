package com.rss.shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rss.shop.dto.PriceDto;

@RestController
public class HelloController {

    @GetMapping(value = "/")
    public String welcome() {
    	return "Hello!";
    }
    
}
