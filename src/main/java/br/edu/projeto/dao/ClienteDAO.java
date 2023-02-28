package br.edu.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import br.edu.projeto.model.Cliente;

public class ClienteDAO implements Serializable{

	@Inject
    private EntityManager em;
	
	@Resource
	private UserTransaction transaction;
	
	public Cliente encontrarId(String id) {
		return em.find(Cliente.class, id);
        
    }
	
	public List<Cliente> listarTodos() {
	    return em.createQuery("SELECT c FROM Cliente c ", Cliente.class).getResultList();      
	}
	
	public void salvar(Cliente c) {
		 try{ 
	            transaction.begin();
	            em.persist(c);
	            transaction.commit();
	        } catch(Exception e){
				e.printStackTrace();
			}
	}

	public void atualizar(Cliente c) {
		em.merge(c);
	}
	
	public void excluir(Cliente c) {
		em.remove(em.getReference(Cliente.class, c.getCnpj()));
	}
	
}
