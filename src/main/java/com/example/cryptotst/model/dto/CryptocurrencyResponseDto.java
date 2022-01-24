package com.example.cryptotst.model.dto;

import java.math.BigDecimal;

public class CryptocurrencyResponseDto {
    private String name;
    private BigDecimal price;
    private String actualDate;

    public String getActualDate() {
        return actualDate;
    }

    public void setActualDate(String actualDate) {
        this.actualDate = actualDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
