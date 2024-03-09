package com.curso.test.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestAutowired {
	
	private String nombre="default";
	private int edad=0;
	
	public TestAutowired( @Value("defaultValue") String a,@Value("1") int b) {
		this.nombre=a;
		this.edad=b;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
}
