package com.mdtech.microservices.beans;

import java.math.BigDecimal;

public class CurrencyConversionBean {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionRate;
    private BigDecimal amount;
    private BigDecimal totalAmount;
    private int port;

    public CurrencyConversionBean() {}

    public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionRate, BigDecimal amount, BigDecimal totalAmount, int port) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionRate = conversionRate;
        this.amount = amount;
        this.totalAmount = totalAmount;
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
