package com.ecomerce.prices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomerce.prices.Controller.PriceRequest;
import com.ecomerce.prices.entities.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

    Price getPriceByDate(PriceRequest request) ;
    public List<Price> getAllPrices();
    public Price getPriceById(Long id);
    public Price savePrice(Price price);
    public void deletePrice(Long id);

}
