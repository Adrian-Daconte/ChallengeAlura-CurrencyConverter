package com.dako.converter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dako.converter.api.ApiRequest;
import com.dako.converter.api.JsonConverter;
import com.dako.converter.model.CurrencyRecord;

@Service
public class GetDataFromApi {

    @Autowired
    private ApiRequest apiRequest;
    @Autowired
    private JsonConverter jsonConverter;

    @Value("${api.key}")
    private String API_KEY;

    @Value("https://v6.exchangerate-api.com/v6/${api.key}")
    private String URL;

    public String getDataByFromAnTo(String fromCurrency, String toCurrency, double amount) {
        if (amount <= 0) {
            System.out.println("Error: La cantidad debe ser mayor que cero.");
            return null;
        }

        if (fromCurrency.equals(toCurrency)) {
            System.out.println("Error: Las monedas de origen y destino no pueden ser iguales.");
            return null;
        }

        try {
            String url = URL + "/latest/" + fromCurrency;
            String json = apiRequest.getData(url);

            CurrencyRecord response = jsonConverter.convertJsonToObject(json, CurrencyRecord.class);

            if (response == null || response.rates() == null) {
                System.out.println("Error: No se pudo obtener la información de tasas de cambio.");
                return null;
            }

            Double rate = response.rates().get(toCurrency);
            if (rate == null) {
                System.out.println("Error: No se encontró la tasa de cambio para " + toCurrency);
                return null;
            }

            double convertedValue = rate * amount;
            System.out.printf("""
                    La conversión de %.2f %s a %s es:
                    %.2f %s
                    """, amount, fromCurrency, toCurrency, convertedValue, toCurrency);
            return json;
        } catch (Exception e) {
            System.err.println("Error inesperado: verifica las monedas a convertir");
            e.printStackTrace();
            return null;
        }
    }
}
