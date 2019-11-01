package br.ufrn.imd.dao;

import javax.persistence.EntityManager;

public class GenericDAO {
	
	public void inserir (Object entidade){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
	}
	
	public void excluir(Object entidade){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit();
	}
	
	public void atualizar(Object entidade){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
	}
	
	public Object findById(Class classe , long id){
		EntityManager em = getEntityManager();
		return em.find(classe, id);
	}
	
	protected EntityManager getEntityManager(){
		return Banco.getInstance().getEntityManager();
	}

}
