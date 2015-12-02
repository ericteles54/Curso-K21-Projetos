package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Departamento;
import br.com.k19.modelo.Funcionario;

public class AdicionaFuncionarioDepartamento {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_jpql_pu");
		EntityManager manager = factory.createEntityManager();
	
		manager.getTransaction().begin();
		
		Departamento d = new Departamento();
		d.setNome("Treinamentos");
		
		Funcionario f = new Funcionario();
		f.setNome("Rafael Consentino");
		f.setDepartamento(d);
		
		manager.persist(d);
		manager.persist(f);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
	}
}
