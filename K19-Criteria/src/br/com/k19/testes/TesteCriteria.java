package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import br.com.k19.modelo.Livro;

public class TesteCriteria {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_criteria_pu");
		EntityManager manager = factory.createEntityManager();
	
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		
		CriteriaQuery<Tuple> c = cb.createQuery(Tuple.class);
		Root<Livro> l = c.from(Livro.class);
		c.multiselect(l.<String>get("nome").alias("livro.nome"), l.<Double>get("preco").alias("livro.preco"));
		Predicate predicate = cb.ge(l.get("preco"), 13);
		c.where(predicate);
		
		
		
		TypedQuery<Tuple> query = manager.createQuery(c);
		List<Tuple> resultado = query.getResultList();
		
		for(Tuple registro : resultado) {
			System.out.println("Livro: " + registro.get("livro.nome"));
			System.out.println("Preco: " + registro.get("livro.preco"));
		}
		
		
		manager.close();
		factory.close();
	}
}
