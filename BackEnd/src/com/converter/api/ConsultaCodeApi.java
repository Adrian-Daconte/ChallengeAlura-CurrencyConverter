package com.converter.api;

import com.converter.modelo.SupportedCodeItemRecord;
import com.converter.modelo.SupportedCodeRecord;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ConsultaCodeApi {

    //Gson
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();


    //Method Api
    public SupportedCodeRecord supportedCodeRecord (){
        URI url = URI.create("https://v6.exchangerate-api.com/v6/24119b61d0c768f745a2361d/codes");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String>
                    response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Código de estado: " + response.statusCode());
            System.out.println("Cuerpo de la respuesta: " + response.body());


            return gson.fromJson(response.body(),SupportedCodeRecord.class);
        } catch (Exception e) {
            throw new RuntimeException("ERROR"+e.getMessage());
        }

    }

}
