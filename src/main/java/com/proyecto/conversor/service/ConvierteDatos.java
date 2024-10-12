package com.proyecto.conversor.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);    
        } catch (Exception e) {
            System.out.println("ERROR"+e.getMessage());
        }
        return null;
    }
    
}
