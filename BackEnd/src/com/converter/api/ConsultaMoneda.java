package com.converter.api;

import com.converter.modelo.ConverterApi;
import com.google.gson.Gson;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public  ConverterApi convertidorApi (String base , String salida){
        URI url = URI.create("https://v6.exchangerate-api.com/v6/24119b61d0c768f745a2361d/pair/"+base+"/"+salida);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            HttpResponse<String>
                    response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConverterApi.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro Moneda ");
        }
    }

}
