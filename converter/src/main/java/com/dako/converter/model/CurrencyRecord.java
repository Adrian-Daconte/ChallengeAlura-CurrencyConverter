package com.dako.converter.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CurrencyRecord(

        @JsonAlias("base_code") String base,
        @JsonAlias("conversion_rates") Map<String, Double> rates) {

}
