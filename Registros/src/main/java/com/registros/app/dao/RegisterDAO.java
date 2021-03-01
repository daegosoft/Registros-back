package com.registros.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.registros.app.entities.Register;
import com.registros.app.repository.RegisterRepository;

@Repository
public class RegisterDAO {
	
	//Inyecto la interfaz del repositorio para obtener los metodos CRUD
	@Autowired RegisterRepository repository;
	
	//Metodo para obtener todos los registros en memoria
	public List<Register> getAll(){
		System.out.println("Obteniendo todos los registros");
		List<Register> registros = repository.findAll();
		System.out.println("total registros " + registros.size());
		return registros;
	}
	
	//valida que el registro a guardar no este en Memoria y lo guarda
	public Register saveRegister(Register register) {
		System.out.println("Ingrese a Crear Registro.");
		try {
			if(repository.findById(register.getId()).isEmpty()) {
				System.out.println("Fin a Crear Registro.");
				return repository.save(register); 
			}
		}catch(Exception e) {
			System.out.println("Error al Crear Registro " + e.getMessage()+".");
		}
		return null;
	}
	
	//valida que el dato este en memoria, cambia el valor de la variable procesar y lo actualiza
	public Register updateRegister(Register register) {
		System.out.println("Inicio actualización Registro");
		try {
			if(repository.findById(register.getId()).isPresent()) {
				register.setProcesar(true);
				System.out.println("Fin actualización Registro");
				return repository.save(register);
			}
		}catch(Exception e) {
			System.out.println("Error actualizando Registro "+ e.getMessage()+".");
		}
		return null;
	}
}
