package br.com.prematricula.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.prematricula.ws.model.Coordenador;

import br.com.prematricula.ws.service.CoordenadorService;

@RestController
public class CoordenadorController {

	
	
	
	@Autowired
	CoordenadorService coordenadorService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/prematricula/coordenador")
	public ResponseEntity<Coordenador> cadastrarCoordenador(@RequestBody Coordenador coordenador){
		
		Coordenador coordenadorACadastrar = coordenadorService.cadastrar(coordenador);
		return new ResponseEntity<> (coordenadorACadastrar,HttpStatus.CREATED);
		
	}
	
	
	@RequestMapping(value = "/prematricula/coordenador", method = RequestMethod.GET)
	public ResponseEntity<Collection<Coordenador>> busca() {
		return new ResponseEntity<>(coordenadorService.buscarTodos(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/prematricula/coordenador/{email}", method = RequestMethod.PUT)
	public ResponseEntity<Coordenador> editarSenhar(@PathVariable("email") String emailCoordenador, @RequestBody Coordenador coordenador) throws Exception {
		Integer id = coordenadorService.encontrarIdPorEmail(emailCoordenador);
		
		Coordenador cord = coordenadorService.atualizarSenha(coordenador, id);
		return new ResponseEntity<>(cord,HttpStatus.OK);
	}
	
}
