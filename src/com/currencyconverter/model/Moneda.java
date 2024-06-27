package com.currencyconverter.model;

import java.util.Map;

public class Moneda {
    private String base_code;
    private Map<String, Double> conversion_rates;

    public Moneda(RecordMoneda recordMoneda) {
        this.base_code = recordMoneda.base_code();
        this.conversion_rates = recordMoneda.conversion_rates();
    }

    public Double getConversionRate(String key) {
        return conversion_rates.get(key);
    }

    public double calculaConversion(String key, double cantidad) {
        var conversion = getConversionRate(key);
        return cantidad * conversion;
    }
}
