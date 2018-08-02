package br.com.prematricula.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prematricula.exception.RegisterNotFoundException;
import br.com.prematricula.model.Coordenador;
import br.com.prematricula.repository.CoordenadorRepository;

@Service
public class CoordenadorService {
	
	@Autowired
	CoordenadorRepository coordenadorRepository;
	
	public Coordenador cadastrar(Coordenador coordenador) {
		return coordenadorRepository.save(coordenador);
	}
	
	public Collection<Coordenador> buscarTodos(){
		return coordenadorRepository.findAll();
	}
	
	public Coordenador excluir(Integer id) throws Exception{
	Coordenador coordenador = coordenadorRepository.findOne(id);
		
		if(coordenador == null) {
			throw new RegisterNotFoundException("Esse coordenador nao existe!");
		}
		
		coordenadorRepository.delete(coordenador);
		
		return coordenador;
	}
	public Coordenador atualizarSenha(Coordenador coordenador,Integer id) throws Exception {
		Coordenador coordenadorAprocurar = coordenadorRepository.findOne(id);
		
		if(coordenadorAprocurar == null) {
			throw new RegisterNotFoundException("Essa disciplina nao existe!");
		}
		
		coordenadorRepository.delete(coordenador);

		Coordenador newCoordenador = coordenador;
		
		newCoordenador.setSenha(coordenador.getSenha());
		
		coordenadorRepository.save(newCoordenador);
		
		return newCoordenador;
	}
	public Integer encontrarIdPorEmail(String email) {
		Collection<Coordenador> coordenadores = coordenadorRepository.findAll();
		for (Coordenador coordenador : coordenadores) {
			if(coordenador.getEmail().equalsIgnoreCase(email)) {
				return coordenador.getIdCoordenador();
			}
		}
		return -1;
	}
}
