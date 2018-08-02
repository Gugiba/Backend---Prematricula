package br.com.prematricula.model;

import java.util.ArrayList;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Alunos")
public class Aluno {

	
	@Id
	private int matricula;
	
	@Column
	private String email;
	
	@Column(nullable = false)
	private String anoIngressado;
	
	@Column
	private ArrayList<String> disciplinasPreMatriculadas;

	
	
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAnoIngressado() {
		return anoIngressado;
	}

	public void setAnoIngressado(String anoIngressado) {
		this.anoIngressado = anoIngressado;
	}

	public ArrayList<String> getDisciplinasPreMatriculadas() {
		return disciplinasPreMatriculadas;
	}

	public void setDisciplinasPreMatriculadas(ArrayList<String> disciplinasPreMatriculadas) {
		this.disciplinasPreMatriculadas = disciplinasPreMatriculadas;
	}
	
	
	
	
	
	
	
}
