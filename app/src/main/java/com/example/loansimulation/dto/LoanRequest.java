package com.example.loansimulation.dto;

import java.math.BigDecimal;

public class LoanRequest {

    private BigDecimal principal ;

    private float interes_rate;

    private Integer tenor;

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public float getInteres_rate() {
        return interes_rate;
    }

    public void setInteres_rate(float interes_rate) {
        this.interes_rate = interes_rate;
    }

    public Integer getTenor() {
        return tenor;
    }

    public void setTenor(Integer tenor) {
        this.tenor = tenor;
    }
}
