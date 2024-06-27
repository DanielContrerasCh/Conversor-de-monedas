package com.currencyconverter.model;

import java.util.Map;

public record RecordMoneda(String base_code, Map<String, Double> conversion_rates){
}
