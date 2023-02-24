package br.edu.projeto.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.FilterMeta;

import br.edu.projeto.dao.FuncionarioDAO;
import br.edu.projeto.model.Funcionario;


@Named("dtFuncionarioView")
@ViewScoped
public class FuncionarioView implements Serializable{
	private List<Funcionario> FuncionarioesTabela;
    private Funcionario FuncionarioSelecionado;
    private List<Funcionario> FuncionarioesSelecionados;
    @Inject
    private FuncionarioDAO FuncionarioDAO;
    
    private List<FilterMeta> filterBy;
    
    
    @PostConstruct
    public void init() {
    	FuncionarioesTabela = FuncionarioDAO.listarTodos();
    }


	public List<Funcionario> getFuncionarioesTabela() {
		return FuncionarioesTabela;
	}


	public void setFuncionarioesTabela(List<Funcionario> FuncionarioesTabela) {
		this.FuncionarioesTabela = FuncionarioesTabela;
	}


	public Funcionario getFuncionarioSelecionado() {
		return FuncionarioSelecionado;
	}


	public void setFuncionarioSelecionado(Funcionario FuncionarioSelecionado) {
		this.FuncionarioSelecionado = FuncionarioSelecionado;
	}


	public List<Funcionario> getFuncionarioesSelecionados() {
		return FuncionarioesSelecionados;
	}


	public void setFuncionarioesSelecionados(List<Funcionario> FuncionarioesSelecionados) {
		this.FuncionarioesSelecionados = FuncionarioesSelecionados;
	}


	public FuncionarioDAO getFuncionarioDAO() {
		return FuncionarioDAO;
	}


	public void setFuncionarioDAO(FuncionarioDAO FuncionarioDAO) {
		this.FuncionarioDAO = FuncionarioDAO;
	}


	public List<FilterMeta> getFilterBy() {
		return filterBy;
	}


	public void setFilterBy(List<FilterMeta> filterBy) {
		this.filterBy = filterBy;
	}
    
}
