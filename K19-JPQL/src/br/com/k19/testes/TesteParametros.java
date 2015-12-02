package br.com.k19.testes;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.k19.modelo.Livro;

public class TesteParametros {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_jpql_pu");
		EntityManager manager = factory.createEntityManager();
		
		TypedQuery<Livro> query = manager.createNamedQuery("Livro.findByPrecoMinimo", Livro.class);
		query.setParameter("preco", 20.0);
		List<Livro> livros = query.getResultList();
		
		for(Livro livro : livros) {
			System.out.println("Nome: " + livro.getNome());
			System.out.println("Preco: " + livro.getPreco());
		}
		
		TypedQuery<Double> query2 = manager.createQuery("select avg(livro.preco) from Livro livro", Double.class);
		Double precoMedio = query2.getSingleResult();
		
		System.out.println("Preco Medio: " + precoMedio);
		
		manager.close();
		factory.close();
	}
}
