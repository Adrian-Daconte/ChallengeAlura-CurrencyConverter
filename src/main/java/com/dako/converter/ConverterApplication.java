package com.dako.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dako.converter.services.AppMain;

@SpringBootApplication
public class ConverterApplication implements CommandLineRunner {

	@Autowired
	private  AppMain appMain;

	public static void main(String[] args) {
		SpringApplication.run(ConverterApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		appMain.getMenu();
	}

}
