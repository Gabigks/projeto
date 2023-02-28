package br.edu.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import br.edu.projeto.model.Servico;

public class ServicoDAO implements Serializable {
	
	@Inject
    private EntityManager em;
	
	@Resource
	private UserTransaction transaction;
	
	public Servico encontrarId(String id) {
		return em.find(Servico.class, id);
        
    }

	public List<Servico> listarTodos() {
	    return em.createQuery("SELECT s FROM Servico s ", Servico.class).getResultList();      
	}
	
	public void salvar(Servico s) {    
		 try{ 
	            transaction.begin();
	            em.persist(s);
	            transaction.commit();
	        } catch(Exception e){
				e.printStackTrace();
			}
	}
	
	public void atualizar(Servico s) {
		em.merge(s);
	}
	
	public void excluir(Servico s) {
		em.remove(em.getReference(Servico.class, s.getId()));
	}

}
