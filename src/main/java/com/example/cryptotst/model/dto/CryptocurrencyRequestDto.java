package com.example.cryptotst.model.dto;

import java.math.BigDecimal;

public class CryptocurrencyRequestDto {
    private BigDecimal lprice;
    private String curr1;

    public BigDecimal getLprice() {
        return lprice;
    }

    public void setLprice(BigDecimal lprice) {
        this.lprice = lprice;
    }

    public String getCurr1() {
        return curr1;
    }

    public void setCurr1(String curr1) {
        this.curr1 = curr1;
    }

}
