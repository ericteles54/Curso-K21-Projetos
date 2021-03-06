package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Estado;

public class TestePersistenceContext {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_entity_manager_pu");
		EntityManager manager = factory.createEntityManager();
	
		manager.getTransaction().begin();
		
		System.out.println("------------- Primeiro find ---------------");
		Estado e = manager.find(Estado.class, 1L);
		System.out.println("Nome estado: " + e.getNome());
		System.out.println("------------- Segundo find ---------------");
		e = manager.find(Estado.class, 1L);
		System.out.println("Nome estado: " + e.getNome());
		System.out.println("------------- FIM find ---------------");

		manager.close();
		factory.close();
	}
}
