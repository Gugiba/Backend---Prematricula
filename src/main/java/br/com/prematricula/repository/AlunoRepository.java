package br.com.prematricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prematricula.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,Integer> {

}
