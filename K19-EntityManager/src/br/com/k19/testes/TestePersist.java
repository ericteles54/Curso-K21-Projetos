package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TestePersist {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_entity_manager_pu");
		EntityManager manager = factory.createEntityManager();
		
		// ABRINDO A TRANSAÇÃO
		manager.getTransaction().begin();
		
		// OBJETO NO ESTADO NEW
		Pessoa p = new Pessoa();
		p.setNome("Rafael Consentino");
		
		// OBJETO NO ESTADO MANAGED
		manager.persist(p);
		
		// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
		manager.getTransaction().commit();
		
		System.out.println("Pessoa id: " + p.getId());
		
		manager.close();
		factory.close();
	}
}
