package br.com.prematricula.ws.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cadeiras")
public class Disciplina {
	
	
	
	@Id
	private Integer codigo_disciplina;
	
	@Column(nullable = false)
	private String disciplina;
	@Column
	private Double semestre;
	@Column
	private ArrayList<Integer> pos_Requisitos;
	@Column
	private Double creditos;
	@Column
	private String tipo;
	@Column
	private ArrayList<Integer> pre_Requisitos;
	@Column
	private Integer codigo_departamento;
	@Column
	private Double horas;
	
	
	
	public Integer getCodigo_disciplina() {
		return codigo_disciplina;
	}

	public void setCodigo_disciplina(Integer codigo_disciplina) {
		this.codigo_disciplina = codigo_disciplina;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Double getSemestre() {
		return semestre;
	}

	public void setSemestre(Double semestre) {
		this.semestre = semestre;
	}

	public ArrayList<Integer> getPos_Requisitos() {
		return pos_Requisitos;
	}

	public void setPos_Requisitos(ArrayList<Integer> pos_Requisitos) {
		this.pos_Requisitos = pos_Requisitos;
	}

	public Double getCreditos() {
		return creditos;
	}

	public void setCreditos(Double creditos) {
		this.creditos = creditos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ArrayList<Integer> getPre_Requisitos() {
		return pre_Requisitos;
	}

	public void setPre_Requisitos(ArrayList<Integer> pre_Requisitos) {
		this.pre_Requisitos = pre_Requisitos;
	}

	public Integer getCodigo_departamento() {
		return codigo_departamento;
	}

	public void setCodigo_departamento(Integer codigo_departamento) {
		this.codigo_departamento = codigo_departamento;
	}

	public Double getHoras() {
		return horas;
	}

	public void setHoras(Double horas) {
		this.horas = horas;
	}

	
	
	
	
}


	
