package br.ufrn.imd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufrn.imd.model.Carro;

public class CarroDao extends GenericDAO{

	public ArrayList<Carro> listar() {
		EntityManager em = getEntityManager();
		Query query = em.createQuery("Select c from Carro c");
		List<Carro> results = new ArrayList<Carro>();
		results = query.getResultList();
		return (ArrayList<Carro>) results;
	}
	
}
