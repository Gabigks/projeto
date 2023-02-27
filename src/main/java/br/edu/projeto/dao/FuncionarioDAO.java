package br.edu.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.projeto.model.Funcionario;

public class FuncionarioDAO implements Serializable {
	
	@Inject
	//Cria a conexão e controla a transação com o SGBD (usado pelo Hibernate)
    private EntityManager em;
	
	public Funcionario encontrarId(String id) {
       // return em.find(Funcionario.class, id);
		return em.find(Funcionario.class, id);
        
    }
	
	//Query usando a API Criteria do Hibernate
	//Indicada para consultas complexas
//	public Boolean ehUsuarioUnico(String u) {
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Funcionario> criteria = cb.createQuery(Funcionario.class);
//        Root<Funcionario> Funcionario = criteria.from(Funcionario.class);
//        criteria.select(Funcionario);
//        criteria.where(cb.like(Funcionario.get("Funcionario"), u));
//        if (em.createQuery(criteria).getResultList().isEmpty())
//        	return true;
//        return false;
//    }
	
	//Query usando a linguagem HQL do Hibernate
	//Idnicada para consultas simples
	public List<Funcionario> listarTodos() {
	    return em.createQuery("SELECT f FROM Funcionario f ", Funcionario.class).getResultList();      
	}
	
	public void salvar(Funcionario c) {
		em.persist(c);
	}
	
	public void atualizar(Funcionario c) {
		em.merge(c);
	}
	
	public void excluir(Funcionario c) {
		em.remove(em.getReference(Funcionario.class, c.getCpf()));
	}

}
