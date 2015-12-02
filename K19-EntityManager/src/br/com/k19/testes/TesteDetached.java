package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TesteDetached {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_entity_manager_pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
	
		// OBJETO NO ESTADO MANAGED
		Pessoa p = manager.find(Pessoa.class, 1L);
		
		// OBJETO p NO ESTADO DETACHED
		manager.detach(p);
		
		// OBJETO p2 no ESTADO MANAGED
		Pessoa p2 = manager.merge(p);
		
		// ALTERANDO O CONTEUDO DO OBJETO
		p2.setNome("Jonas Hirata");
		
		// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
}
