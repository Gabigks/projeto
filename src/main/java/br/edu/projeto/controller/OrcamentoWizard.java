package br.edu.projeto.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;

import br.edu.projeto.model.Orcamento;

@Named
@ViewScoped
public class OrcamentoWizard implements Serializable{
    private Orcamento orcamento = new Orcamento();

    private boolean skip;
    


    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public void save() {
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + orcamento.getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false; //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }


    
    
    
    
}
