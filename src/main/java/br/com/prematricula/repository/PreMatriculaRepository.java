package br.com.prematricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.prematricula.model.PreMatricula;

@Repository
public interface PreMatriculaRepository extends JpaRepository<PreMatricula, String>{ 
}

