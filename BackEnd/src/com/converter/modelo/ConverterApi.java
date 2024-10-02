package com.converter.modelo;

public record ConverterApi(String result , String base_code , String target_code , double conversion_rate) {
public String obtenerRate (){
    double rate = this.conversion_rate;
    return String.format("%2f",rate );
}
}
