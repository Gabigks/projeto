package br.edu.projeto.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.FilterMeta;

import br.edu.projeto.dao.ItemDAO;
import br.edu.projeto.model.Item;


@Named("dtItemView")
@ViewScoped
public class ItemView implements Serializable{
	private List<Item> ItemesTabela;
<<<<<<< Updated upstream
    private Item ItemSelecionado;
    private List<Item> ItemesSelecionados;
=======
    private Item ItemSelecionado ;
    private List<Item> itemesSelecionados =new ArrayList<Item>();
>>>>>>> Stashed changes
    @Inject
    private ItemDAO ItemDAO;
    
    private List<FilterMeta> filterBy;
    
    private double valorFinal;
    
<<<<<<< Updated upstream
    
    @PostConstruct
    public void init() {
    	ItemesTabela = ItemDAO.listarTodos();
=======
    @PostConstruct
    public void init() {
    	ItemesTabela = ItemDAO.listarTodos();

//    	quantidade= 0d;
>>>>>>> Stashed changes
    }

	public List<Item> getItemesTabela() {
		return ItemesTabela;
	}


	public void setItemesTabela(List<Item> ItemesTabela) {
		this.ItemesTabela = ItemesTabela;
	}


	public Item getItemSelecionado() {
		return ItemSelecionado;
	}


	public void setItemSelecionado(Item ItemSelecionado) {
		this.ItemSelecionado = ItemSelecionado;
	}


	public List<Item> getItemesSelecionados() {
		return itemesSelecionados;
	}


	public void setItemesSelecionados(List<Item> itemesSelecionados) {
		this.itemesSelecionados = itemesSelecionados;
		
	}

	public ItemDAO getItemDAO() {
		return ItemDAO;
	}


	public void setItemDAO(ItemDAO ItemDAO) {
		this.ItemDAO = ItemDAO;
	}
	
<<<<<<< Updated upstream

	
		
		
=======
	public void attQTD() {
		Item i = ItemSelecionado;
		this.valorFinal += i.getQuantidade() * i.getCustoun();
	}

	public double getValorFinal() {
		return valorFinal;
	}


	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}

>>>>>>> Stashed changes

	public List<FilterMeta> getFilterBy() {
		return filterBy;
	}


	public void setFilterBy(List<FilterMeta> filterBy) {
		this.filterBy = filterBy;
	}
	
	public void onRowSelectCheckbox(SelectEvent event) {
		this.ItemSelecionado = ((Item) event.getObject());
	}
	
}
