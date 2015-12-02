package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Conta;

public class TestaAcessoConcorrente {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_entity_manager_pu");
		EntityManager manager = factory.createEntityManager();
		EntityManager manager1 = factory.createEntityManager();
	
		manager.getTransaction().begin();
		manager1.getTransaction().begin();
		
		Conta c = manager.find(Conta.class, 1L);
		c.setSaldo(c.getSaldo() + 500);
		
		Conta c1 = manager1.find(Conta.class, 1L);
		c1.setSaldo(c1.getSaldo() - 500);
		
		manager.getTransaction().commit();
		manager1.getTransaction().commit();
		manager.close();
		manager1.close();
		factory.close();
	}
}
