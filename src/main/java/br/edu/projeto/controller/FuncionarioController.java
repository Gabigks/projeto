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

import br.edu.projeto.dao.FuncionarioDAO;
import br.edu.projeto.model.Funcionario;


@Named
@ViewScoped
public class FuncionarioController implements Serializable{
	
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
    private FuncionarioDAO FuncionarioDAO;
	
	private List<Funcionario>Funcionarios;
	

	private Funcionario funcionario;
	
	@PostConstruct
    public void init() {
    	//Verifica se usuário está autenticado e possui a permissão adequada
//    	if (!this.facesContext.getExternalContext().isUserInRole("ADMINISTRADOR")) {
//    		try {
//				this.facesContext.getExternalContext().redirect("login-error.xhtml");
//			} catch (IOException e) {e.printStackTrace();}
//    	}
    	//Inicializa elementos importantes
    	this.Funcionarios = FuncionarioDAO.listarTodos();
    }
	
	

	public Funcionario getFuncionario() {
		return funcionario;
	}



	public void setFuncionario(Funcionario Funcionario) {
		this.funcionario = Funcionario;
	}



	




	public List<Funcionario> getFuncionarios() {
		return Funcionarios;
	}



	public void setFuncionarios(List<Funcionario> funcionarios) {
		Funcionarios = funcionarios;
	}



	public void novoCadastro() {
        this.setFuncionario(new Funcionario());
    }


	public void salvar() {
      //  if (usuarioValido()) {
    	//	this.usuario.getPermissoes().clear();
    	//	for (Integer id: this.permissoesSelecionadas) {
    	//		TipoPermissao permissao = tipoPermissaoDAO.encontrarPermissao(id);
    	//		permissao.addUsuario(this.usuario);	
    	//	}
		
		
        

		try {

			if (this.funcionario.getCpf() != null) {
				this.FuncionarioDAO.salvar(this.funcionario);
				
				this.facesContext.addMessage(null, new FacesMessage("Funcionario Criado"));
			} else {
				this.FuncionarioDAO.atualizar(this.funcionario);
				this.facesContext.addMessage(null, new FacesMessage("Funcionario Atualizado"));
			}
			this.Funcionarios = FuncionarioDAO.listarTodos();
			// Atualiza e executa elementos Javascript na tela assincronamente
			PrimeFaces.current().executeScript("PF('FuncionarioDialog').hide()");
			PrimeFaces.current().ajax().update("form:mensagens", "form:Funcionario");
		} catch (Exception e) {
			String errorMessage = getMensagemErro(e);
			this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, null));
		}
	}

	public void remover() {
		try {
			this.FuncionarioDAO.excluir(this.funcionario);
			this.Funcionarios = FuncionarioDAO.listarTodos();
	        this.funcionario= null;
	        this.facesContext.addMessage(null, new FacesMessage("Funcionario Removido"));
	        PrimeFaces.current().ajax().update("form:mensagens", "form:Funcionario");//table
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
	
	
	
	
	

}
