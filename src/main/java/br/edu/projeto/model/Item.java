package br.edu.projeto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "item")
public class Item {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private String id;
	
	@NotNull
	private Double custoun;
	
	@NotNull
	private String categoria;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String unmedida;
	
	@NotNull
	private String desc;
	
	@Transient
	private double quantidade;
	
	
	
	
	
//    @ManyToMany(mappedBy = "itens", fetch = FetchType.EAGER)
//    private List<Orcamento> orcamento= new ArrayList<Orcamento>();

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getCustoun() {
		return custoun;
	}

	public void setCustoun(Double custoun) {
		this.custoun = custoun;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUnmedida() {
		return unmedida;
	}

	public void setUnmedida(String unmedida) {
		this.unmedida = unmedida;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

//	public List<Orcamento> getOrcamento() {
//		return orcamento;
//	}
//
//	public void setOrcamento(List<Orcamento> orcamento) {
//		this.orcamento = orcamento;
//	}
	
}
