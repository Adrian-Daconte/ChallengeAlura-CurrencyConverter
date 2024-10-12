package com.proyecto.conversor.service;

public interface IConvierteDatos {
    <T>T obtenerDatos(String json,Class<T> clase);
}
