package com.converter.main;

import com.converter.api.ConsultaMoneda;
import com.converter.modelo.ConverterApi;

public class App {
    public static void main(String[] args) {
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        try {

            ConverterApi consulta = consultaMoneda.convertidorApi("USD","EUR");
            System.out.println(consulta);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando la Aplicación ");
        }
    }

}