package com.leximar.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.leximar.app.model.Venta;

public class VentaService implements IVentaService {
	
	@Autowired
	RestTemplate restTemplate;
	

	@Override
	public List<Venta> findAll() {
		HttpEntity<List<Venta>> response = restTemplate.exchange("http://localhost:8080/api/ventas",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Venta>>() {
				});
		return response.getBody();
	}
}
