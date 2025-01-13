package com.dako.converter.api;

public interface JsonConverteInterface {
    <T> T convertJsonToObject(String json, Class<T> clazz);
}
