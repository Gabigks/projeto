package br.edu.projeto.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.FilterMeta;

import br.edu.projeto.dao.ServicoDAO;
import br.edu.projeto.model.Servico;


@Named("dtServicoView")
@ViewScoped
public class ServicoView implements Serializable{
	private List<Servico> ServicoesTabela;
    private Servico ServicoSelecionado;
    private List<Servico> ServicoesSelecionados;
    @Inject
    private ServicoDAO ServicoDAO;
    
    private List<FilterMeta> filterBy;
    
    
    @PostConstruct
    public void init() {
    	ServicoesTabela = ServicoDAO.listarTodos();
    }


	public List<Servico> getServicoesTabela() {
		return ServicoesTabela;
	}


	public void setServicoesTabela(List<Servico> ServicoesTabela) {
		this.ServicoesTabela = ServicoesTabela;
	}


	public Servico getServicoSelecionado() {
		return ServicoSelecionado;
	}


	public void setServicoSelecionado(Servico ServicoSelecionado) {
		this.ServicoSelecionado = ServicoSelecionado;
	}


	public List<Servico> getServicoesSelecionados() {
		return ServicoesSelecionados;
	}


	public void setServicoesSelecionados(List<Servico> ServicoesSelecionados) {
		this.ServicoesSelecionados = ServicoesSelecionados;
	}


	public ServicoDAO getServicoDAO() {
		return ServicoDAO;
	}


	public void setServicoDAO(ServicoDAO ServicoDAO) {
		this.ServicoDAO = ServicoDAO;
	}


	public List<FilterMeta> getFilterBy() {
		return filterBy;
	}


	public void setFilterBy(List<FilterMeta> filterBy) {
		this.filterBy = filterBy;
	}
    
}
