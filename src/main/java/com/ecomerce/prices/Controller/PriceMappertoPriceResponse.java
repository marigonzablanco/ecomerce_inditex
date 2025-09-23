package com.ecomerce.prices.Controller;

import com.ecomerce.prices.entities.Price;

public class PriceMappertoPriceResponse {

    PriceResponse mapToResponse(Price price) {
        PriceResponse response = new PriceResponse();
        response.setProductId(price.getProductId());
        response.setBrandId(price.getBrandId());
        response.setStartDate(price.getStartDate());
        response.setEnddDate(price.getEndDate());
        response.setPrice(price.getPrice());
        return response;
    }
}
