package br.com.prematricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.prematricula.model.Coordenador;



@Repository
public interface CoordenadorRepository extends JpaRepository<Coordenador, Integer>{

}