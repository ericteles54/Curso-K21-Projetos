package br.com.k19.testes;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Candidato;
import br.com.k19.modelo.Endereco;

public class AdicionaCanditadoEndereco {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_xml_pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Endereco e = new Endereco();
		e.setEstado("RJ");
		e.setCidade("Rio de Janeiro");
		e.setLogradouro("Rua do migué, Cafofo");
		e.setNumero(123);
		
		Candidato c = new Candidato();
		c.setNome("Rafael Consentino");
		c.setNascimento(new GregorianCalendar(1984, 10, 23));
		c.setEndereco(e);
		
		
		manager.persist(c);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		
		
	}
}
