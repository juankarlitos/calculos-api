package com.Challenge.Backend.calculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CalculosPorcentajesDinamicosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculosPorcentajesDinamicosApplication.class, args);
	}
}