package br.com.prematricula.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Coordenador")
public class Coordenador {
	
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String senha;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_Coordenador;

	public String getEmail() {
		
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getIdCoordenador() {
		return id_Coordenador;
	}
	public void setIdCoordenador(Integer idCoordenador) {
		this.id_Coordenador = idCoordenador;
	}
	

}
