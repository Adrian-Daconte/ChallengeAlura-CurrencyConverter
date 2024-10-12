package com.proyecto.conversor.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public record RecDatosMonedas(
@JsonAlias("result") String result 

) {}
