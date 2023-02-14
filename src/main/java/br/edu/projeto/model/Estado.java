package br.edu.projeto.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "estado")
public class Estado {

	@Id
	@NotNull
	private String sigla;
	
	@NotNull
	private String icms;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getIcms() {
		return icms;
	}

	public void setReal(String icms) {
		this.icms = icms;
	}
	
	
}
