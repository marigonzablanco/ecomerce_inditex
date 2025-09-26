package com.ecomerce.prices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.prices.Controller.PriceRequest;
import com.ecomerce.prices.entities.Price;
import com.ecomerce.prices.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }
    public Price getPriceById(Long id) {
        return priceRepository.getPriceById(id);
    } 
    public Price savePrice(Price price) {
        return priceRepository.save(price);
    }
    public void deletePrice(Long id) {
        priceRepository.deletePrice(id);
    }
    public Price getPriceByDate(PriceRequest request) {
        return priceRepository.getPriceByDate(request);
    }
}
