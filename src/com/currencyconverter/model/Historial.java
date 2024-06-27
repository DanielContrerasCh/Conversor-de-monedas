package com.currencyconverter.model;

import java.time.LocalDateTime;

public class Historial {
    private String monedaOrigen;
    private String monedaDestino;
    private double cantidad;
    private double resultado;
    private LocalDateTime fecha;

    public Historial(String monedaOrigen, String monedaDestino, double cantidad, double resultado) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.cantidad = cantidad;
        this.resultado = resultado;
        this.fecha = LocalDateTime.now();
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getResultado() {
        return resultado;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
}
