package br.com.k19.testes;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.k19.modelo.Autor;
import br.com.k19.modelo.Livro;

public class ListaAutoresELivros {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_jpql_pu");
		EntityManager manager = factory.createEntityManager();
	
		Query query = manager.createQuery("select distinct(a) from Autor a left join fetch a.livros");
		
		List<Autor> autores = query.getResultList();
		System.out.println();
		
		for(Autor autor : autores) {
			System.out.println("Autor: " + autor.getNome());
			Collection<Livro> livros = autor.getLivros();
			
			for(Livro livro : livros) {
				System.out.println("Livro: " + livro.getNome());
			}
		}
		System.out.println();
		
		manager.close();
		factory.close();
	}
}
