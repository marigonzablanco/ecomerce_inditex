package com.ecomerce.prices.Controller;

import java.time.LocalDateTime;

public class PriceResponse {
    
    private Long productId;
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime enddDate;
    private Double price;

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
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public LocalDateTime getEnddDate() {
        return enddDate;
    }

    public void setEnddDate(LocalDateTime enddDate) {
        this.enddDate = enddDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
}
