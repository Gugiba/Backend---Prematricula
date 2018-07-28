package br.com.prematricula.ws.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.prematricula.ws.model.Disciplina;
import br.com.prematricula.ws.service.DisciplinaService;



@Controller
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@RequestMapping(value = "/api/post", method = RequestMethod.POST)
	public ResponseEntity<Collection<Disciplina>> add(@RequestBody Collection<Disciplina> disciplinas) {
		return new ResponseEntity<>(disciplinaService.add(disciplinas),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/get", method = RequestMethod.GET)
	public ResponseEntity<Collection<Disciplina>> getDisciplina() {
		Collection<Disciplina> disciplinas = disciplinaService.buscarTodos();
		return new ResponseEntity<>(disciplinas, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/put/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Disciplina> setDisciplina(@PathVariable("id") int id, @RequestBody Disciplina disciplina) throws Exception {
		Disciplina disciplinaAlterada = disciplinaService.update(disciplina, id);
		return new ResponseEntity<>(disciplinaAlterada,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/{id}", method = RequestMethod.GET)
	public ResponseEntity<Disciplina> buscaId(@PathVariable("id") Integer id) throws Exception {
		return new ResponseEntity<>(disciplinaService.BuscaId(id), HttpStatus.OK);
	}
	@RequestMapping(value = "/api/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Disciplina> deleteDisciplina(@PathVariable("id") Integer id) throws Exception {
		return new ResponseEntity<>(disciplinaService.excluir(id), HttpStatus.OK);
	}
}
