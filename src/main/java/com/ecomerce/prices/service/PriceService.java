package com.ecomerce.prices.service;

import java.util.List;

import com.ecomerce.prices.Controller.PriceRequest;
import com.ecomerce.prices.entities.Price;

public interface PriceService {

    public List<Price> getAllPrices();
    public Price getPriceById(Long id);
    public Price savePrice(Price price);
    public void deletePrice(Long id);
    public Price getPriceByDate(PriceRequest request) throws RuntimeException;
}
