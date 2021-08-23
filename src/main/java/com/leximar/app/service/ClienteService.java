 package com.leximar.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.leximar.app.model.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	private RestTemplate restTemplate;

	public List<Cliente> findAll() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Cliente> request = new HttpEntity<Cliente>(headers);
		HttpEntity<List<Cliente>> response = restTemplate.exchange("http://localhost:8080/api/clientes",
				HttpMethod.GET,
				request,
				new ParameterizedTypeReference<List<Cliente>>() {
				});
		return response.getBody();
	}

	public List<Cliente> findByID(String id) {
		
		String url = "http://localhost:8080/api/clientes/{id}";
		UriComponentsBuilder builder;
		
		builder = UriComponentsBuilder.fromHttpUrl(url).path(id);
		
		ResponseEntity<List<Cliente>> response =
				restTemplate.exchange(builder.toUriString(),
						HttpMethod.GET,
						null, 
						new ParameterizedTypeReference<List<Cliente>>() {
						});
		return response.getBody();
	}

	public ResponseEntity<Cliente> create(Cliente cliente) {
		HttpEntity<Cliente> request = new HttpEntity<Cliente>(cliente);
		return restTemplate.postForEntity("http://localhost:8080/api/clientes", request, Cliente.class);
	}
	
	
	public void delete (String id) {
		//restTemplate.delete("http://localhost:8080/api/clientes" + id);
		
		String url = "http://localhost:8080/api/clientes/{id}";
		UriComponentsBuilder builder;
		builder = UriComponentsBuilder.fromHttpUrl(url).path(id);
		//restTemplate.delete("http://localhost:8080/api/clientes", );
		restTemplate.delete(builder.toUriString(), Cliente.class);
		System.out.println(builder.toUriString());
		
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<Cliente> request = new HttpEntity<Cliente>(headers);
//
//		String url = "http://localhost:8080/api/clientes/{id}";
//		UriComponentsBuilder builder;
//		
//		builder = UriComponentsBuilder.fromHttpUrl(url).path(id);
//		
//		ResponseEntity<Cliente> response =
//				restTemplate.exchange(builder.toUriString(),
//						HttpMethod.DELETE,
//						request, 
//						new ParameterizedTypeReference<Cliente>() {
//						});
//		return response.getBody();
		}
	
		/*
		 * public void modificar (Cliente cliente) { HttpEntity<Cliente> request = new
		 * HttpEntity<Cliente>(cliente);
		 * restTemplate.put(http://localhost:8080/api/clientes, request); }
		 */
	
	

}
