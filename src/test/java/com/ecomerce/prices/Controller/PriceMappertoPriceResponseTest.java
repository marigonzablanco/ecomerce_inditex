package com.ecomerce.prices.Controller;

import com.ecomerce.prices.entities.Price;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;


class PriceMappertoPriceResponseTest {

    @Test
    void testMapToResponse_AllFieldsMappedCorrectly() {
        Price price = new Price();
        price.setProductId(1L);
        price.setBrandId(2L);
        price.setStartDate(LocalDateTime.of(2024, 6, 1, 10, 0));
        price.setEndDate(LocalDateTime.of(2024, 6, 2, 10, 0));
        price.setPrice(99.99);

        PriceMappertoPriceResponse mapper = new PriceMappertoPriceResponse();
        PriceResponse response = mapper.mapToResponse(price);

        assertEquals(price.getProductId(), response.getProductId());
        assertEquals(price.getBrandId(), response.getBrandId());
        assertEquals(price.getStartDate(), response.getStartDate());
        assertEquals(price.getEndDate(), response.getEndDate());
        assertEquals(price.getPrice(), response.getPrice());
    }

    @Test
    void testMapToResponse_NullPrice() {
        PriceMappertoPriceResponse mapper = new PriceMappertoPriceResponse();
        assertThrows(NullPointerException.class, () -> mapper.mapToResponse(null));
    }
}