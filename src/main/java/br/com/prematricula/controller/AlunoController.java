package br.com.prematricula.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.prematricula.model.Aluno;
import br.com.prematricula.model.CadastroDisciplinas;
import br.com.prematricula.service.AlunoService;

@CrossOrigin(origins = "*")
@RestController
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/prematricula/alunos")
	public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno){
		
		Aluno alunoCadastrado = alunoService.cadastrar(aluno);
		return new ResponseEntity<> (alunoCadastrado,HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/prematricula/alunos",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Aluno>> buscarTodosAlunos(){
		
		Collection<Aluno> alunosBuscados = alunoService.buscarTodos();
		
		return new ResponseEntity<> (alunosBuscados,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/prematricula/alunos/{matricula}", method = RequestMethod.POST)
	public ResponseEntity<Aluno> addcadeiras(@PathVariable("matricula") int matricula, @RequestBody CadastroDisciplinas cadeiras) {
		
		Aluno alunoEncontrado = alunoService.buscarPorMatricula(matricula);
		
		if(alunoEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		alunoEncontrado.setDisciplinasPreMatriculadas(cadeiras.getDisciplinas());
		alunoService.alteraAluno(alunoEncontrado);
		return new ResponseEntity<> (alunoEncontrado,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/prematricula/alunos",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Aluno> alterarAluno(@RequestBody Aluno aluno){
		
		Aluno alunoAlterado = alunoService.alteraAluno(aluno);
		
		return new ResponseEntity<> (alunoAlterado,HttpStatus.OK);
		
	}
	
	
	
	
}
