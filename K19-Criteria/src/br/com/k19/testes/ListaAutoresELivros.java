package br.com.k19.testes;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.com.k19.modelo.Autor;
import br.com.k19.modelo.Livro;

public class ListaAutoresELivros {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_criteria_pu");
		EntityManager manager1 = factory.createEntityManager();
		
		manager1.getTransaction().begin();
		
		CriteriaBuilder criteriaBuilder1 = manager1.getCriteriaBuilder();
		
		CriteriaUpdate<Livro> updateLivro = criteriaBuilder1.createCriteriaUpdate(Livro.class);
		Root<Livro> livro = updateLivro.from(Livro.class);
		updateLivro.set(
				livro.<Double> get("preco"),
				criteriaBuilder1.prod(livro.<Double> get("preco"), 1.1));
		
		Query query = manager1.createQuery(updateLivro);
		query.executeUpdate();
		
		manager1.getTransaction().commit();
		
		
		
		EntityManager manager2 = factory.createEntityManager();
		
		CriteriaBuilder criteriaBuilder2 = manager2.getCriteriaBuilder();
		CriteriaQuery<Autor> criteriaQuery = criteriaBuilder2.createQuery(Autor.class);
		
		Root<Autor> autor = criteriaQuery.from(Autor.class);
		autor.fetch("livros", JoinType.LEFT);
		criteriaQuery.select(autor).distinct(true);
		
		TypedQuery<Autor> query1 = manager2.createQuery(criteriaQuery);
		List<Autor> autores = query1.getResultList();
		
		System.out.println();
		
		for(Autor a : autores) {
			System.out.println("Autor: " + a.getNome());
			Collection<Livro> livros = a.getLivros();
			
			for(Livro l : livros) {
				System.out.println("	Livro: " + l.getNome());
				System.out.println("		Preço: " + l.getPreco());
			}
			System.out.println();
		}
		
		
		
		manager1.close();
		manager2.close();
		factory.close();
		
	}
}
