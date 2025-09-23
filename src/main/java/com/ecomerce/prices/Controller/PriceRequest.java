package com.ecomerce.prices.Controller;

import java.time.LocalDateTime;

import lombok.NonNull;

public class PriceRequest {

    @NonNull
    private LocalDateTime date;
    @NonNull
    private Long productId;
    @NonNull
    private Long brandId;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}
