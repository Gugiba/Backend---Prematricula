package br.com.prematricula.ws.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prematricula.exception.RegisterNotFoundException;

import br.com.prematricula.ws.model.Disciplina;
import br.com.prematricula.ws.repository.DisciplinaRepository;



@Service
public class DisciplinaService {
	
	@Autowired
	DisciplinaRepository disciplinaRepository;
	

	public Disciplina add(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
	
	public Collection<Disciplina> buscarTodos() {
		return disciplinaRepository.findAll();
	}
	
	
	public Disciplina BuscaId(Integer id) throws Exception {
		Disciplina disciplina = disciplinaRepository.findOne(id);
		
		if(disciplina == null) {
			throw new RegisterNotFoundException("Essa disciplina nao existe!");
		}
		
		return disciplina;
	}

	public Disciplina excluir(Integer id) throws Exception{
		Disciplina disciplina = disciplinaRepository.findOne(id);
		
		if(disciplina == null) {
			throw new RegisterNotFoundException("Essa disciplina nao existe!");
		}
		
		disciplinaRepository.delete(disciplina);
		
		return disciplina;
	}
	
	public Disciplina alterar(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
	
	public Disciplina update(Disciplina disciplina, int id) throws Exception {
		Disciplina disciplinaASerApagada = disciplinaRepository.findOne(id);
		
		if(disciplina == null | disciplinaASerApagada == null) {
			throw new RegisterNotFoundException("Essa disciplina nao existe!");
		}
		
		disciplinaRepository.delete(disciplinaASerApagada);
		
		disciplinaRepository.save(disciplina);
		
		return disciplina;
	}
}
