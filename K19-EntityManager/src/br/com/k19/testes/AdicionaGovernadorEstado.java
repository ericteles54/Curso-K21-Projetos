package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Estado;
import br.com.k19.modelo.Governador;

public class AdicionaGovernadorEstado {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_entity_manager_pu");
		EntityManager manager = factory.createEntityManager();
	
		manager.getTransaction().begin();
		
		Governador g = new Governador();
		g.setNome("Rafael Consentino");
		
		Estado e = new Estado();
		e.setNome("São Paulo");
		
		g.setEstado(e);
		
		manager.persist(e);
		manager.persist(g);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
}
