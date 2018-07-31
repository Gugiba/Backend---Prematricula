package br.com.prematricula.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prematricula.ws.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,String> {

}
