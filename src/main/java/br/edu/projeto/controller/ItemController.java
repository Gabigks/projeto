package br.edu.projeto.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.projeto.dao.ItemDAO;
import br.edu.projeto.model.Item;
@Named
@ViewScoped
public class ItemController implements Serializable{
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
    private ItemDAO itemDAO;
	
	private List<Item>itens;
	
	@PostConstruct
    public void init() {
    	//Verifica se usuário está autenticado e possui a permissão adequada
//    	if (!this.facesContext.getExternalContext().isUserInRole("ADMINISTRADOR")) {
//    		try {
//				this.facesContext.getExternalContext().redirect("login-error.xhtml");
//			} catch (IOException e) {e.printStackTrace();}
//    	}
    	//Inicializa elementos importantes
    	this.itens = itemDAO.listarTodos();
    }

	public List<Item> getitens() {
		return itens;
	}

	public void setitens(List<Item> itens) {
		this.itens = itens;
	}
	
}
	

