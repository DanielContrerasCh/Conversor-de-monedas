package com.currencyconverter.ui;

import com.currencyconverter.model.Historial;
import com.currencyconverter.service.CurrencyService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner input;
    private CurrencyService currencyService;
    private List<Historial> historial;

    public Menu(Scanner input, CurrencyService currencyService) {
        this.input = input;
        this.currencyService = currencyService;
        this.historial = new ArrayList<>();
    }

    public void start() {
        while(true) {
            System.out.println("===============================================");
            System.out.println("Por favor, seleccione la moneda que desea convertir");
            System.out.println("1) Convertir Dólar (USD)");
            System.out.println("2) Convertir Peso Chileno (CLP)");
            System.out.println("3) Convertir Real Brasileño (BRL)");
            System.out.println("4) Convertir Peso Mexicano (MXN)");
            System.out.println("5) Convertir Peso Argentino (ARS)");
            System.out.println("6) Convertir Boliviano boliviano (BOB)");
            System.out.println("7) Convertir Peso Colombiano (COP)");
            System.out.println("8) Convertir otra moneda");
            System.out.println("9) Historial de conversiones");
            System.out.println("10) Salir");

            try {
                int opcion = input.nextInt();
                switch (opcion) {
                    case 8:
                        System.out.println("Introduzca el código de la moneda que desea convertir: ");
                        String moneda = input.next();
                        System.out.println("Introduzca el código de la moneda a la que desea convertir: ");
                        String monedaDestino = input.next();
                        System.out.println("Introduzca la cantidad que desea convertir: ");
                        double cantidad = input.nextDouble();

                        double resultado = currencyService.convertCurrency(moneda, monedaDestino, cantidad);
                        muestraResultado(moneda, monedaDestino, cantidad, resultado);
                        historial.add(new Historial(moneda, monedaDestino, cantidad, resultado));
                        continue;
                    case 9:
                        System.out.println("Historial de conversiones:");
                        for (Historial item: historial) {
                            System.out.println("Moneda origen: " + item.getMonedaOrigen() +
                                    ", Moneda destino: " + item.getMonedaDestino() +
                                    ", Cantidad: " + item.getCantidad() +
                                    ", Resultado: " + item.getResultado() + " " + item.getMonedaDestino() +
                                    ", Fecha: " + item.getFecha());
                        }
                        continue;
                    case 10:
                        System.out.println("Gracias por usar el sistema de conversión de monedas");
                        return;
                }

                if (!validaEntrada(opcion, 10)) {
                    continue;
                }

                String monedaOrigen = getMoneda(opcion);
                int aux = getMonedaDestino();
                if (!validaEntrada(aux, 7)) {
                    continue;
                }
                String monedaDestino = getMoneda(aux);

                double cantidad = getCantidad();
                double resultado = currencyService.convertCurrency(monedaOrigen, monedaDestino, cantidad);
                muestraResultado(monedaOrigen, monedaDestino, cantidad, resultado);
                historial.add(new Historial(monedaOrigen, monedaDestino, cantidad, resultado));
            } catch (InputMismatchException e) {
                System.out.println("Opción inválida, por favor seleccione una opción válida");
                input.next();
            }

        }
    }

    public Boolean validaEntrada(int opcion, int maxOpcion) {
        if(opcion < 1 || opcion > maxOpcion) {
            System.out.println("Opción inválida, por favor seleccione una opción válida");
            return false;
        }
        return true;
    }

    private String getMoneda(int opcion) {
        switch (opcion) {
            case 1:
                return "USD";
            case 2:
                return "CLP";
            case 3:
                return "BRL";
            case 4:
                return "MXN";
            case 5:
                return "ARS";
            case 6:
                return "BOB";
            case 7:
                return "COP";
            default:
                return "";
        }
    }

    private int getMonedaDestino() {
        System.out.println("Introduzca la moneda a la que deseas convertir: ");
        System.out.println("1) Dólar (USD)");
        System.out.println("2) Peso Chileno (CLP)");
        System.out.println("3) Real Brasileño (BRL)");
        System.out.println("4) Peso Mexicano (MXN)");
        System.out.println("5) Peso Argentino (ARS)");
        System.out.println("6) Boliviano boliviano (BOB)");
        System.out.println("7) Peso Colombiano (COP)");
        return input.nextInt();
    }

    private double getCantidad() {
        System.out.println("Introduzca la cantidad que desea convertir: ");
        return input.nextDouble();
    }

    private void muestraResultado(String monedaOrigen, String monedaDestino, double cantidad, double resultado) {
        System.out.println("El resultado de convertir " + cantidad + " " + monedaOrigen + " a " + monedaDestino + " es: " + resultado);
    }
}