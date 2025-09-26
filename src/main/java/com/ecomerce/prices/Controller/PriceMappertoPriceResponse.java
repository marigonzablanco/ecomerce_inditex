package com.ecomerce.prices.Controller;

import java.util.List;

import com.ecomerce.prices.entities.Price;

public class PriceMappertoPriceResponse {

    PriceResponse mapToResponse(Price price) {
        PriceResponse response = new PriceResponse();
        response.setProductId(price.getProductId());
        response.setBrandId(price.getBrandId());
        response.setStartDate(price.getStartDate());
        response.setEndDate(price.getEndDate());
        response.setPrice(price.getPrice());
        response.setPriceList(price.getPriceList());
        return response;
    }

    List<PriceResponse> mapToResponseList(java.util.List<Price> prices) {
        java.util.List<PriceResponse> responses = new java.util.ArrayList<>();
        for (Price price : prices) {
            responses.add(mapToResponse(price));
        }
        return responses;
    }

}
