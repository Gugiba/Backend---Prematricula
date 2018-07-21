package br.com.prematricula.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.prematricula.ws.model.Aluno;
import br.com.prematricula.ws.service.AlunoService;

@RestController
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "api/aluno/post")
	public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno){
		
		Aluno alunoCadastrado = alunoService.cadastrar(aluno);
		return new ResponseEntity<> (alunoCadastrado,HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "api/aluno/get",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Aluno>> buscarTodosAlunos(){
		
		Collection<Aluno> alunosBuscados = alunoService.buscarTodos();
		
		return new ResponseEntity<> (alunosBuscados,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "api/aluno/get/{matricula}", method = RequestMethod.GET)
	public Aluno getById(@PathVariable("matricula") Long matricula) {
		return alunoService.buscarPorMatricula(matricula);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "api/aluno/put",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Aluno> alterarAluno(Aluno aluno){
		
		Aluno alunoAlterado = alunoService.alteraAluno(aluno);
		
		return new ResponseEntity<> (alunoAlterado,HttpStatus.OK);
		
	}
	
	
	
}
