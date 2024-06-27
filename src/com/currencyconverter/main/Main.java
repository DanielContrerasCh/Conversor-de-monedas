package com.currencyconverter.main;

import com.currencyconverter.model.ConsultaMoneda;
import com.currencyconverter.service.CurrencyService;
import com.currencyconverter.ui.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        CurrencyService currencyService = new CurrencyService(consultaMoneda);
        Menu menu = new Menu(input, currencyService);
        menu.start();
    }
}