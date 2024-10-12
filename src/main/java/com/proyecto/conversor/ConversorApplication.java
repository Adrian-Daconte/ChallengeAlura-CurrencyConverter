package com.proyecto.conversor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proyecto.conversor.model.RecDatosMonedas;
import com.proyecto.conversor.service.ConsumoApi;
import com.proyecto.conversor.service.ConvierteDatos;

@SpringBootApplication
public class ConversorApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ConversorApplication.class, args);
	}	

	@Override
	public void run(String... args) throws Exception {

		var cApi = new ConsumoApi();
		var json = cApi.obtenerDato("https://v6.exchangerate-api.com/v6/24119b61d0c768f745a2361d/codes");
		var conDatos = new ConvierteDatos();
		var datos = conDatos.obtenerDatos(json, RecDatosMonedas.class);
		System.out.println(datos);

	}

}
