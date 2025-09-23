package com.ecomerce.prices.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.prices.entities.Price;
import com.ecomerce.prices.service.PriceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/prices")
public class PricesController {

    private  PriceMappertoPriceResponse mapper = new PriceMappertoPriceResponse();
    
    @Autowired
    private PriceService priceService;

    @GetMapping("/all")
    public List<Price> getAllPrices() {
        return priceService.getAllPrices();
    }
    
    @GetMapping("/{id}")
    public Price getPriceById(@PathVariable Long id) {
        return priceService.getPriceById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePrice(@PathVariable Long id) {
        priceService.deletePrice(id);
    }

    @PostMapping("getByDate")
    public PriceResponse getPriceByDate(@RequestBody PriceRequest request) {
        try {
            Price price = priceService.getPriceByDate(request);
            if (price == null) {
            throw new RuntimeException("No price found for the given date");
            }
            return mapper.mapToResponse(price);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving price: " + e.getMessage());
        }
    }
    
}
