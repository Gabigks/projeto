package br.edu.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.projeto.model.Fornecedor;

public class FornecedorDAO implements Serializable{
	@Inject
	//Cria a conexão e controla a transação com o SGBD (usado pelo Hibernate)
    private EntityManager em;
	
	public Fornecedor encontrarId(String id) {
       // return em.find(Cliente.class, id);
		return em.find(Fornecedor.class, id);
        
    }
	
	//Query usando a API Criteria do Hibernate
	//Indicada para consultas complexas
//	public Boolean ehUsuarioUnico(String u) {
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Cliente> criteria = cb.createQuery(Cliente.class);
//        Root<Cliente> cliente = criteria.from(Cliente.class);
//        criteria.select(cliente);
//        criteria.where(cb.like(cliente.get("cliente"), u));
//        if (em.createQuery(criteria).getResultList().isEmpty())
//        	return true;
//        return false;
//    }
	
	//Query usando a linguagem HQL do Hibernate
	//Idnicada para consultas simples
	public List<Fornecedor> listarTodos() {
	    return em.createQuery("SELECT f FROM Fornecedor f ", Fornecedor.class).getResultList();      
	}
	
//	public void salvar(Fornecedor f) {
//		em.persist(f);
//	}
//	
//	public void atualizar(Fornecedor f) {
//		em.merge(f);
//	}
//	
//	public void excluir(Fornecedor f) {
//		em.remove(em.getReference(Fornecedor.class, f.getCnpj()));
//	}
}
