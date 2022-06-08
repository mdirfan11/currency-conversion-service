package com.mdtech.microservices.services;

import com.mdtech.microservices.beans.CurrencyConversionBean;
import com.mdtech.microservices.proxy.CurrencyExchangeFeignProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyConversionServices {

    @Autowired
    private CurrencyExchangeFeignProxy currencyExchangeFeignProxy;

    public CurrencyConversionBean currencyConversion(String from, String to, BigDecimal amount) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversionBean.class,
                uriVariables
        );

        CurrencyConversionBean response = responseEntity.getBody();
        response.setAmount(amount);
        response.setTotalAmount(response.getAmount().multiply(response.getConversionRate()));

        return response;
    }

    public CurrencyConversionBean retriveConversion(String from, String to, BigDecimal amount) {

        CurrencyConversionBean response = currencyExchangeFeignProxy.retriveExchangeValue(from, to);
        response.setAmount(amount);
        response.setTotalAmount(response.getAmount().multiply(response.getConversionRate()));

        return response;
    }
}
