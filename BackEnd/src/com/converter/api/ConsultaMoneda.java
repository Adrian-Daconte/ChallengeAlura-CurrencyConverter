package com.converter.api;

import com.converter.logic.Options;
import com.converter.modelo.ConverterApi;
import com.converter.modelo.MonedaInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class  ConsultaMoneda implements MonedaInterface {
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    //variable para guardar el valor de cambio
    private double rate;



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
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            this.rate= jsonObject.get("conversion_rate").getAsDouble();

            return gson.fromJson(response.body(),ConverterApi.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro Moneda ");
        }
    }

    @Override
    public Options recibirMonedas(String moneda1, String moneda2) {
        return new Options(moneda1,moneda2);
    }
}
