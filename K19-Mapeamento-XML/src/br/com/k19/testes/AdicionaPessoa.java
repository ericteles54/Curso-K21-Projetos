package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.PessoaFisica;
import br.com.k19.modelo.PessoaJuridica;

public class AdicionaPessoa {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_xml_pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		PessoaFisica p1 = new PessoaFisica();
		p1.setNome("Rafael Consentino");
		p1.setCpf("123.456.789-23");

		PessoaJuridica p2 = new PessoaJuridica();
		p2.setNome("Empresa ficticia");
		p2.setCnpj("20.356.214/0001-45");
		
		manager.persist(p1);
		manager.persist(p2);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
