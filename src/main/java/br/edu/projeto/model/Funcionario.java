package br.edu.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
	@CPF
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cpf;
	
	@NotNull
	private String cargo;
	
	@NotNull
	private String nome;
	
	@NotNull
	private Double vlhora;

	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getVlhora() {
		return vlhora;
	}

	public void setVlhora(Double vlhora) {
		this.vlhora = vlhora;
	}
	
}
