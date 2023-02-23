package br.edu.projeto.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.MatchMode;

import br.edu.projeto.dao.ClienteDAO;
import br.edu.projeto.model.Cliente;

@Named("dtClienteView")
@ViewScoped
public class ClienteView implements Serializable{
	
	private List<Cliente> clientesTabela;
    private Cliente clienteSelecionado;
    private List<Cliente> clientesSelecionados;
    @Inject
    private ClienteDAO clienteDAO;
    
    private List<FilterMeta> filterBy;
    
    
    @PostConstruct
    public void init() {
    	clientesTabela=clienteDAO.listarTodos();

//        filterBy.add(FilterMeta.builder()
//                .field("cnpj")
//                .filterValue(clienteSelecionado.getCnpj())
//                .matchMode(MatchMode.EQUALS)
//                .build());

//        filterBy.add(FilterMeta.builder()
//                .field("dt_")
//                .filterValue(new ArrayList<>(Arrays.asList(LocalDate.now().minusDays(28), LocalDate.now().plusDays(28))))
//                .matchMode(MatchMode.BETWEEN)
//                .build());
    	   
    }


	public List<Cliente> getClientesTabela() {
		return clientesTabela;
	}


	public void setClientesTabela(List<Cliente> clientesTabela) {
		this.clientesTabela = clientesTabela;
	}


	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}


	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}


	public List<Cliente> getClientesSelecionados() {
		return clientesSelecionados;
	}


	public void setClientesSelecionados(List<Cliente> clientesSelecionados) {
		this.clientesSelecionados = clientesSelecionados;
	}


	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}


	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}


	public List<FilterMeta> getFilterBy() {
		return filterBy;
	}


	public void setFilterBy(List<FilterMeta> filterBy) {
		this.filterBy = filterBy;
	}
	
	
    
    
    
    
    

	
	
	
	

}
