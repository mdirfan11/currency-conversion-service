package com.mdtech.microservices.controller;

import com.mdtech.microservices.beans.CurrencyConversionBean;
import com.mdtech.microservices.services.CurrencyConversionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyConversionServices currencyConversionServices;

    @GetMapping("/currency-converter/from/{from}/to/{to}/amount/{amount}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal amount) {
        return currencyConversionServices.currencyConversion(from, to, amount);
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/amount/{amount}")
    public CurrencyConversionBean retriveConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal amount) {
        return currencyConversionServices.retriveConversion(from, to, amount);
    }
}
