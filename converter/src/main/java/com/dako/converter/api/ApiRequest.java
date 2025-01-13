package com.dako.converter.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Component;

@Component
public class ApiRequest {

    public String getData(String url) {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException e) {
            throw new RuntimeException("ERROR :" + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException("ERROR :" + e.getMessage());

        }
        String json = response.body();
        return json;
    }

}
