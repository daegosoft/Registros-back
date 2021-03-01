package com.registros.app.entities;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Respuesta {
	private String respuesta;
	@Transient
	private JsonNode json;

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	public void setJsonString(String jsonString) {
	    // parse from String to JsonNode object
	    ObjectMapper mapper = new ObjectMapper();
	    try {
	      this.json = mapper.readTree(jsonString);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
}
