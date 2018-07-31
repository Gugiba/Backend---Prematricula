package br.com.prematricula.ws.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.prematricula.ws.model.Aluno;
import br.com.prematricula.ws.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;
	
	
	
	public Aluno cadastrar(Aluno aluno){
	
		return alunoRepository.save(aluno);
	}
	
	public Collection<Aluno> buscarTodos(){
		return alunoRepository.findAll();
	}
	
	
	
	
	public Aluno buscaEmail(String email) {
		Collection<Aluno> alunos = alunoRepository.findAll();
		for (Aluno aluno : alunos) {
			if(aluno.getEmail().equalsIgnoreCase(email)) {
				return aluno;
			}
		}
		return null;
		
	}
	
	
	
	public Aluno alteraAluno(Aluno aluno) {
		
		return alunoRepository.save(aluno);
	}
	
}
