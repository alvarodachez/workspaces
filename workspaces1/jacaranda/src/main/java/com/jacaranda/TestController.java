package com.jacaranda;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/public-api")
public class TestController {
	private Logger logger = org.slf4j.LoggerFactory.getLogger(TestController.class);	
	@RequestMapping(path="/prueba", method = RequestMethod.GET)
	public String prueba() {
		logger.info("Metodo prueba llamado correctamente");
		//logger.error("ERROR");
		//logger.warn("WARNING");
		return "Prueba Correcta";
	}
	
	@GetMapping(path="/prueba2")
	public String pruebaGetMapping() {
		
		return "Prueba de GetMapping Correcta";
	}
	
	@PostMapping(path="/usuarios")
	public String pruebaPostMapping(@RequestBody String nombre) {
		return "Tu nombre es "+nombre;
	}
	
	@PostMapping(path="/usuarios/{nombre}")
	public String pruebaPostMappingURL(@PathVariable String nombre) {
		return "Tu nombre es "+nombre;
	}
	
	@PutMapping(path="/usuariosModificados")
	public String pruebaPutMapping(@RequestParam String nombre) {
		return "El nombre modificado es "+nombre;
	}
	
	@DeleteMapping(path="/usuariosBorrados")
	public String pruebaDeleteMapping(@RequestParam String nombre) {
		return "El usuario "+nombre+" ha sido borrado";
	}

}
