package com.currencyconverter.service;

import com.currencyconverter.model.ConsultaMoneda;
import com.currencyconverter.model.Moneda;

public class CurrencyService {
    private ConsultaMoneda consultaMoneda;

    public CurrencyService(ConsultaMoneda consultaMoneda) {
        this.consultaMoneda = consultaMoneda;
    }

    public double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        try {
            Moneda miMoneda = consultaMoneda.buscaMoneda(fromCurrency);
            return miMoneda.calculaConversion(toCurrency, amount);
        } catch (NullPointerException e) {
            System.out.println("No se pudo realizar la conversión, por favor verifique los códigos de moneda");
            return 0;
        }
    }
}