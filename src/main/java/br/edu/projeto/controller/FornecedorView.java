package br.edu.projeto.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.FilterMeta;

import br.edu.projeto.dao.FornecedorDAO;
import br.edu.projeto.model.Fornecedor;


@Named("dtFornecedorView")
@ViewScoped
public class FornecedorView implements Serializable{
	private List<Fornecedor> fornecedoresTabela;
    private Fornecedor fornecedorSelecionado;
    private List<Fornecedor> fornecedoresSelecionados;
    @Inject
    private FornecedorDAO fornecedorDAO;
    
    private List<FilterMeta> filterBy;
    
    
    @PostConstruct
    public void init() {
    	fornecedoresTabela = fornecedorDAO.listarTodos();
    }


	public List<Fornecedor> getFornecedoresTabela() {
		return fornecedoresTabela;
	}


	public void setFornecedoresTabela(List<Fornecedor> fornecedoresTabela) {
		this.fornecedoresTabela = fornecedoresTabela;
	}


	public Fornecedor getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}


	public void setFornecedorSelecionado(Fornecedor fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}


	public List<Fornecedor> getFornecedoresSelecionados() {
		return fornecedoresSelecionados;
	}


	public void setFornecedoresSelecionados(List<Fornecedor> fornecedoresSelecionados) {
		this.fornecedoresSelecionados = fornecedoresSelecionados;
	}


	public FornecedorDAO getFornecedorDAO() {
		return fornecedorDAO;
	}


	public void setFornecedorDAO(FornecedorDAO fornecedorDAO) {
		this.fornecedorDAO = fornecedorDAO;
	}


	public List<FilterMeta> getFilterBy() {
		return filterBy;
	}


	public void setFilterBy(List<FilterMeta> filterBy) {
		this.filterBy = filterBy;
	}
    
}
