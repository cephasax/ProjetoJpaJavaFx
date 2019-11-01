package br.ufrn.imd.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Banco {
	
	private static Banco singleton = new Banco();
	private static EntityManager em;
	
	private Banco() {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("ConexaoDB");
		em = entityManagerFactory.createEntityManager();
	}

	public static Banco getInstance() {
		return singleton;
	}

	public EntityManager getEntityManager() {
		return em;
	}
}





