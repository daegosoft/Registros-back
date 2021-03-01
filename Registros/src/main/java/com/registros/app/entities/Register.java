package com.registros.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Register {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name", nullable = false, length = 30)
	private String name;
	@Column(name="latName", nullable = false, length = 30)
	private String lastName;
	@Column(name="procesar")
	private boolean procesar;
	
	public Register() {
		
	}
	
	public Register(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
		this.procesar = false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isProcesar() {
		return procesar;
	}
	public void setProcesar(boolean procesar) {
		this.procesar = procesar;
	}
	
	
}
