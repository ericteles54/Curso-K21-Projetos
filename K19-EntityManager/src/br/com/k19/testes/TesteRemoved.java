package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TesteRemoved {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_entity_manager_pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		// RECUPERA OBJETO DO BANCO DE DADOS
		Pessoa p = manager.find(Pessoa.class, 3L);
		
		// OBJETO NO ESTADO REMOVED
		manager.remove(p);
		
		// SINCRONIZA E CONFIRMA A TRANSACAO
		manager.getTransaction().commit();
		
		
		manager.close();
		factory.close();
	}
}
