package com.leximar.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leximar.app.service.ClienteService;

@SpringBootApplication
public class AplicacionMvcConsumoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicacionMvcConsumoApplication.class, args);
		
		/*
		 * ClienteService servicio = new ClienteService();
		 * System.out.println(servicio.findAll());
		 */
	}

}
