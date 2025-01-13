package com.dako.converter.api;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonConverter implements JsonConverteInterface {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T convertJsonToObject(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("ERROR:" + e.getMessage());
        }
    }

}
