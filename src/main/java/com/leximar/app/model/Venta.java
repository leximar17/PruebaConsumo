package com.leximar.app.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Venta {
	
	//id, fecha, iva, descuento, total 
	
	private Long id;
	
	private Date  fecha;
	
	private Double iva;
	
	private Double descuento;
	
	private Double total;
	
	

}
