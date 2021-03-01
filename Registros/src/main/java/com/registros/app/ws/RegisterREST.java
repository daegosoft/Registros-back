package com.registros.app.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.registros.app.entities.Register;
import com.registros.app.entities.Respuesta;

import com.registros.app.dao.RegisterDAO;

@RestController
@RequestMapping("/registro")
@CrossOrigin({"*"})
public class RegisterREST {
	
	//Inyecto el DAO con los metodos CRUD para el servicio REST
	@Autowired RegisterDAO registerDAO;
	
	//End point para obtener todos los registros en memoria
	@GetMapping("/all")
	public ResponseEntity< List<Register> > getAll() {
		return ResponseEntity.ok(registerDAO.getAll());
	}
	
	//End point para guardar el registro pasado desde el front para guardar en memoria
	@PostMapping("/save")
	public ResponseEntity<Respuesta> saveRegister(@RequestBody Register registro){
		Register r = registerDAO.saveRegister(registro);
		Respuesta res = new Respuesta();
		if(r != null) {
			res.setRespuesta("Registrado Guardado Exitosamente.");
		}else {
			res.setRespuesta("Error Registrado Guardado Exitosamente.");
		}
		return ResponseEntity.ok(res);
	}
	
	//End point para actualizar el listado de registros a procesar 
	@PostMapping("/update")
	public ResponseEntity<List<Respuesta>> updateRegister(@RequestBody List<Register> registros){
		List<Respuesta> respuestas = new ArrayList<Respuesta>();
		registros.stream().forEach(reg ->{
			Register r = registerDAO.updateRegister(reg);
			Respuesta res = new Respuesta();
			if(r != null) {
				res.setRespuesta("Registro Actualizado Exitosamente "+ r.getId()+".");
			}else {
				res.setRespuesta("Error Actualizando.");
			}
			respuestas.add(res);
		});
		
		return ResponseEntity.ok(respuestas);
	}
}
