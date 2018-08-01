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
import br.com.prematricula.ws.model.PreMatricula;
import br.com.prematricula.ws.service.AlunoService;

@RestController
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "api/alunos/post")
	public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno){
		
		Aluno alunoCadastrado = alunoService.cadastrar(aluno);
		return new ResponseEntity<> (alunoCadastrado,HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "api/alunos/get",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Aluno>> buscarTodosAlunos(){
		
		Collection<Aluno> alunosBuscados = alunoService.buscarTodos();
		
		return new ResponseEntity<> (alunosBuscados,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "api/alunos/get/{nome1}@{nome2}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> getByemail(@PathVariable("nome1") String nome1,@PathVariable("nome2")String nome2) {
		
		Aluno alunoEncontrado = alunoService.buscaEmail(nome1 + "." + nome2 + "@ccc.ufcg.edu.br");
		
		if(alunoEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<> (alunoEncontrado,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "api/alunos/put",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Aluno> alterarAluno(@RequestBody Aluno aluno){
		
		Aluno alunoAlterado = alunoService.alteraAluno(aluno);
		
		return new ResponseEntity<> (alunoAlterado,HttpStatus.OK);
		
	}
	
	
}
