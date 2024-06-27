package com.currencyconverter.model;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda buscaMoneda(String baseCode) {
        String direccion = "https://v6.exchangerate-api.com/v6/dead9eb43a0ed5ef6fa1ddcb/latest/" + baseCode;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            RecordMoneda miMonedaRecord = new Gson().fromJson(json, RecordMoneda.class);

            return new Moneda(miMonedaRecord);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: ");
            System.out.println(e.getMessage());
        }
        return null;
    }

}
