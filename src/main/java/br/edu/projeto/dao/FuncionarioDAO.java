package br.edu.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.UserTransaction;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.projeto.model.Funcionario;

public class FuncionarioDAO implements Serializable {
	
	@Inject
    private EntityManager em;
	
	@Resource
	private UserTransaction transaction;
	
	public Funcionario encontrarId(String id) {
		return em.find(Funcionario.class, id);
        
    }

	public List<Funcionario> listarTodos() {
	    return em.createQuery("SELECT f FROM Funcionario f ", Funcionario.class).getResultList();      
	}
	
	public void salvar(Funcionario c) {
        try{ 
            transaction.begin();
            em.persist(c);
            transaction.commit();
        } catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void atualizar(Funcionario c) {
		em.merge(c);
	}
	
	public void excluir(Funcionario c) {
		em.remove(em.getReference(Funcionario.class, c.getCpf()));
	}

}
