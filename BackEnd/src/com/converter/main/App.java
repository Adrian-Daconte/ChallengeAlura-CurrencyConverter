package com.converter.main;

import com.converter.api.ConsultaMoneda;
import com.converter.modelo.ConverterApi;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        var option = new Scanner(System.in);
        //Instancia para obtener API
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();


        String menu= """
                *******************************************************************
                ****************** CHALLENGER CURRENCY CONVERTER ****************** 
                1.  Dolares Americanos  (USD)   a       Peso Colombiano     (COP) 
                2.  Peos Colombiano     (COP)   a       Dolares Americanos  (USD) 
                0.  Salir del programa
                """;
        System.out.println(menu+"↓↓↓ Por favor digita  una opcion ↓↓↓");
        //condicional Menu
        while (!option.hasNextInt() ){
            System.out.println(menu+"↓↓↓ Por favor digita  una opcion  Valida ↓↓↓");

            option.nextLine();
        }
        int a = option.nextInt();
        System.out.println("----- la opcion es ."+a);

        String moneda1="COP";
        String moneda2="USD";


        try {

            ConverterApi consulta = consultaMoneda.convertidorApi(moneda1,moneda2);
            System.out.println(consulta.obtenerRate());

            // System.out.println(consulta); // consulta en tipo Json Object
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando la Aplicación ");
        }

    }

}

