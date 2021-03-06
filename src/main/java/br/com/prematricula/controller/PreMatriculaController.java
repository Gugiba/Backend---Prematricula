package br.com.prematricula.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.prematricula.model.PreMatricula;
import br.com.prematricula.service.PreMatriculaService;

@CrossOrigin(origins = "*")
@RestController
public class PreMatriculaController {
	
	@Autowired
	PreMatriculaService preMatriculaService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/prematricula/api",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<PreMatricula>> buscandoMatriculas(){
		
		preMatriculaService.matriculasCount();
		Collection<PreMatricula> matriculasBuscados = preMatriculaService.getPreMatriculas();
		
		return new ResponseEntity<> (matriculasBuscados,HttpStatus.OK);
		
	}
}
