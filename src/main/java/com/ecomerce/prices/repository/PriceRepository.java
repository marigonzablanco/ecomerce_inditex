package com.ecomerce.prices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomerce.prices.Controller.PriceRequest;
import com.ecomerce.prices.entities.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

    Price getPriceByDate(PriceRequest request) throws RuntimeException;

}
