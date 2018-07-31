package br.com.prematricula.ws.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PreMatricula")
public class PreMatricula {

	

		
		@Id
		private String cadeira;
		
		@Column
		private Integer vagasSolicitadas;

		public String getCadeira() {
			return cadeira;
		}

		public void setCadeira(String cadeira) {
			this.cadeira = cadeira;
		}

		public Integer getVagasSolicitadas() {
			return vagasSolicitadas;
		}

		public void incrementeVagas() {
			if(vagasSolicitadas == null) {
				this.vagasSolicitadas = 1;
			}
			this.vagasSolicitadas++;
		}
		
		public void setVagasSolicitadas(int vagas) {
			this.vagasSolicitadas = vagas;
		}
		
		
		
}
