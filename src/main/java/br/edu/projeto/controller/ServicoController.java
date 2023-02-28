package br.edu.projeto.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.edu.projeto.dao.ServicoDAO;
import br.edu.projeto.model.Servico;

@Named
@ViewScoped
public class ServicoController implements Serializable {
	@Inject
	private FacesContext facesContext;
	
	@Inject
    private ServicoDAO servicoDAO;
	
	private List<Servico>servicos;
	
	private Servico servico;
	
	@PostConstruct
    public void init() {
    	this.servicos = servicoDAO.listarTodos();
    }
		
	public void salvar() {
		try {
			if (this.servico.getId() != null) {
				this.servicoDAO.salvar(this.servico);
				this.facesContext.addMessage(null, new FacesMessage("Serviço Criado"));
			} else {
				this.servicoDAO.atualizar(this.servico);
				this.facesContext.addMessage(null, new FacesMessage("Serviço Atualizado"));
			}
			this.servicos = servicoDAO.listarTodos();
			// Atualiza e executa elementos Javascript na tela assincronamente
			PrimeFaces.current().executeScript("PF('ServicoDialog').hide()");
			PrimeFaces.current().ajax().update("form:mensagens", "form:Servico");
		} catch (Exception e) {
			String errorMessage = getMensagemErro(e);
			this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, null));
		}
	}

	public void remover() {
		try {
			this.servicoDAO.excluir(this.servico);
			this.servicos = servicoDAO.listarTodos();
	        this.servico= null;
	        this.facesContext.addMessage(null, new FacesMessage("Serviço Removido"));
	        PrimeFaces.current().ajax().update("form:mensagens", "form:Servico");//table
        } catch (Exception e) {
            String errorMessage = getMensagemErro(e);
            this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, null));
        }
	}
	
	private String getMensagemErro(Exception e) {
	    String erro = "Falha no sistema!. Contacte o administrador do sistema.";
	    if (e == null) 
	        return erro;
	    Throwable t = e;
	    while (t != null) {
	        erro = t.getLocalizedMessage();
	        t = t.getCause();
	    }
	    return erro;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	public void novoCadastro() {
        this.setServico(new Servico());
    }

}
