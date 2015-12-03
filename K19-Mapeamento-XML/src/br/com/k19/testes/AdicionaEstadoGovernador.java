package br.com.k19.testes;

import javax.persistence.Persistence;

import br.com.k19.modelo.Estado;
import br.com.k19.modelo.Governador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AdicionaEstadoGovernador {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_xml_pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Governador g = new Governador();
		g.setNome("Rafael Consentino");
		
		Estado e = new Estado();
		e.setNome("São Paulo");
		e.setGovernador(g);
		
		manager.persist(g);
		manager.persist(e);		
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
