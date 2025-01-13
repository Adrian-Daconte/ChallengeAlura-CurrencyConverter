package com.dako.converter.services;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppMain {

    @Autowired
    GetDataFromApi getDataFromApi;

    private static final String MENU_OPTIONS = """
            \n---------------------------------------------
            Bienvenido a Convertidor de Moneda , nuestras opciones :
            ---------------------------------------------

                    1. Dòlar (USD) <-> Peso Colombiano (COP)
                    2. Peso Colombiano (COP) <-> Dólar (USD)
                    3. Dólar (USD) <-> Peso Mexicano (MXN)
                    4. Peso Mexicano (MXN) <-> Dólar (USD)
                    5. Dòlar (USD) <-> Euro (EUR)
                    6. Euro (EUR) <-> Dólar (USD)
                    7. Real Brasileño (BRL) <-> Dólar (USD)
                    8. Dòlar (USD) <-> Real Brasileño (BRL)
                    9. Conversión Personalizada entre dos monedas

                    0. Salir \n
            """;
    private static final String USER_IN = """
            Por favor , Digita la opción correspondiente
            """;

    public void getMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion = -1;
            do {
                System.out.println(MENU_OPTIONS);
                System.out.println(USER_IN);

                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    processOption(opcion, scanner);
                } else {
                    System.out.println("Por favor, ingrese un número válido.");
                    scanner.next(); // Limpiar el buffer del scanner
                }
            } while (opcion != 0);
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getClass() + " - " + e.getMessage());
        }
    }

    private void processOption(int opcion, Scanner scanner) {
        switch (opcion) {
            case 0:
                System.out.println("Gracias por usar el convertidor. ¡Hasta pronto!");
                break;
            case 1:
                convertCurrency("USD", "COP", scanner);
                break;
            case 2:
                convertCurrency("COP", "USD", scanner);
                break;
            case 3:
                convertCurrency("USD", "MXN", scanner);
                break;
            case 4:
                convertCurrency("MXN", "USD", scanner);
                break;
            case 5:
                convertCurrency("USD", "EUR", scanner);
                break;
            case 6:
                convertCurrency("EUR", "USD", scanner);
                break;
            case 7:
                convertCurrency("BRL", "USD", scanner);
                break;
            case 8:
                convertCurrency("USD", "BRL", scanner);
                break;
            case 9:
                customConversion(scanner);
                break;
            default:
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
                break;
        }
    }

    private void customConversion(Scanner scanner) {
        System.out.print("Ingrese la moneda de origen (ej. USD): ");
        String fromCurrency = scanner.next().toUpperCase();
        System.out.print("Ingrese la moneda de destino (ej. EUR): ");
        String toCurrency = scanner.next().toUpperCase();

        System.out.print("Ingrese la cantidad a convertir: ");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            System.out.println("\nPor favor espere ...");
            getDataFromApi.getDataByFromAnTo(fromCurrency, toCurrency, amount);
        } else {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next(); // Limpiar el buffer del scanner
        }
    }

    private void convertCurrency(String fromCurrency, String toCurrency, Scanner scanner) {
        try {
            System.out.print("\nIngrese la cantidad en " + fromCurrency + " a convertir a " + toCurrency + " : ");
            if (scanner.hasNextDouble()) {
                double amount = scanner.nextDouble();
                System.out.println("\nPor favor espere ...");
                getDataFromApi.getDataByFromAnTo(fromCurrency, toCurrency, amount);
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        } catch (IllegalArgumentException e) {
            System.err.println("\nError en la conversión: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\nOcurrió un error inesperado: " + e.getMessage());
        }
    }
}
