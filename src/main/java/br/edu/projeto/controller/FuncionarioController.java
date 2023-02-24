package br.edu.projeto.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.projeto.dao.FuncionarioDAO;
import br.edu.projeto.model.Funcionario;


@Named
@ViewScoped
public class FuncionarioController implements Serializable{
	
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
    private FuncionarioDAO FuncionarioDAO;
	
	private List<Funcionario>Funcionarioes;
	
	@PostConstruct
    public void init() {
    	//Verifica se usuário está autenticado e possui a permissão adequada
//    	if (!this.facesContext.getExternalContext().isUserInRole("ADMINISTRADOR")) {
//    		try {
//				this.facesContext.getExternalContext().redirect("login-error.xhtml");
//			} catch (IOException e) {e.printStackTrace();}
//    	}
    	//Inicializa elementos importantes
    	this.Funcionarioes = FuncionarioDAO.listarTodos();
    }

	public List<Funcionario> getFuncionarioes() {
		return Funcionarioes;
	}

	public void setFuncionarioes(List<Funcionario> Funcionarioes) {
		this.Funcionarioes = Funcionarioes;
	}

}
