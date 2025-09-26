package com.ecomerce.prices.Controller;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;


class PriceRequestTest {

    @Test
    void testSetAndGetDate() {
        PriceRequest request = new PriceRequest();
        LocalDateTime now = LocalDateTime.now();
        request.setDate(now);
        assertEquals(now, request.getDate());
    }

    @Test
    void testSetAndGetProductId() {
        PriceRequest request = new PriceRequest();
        Long productId = 123L;
        request.setProductId(productId);
        assertEquals(productId, request.getProductId());
    }

    @Test
    void testSetAndGetBrandId() {
        PriceRequest request = new PriceRequest();
        Long brandId = 456L;
        request.setBrandId(brandId);
        assertEquals(brandId, request.getBrandId());
    }

    @Test
    void testMultipleSettersAndGetters() {
        PriceRequest request = new PriceRequest();
        LocalDateTime date = LocalDateTime.of(2024, 6, 1, 12, 0);
        Long productId = 789L;
        Long brandId = 1011L;

        request.setDate(date);
        request.setProductId(productId);
        request.setBrandId(brandId);

        assertEquals(date, request.getDate());
        assertEquals(productId, request.getProductId());
        assertEquals(brandId, request.getBrandId());
    }

    @Test
    void testDefaultValuesAreNull() {
        PriceRequest request = new PriceRequest();
        assertNull(request.getDate());
        assertNull(request.getProductId());
        assertNull(request.getBrandId());
    }

    @Test
    void testSetDateToNull() {
        PriceRequest request = new PriceRequest();
        request.setDate(null);
        assertNull(request.getDate());
    }

    @Test
    void testSetProductIdToNull() {
        PriceRequest request = new PriceRequest();
        request.setProductId(null);
        assertNull(request.getProductId());
    }

    @Test
    void testSetBrandIdToNull() {
        PriceRequest request = new PriceRequest();
        request.setBrandId(null);
        assertNull(request.getBrandId());
    }

    @Test
    void testSettersOverridePreviousValues() {
        PriceRequest request = new PriceRequest();
        LocalDateTime date1 = LocalDateTime.of(2024, 1, 1, 10, 0);
        LocalDateTime date2 = LocalDateTime.of(2025, 1, 1, 10, 0);
        Long productId1 = 1L;
        Long productId2 = 2L;
        Long brandId1 = 3L;
        Long brandId2 = 4L;

        request.setDate(date1);
        request.setProductId(productId1);
        request.setBrandId(brandId1);

        request.setDate(date2);
        request.setProductId(productId2);
        request.setBrandId(brandId2);

        assertEquals(date2, request.getDate());
        assertEquals(productId2, request.getProductId());
        assertEquals(brandId2, request.getBrandId());
    }
}