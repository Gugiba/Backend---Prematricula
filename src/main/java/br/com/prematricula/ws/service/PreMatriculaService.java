package br.com.prematricula.ws.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prematricula.ws.model.Aluno;
import br.com.prematricula.ws.model.PreMatricula;
import br.com.prematricula.ws.repository.AlunoRepository;
import br.com.prematricula.ws.repository.PreMatriculaRepository;

@Service
public class PreMatriculaService {

	
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	PreMatriculaRepository preMatricularepository;
	
	public void matriculasCount(){
		
		Collection<Aluno> alunos = alunoRepository.findAll();
		
		for (Aluno aluno : alunos) {
			ArrayList<String> cadeiras = aluno.getDisciplinasPreMatriculadas();
			for(String cadeira : cadeiras) {
				
				
				
				if(!checarExistencia(cadeira))
					
					addCadeira(cadeira);
				
				else { 
				incrementaVagas(cadeira);
				}
				
			}
		}
		
	}
	
	public Collection<PreMatricula> getPreMatriculas(){
		return preMatricularepository.findAll();
	}
	
	
	private void incrementaVagas(String cadeira) {
		PreMatricula cadeiraExistente = preMatricularepository.findOne(cadeira);
		cadeiraExistente.incrementeVagas();
		
	}


	private void addCadeira(String cadeira) {
		PreMatricula cadeiraAserAdicionada = new PreMatricula();
		cadeiraAserAdicionada.setCadeira(cadeira);
		cadeiraAserAdicionada.setVagasSolicitadas(1);
		preMatricularepository.save(cadeiraAserAdicionada);
		
	}


	private boolean checarExistencia(String cadeira) {
		PreMatricula cadeiraAchecar = preMatricularepository.findOne(cadeira);
		
		if(cadeiraAchecar == null)
			return false;
		
		return true;
	}
	
}
