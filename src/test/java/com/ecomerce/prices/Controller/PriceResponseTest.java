package com.ecomerce.prices.Controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class PriceResponseTest {

    @Test
    void testSetBrandId() {
        PriceResponse response = new PriceResponse();
        Long brandId = 123L;
        response.setBrandId(brandId);
        assertEquals(brandId, response.getBrandId());
    }

    @Test
    void testSetBrandIdToNull() {
        PriceResponse response = new PriceResponse();
        response.setBrandId(null);
        assertNull(response.getBrandId());
    }

    @Test
    void testSetProductId() {
        PriceResponse response = new PriceResponse();
        Long productId = 456L;
        response.setProductId(productId);
        assertEquals(productId, response.getProductId());
    }

    @Test
    void testSetProductIdToNull() {
        PriceResponse response = new PriceResponse();
        response.setProductId(null);
        assertNull(response.getProductId());
    }

    @Test
    void testSetPriceList() {
        PriceResponse response = new PriceResponse();
        Long priceList = 1L;
        response.setPriceList(priceList);
        assertEquals(priceList, response.getPriceList());
    }

    @Test
    void testSetPriceListToNull() {
        PriceResponse response = new PriceResponse();
        response.setPriceList(null);
        assertNull(response.getPriceList());
    }

    @Test
    void testSetStartDate() {
        PriceResponse response = new PriceResponse();
        java.time.LocalDateTime startDate = java.time.LocalDateTime.now();
        response.setStartDate(startDate);
        assertEquals(startDate, response.getStartDate());
    }

    @Test
    void testSetStartDateToNull() {
        PriceResponse response = new PriceResponse();
        response.setStartDate(null);
        assertNull(response.getStartDate());
    }

    @Test
    void testSetEndDate() {
        PriceResponse response = new PriceResponse();
        java.time.LocalDateTime endDate = java.time.LocalDateTime.now();
        response.setEndDate(endDate);
        assertEquals(endDate, response.getEndDate());
    }

    @Test
    void testSetEndDateToNull() {
        PriceResponse response = new PriceResponse();
        response.setEndDate(null);
        assertNull(response.getEndDate());
    }

    @Test
    void testSetPrice() {
        PriceResponse response = new PriceResponse();
        Double price = 99.99;
        response.setPrice(price);
        assertEquals(price, response.getPrice());
    }

    @Test
    void testSetPriceToNull() {
        PriceResponse response = new PriceResponse();
        response.setPrice(null);
        assertNull(response.getPrice());
    }
}