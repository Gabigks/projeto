package br.edu.projeto.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.projeto.dao.ServicoDAO;
import br.edu.projeto.model.Servico;

@Named
@ViewScoped
public class ServicoController implements Serializable {
	@Inject
	private FacesContext facesContext;
	
	@Inject
    private ServicoDAO ServicoDAO;
	
	private List<Servico>itens;
	
	@PostConstruct
    public void init() {
    	//Verifica se usuário está autenticado e possui a permissão adequada
//    	if (!this.facesContext.getExternalContext().isUserInRole("ADMINISTRADOR")) {
//    		try {
//				this.facesContext.getExternalContext().redirect("login-error.xhtml");
//			} catch (IOException e) {e.printStackTrace();}
//    	}
    	//Inicializa elementos importantes
    	this.itens = ServicoDAO.listarTodos();
    }

	public List<Servico> getitens() {
		return itens;
	}

	public void setitens(List<Servico> itens) {
		this.itens = itens;
	}
	
	
	
}
