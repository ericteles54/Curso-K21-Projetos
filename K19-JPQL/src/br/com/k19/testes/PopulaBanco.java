package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Autor;
import br.com.k19.modelo.Livro;

public class PopulaBanco {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_jpql_pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
				Livro livro1 = new Livro();
		        livro1.setNome("TheBattleforYourMind");
		        livro1.setPreco(20.6);
		        manager.persist(livro1);
                Livro livro2 = new Livro();
                livro2.setNome("DifferentiateorDie");
                livro2.setPreco(15.8);
                manager.persist(livro2);
                Livro livro3 = new Livro();
                livro3.setNome("HowtoTransformYourIdeas");
                livro3.setPreco(32.7);
                manager.persist(livro3);
                Livro livro4 = new Livro();
                livro4.setNome("DigitalFortress");
                livro4.setPreco(12.9);
                manager.persist(livro4);
                Livro livro5 = new Livro();
                livro5.setNome("MarketinginanEraofCompetition,ChangeandCrisis");
                livro5.setPreco(26.8);
                manager.persist(livro5);
                Autor autor1 = new Autor();
                autor1.setNome("PatrickCullen");
                autor1.getLivros().add(livro2);
                autor1.getLivros().add(livro4);
                manager.persist(autor1);
                Autor autor2 = new Autor();
                autor2.setNome("FraserSeitel");
                autor2.getLivros().add(livro3);
                manager.persist(autor2);
                Autor autor3 = new Autor();
                autor3.setNome("AlRies");
                autor3.getLivros().add(livro1);
                manager.persist(autor3);
                Autor autor4 = new Autor();
                autor4.setNome("JackTrout");
                autor4.getLivros().add(livro1);
                autor4.getLivros().add(livro2);
                autor4.getLivros().add(livro5);
                manager.persist(autor4);
                Autor autor5 = new Autor();
                autor5.setNome("SteveRivkin");
                autor5.getLivros().add(livro2);
                autor5.getLivros().add(livro3);
                autor5.getLivros().add(livro5);
                manager.persist(autor5);
                manager.getTransaction().commit();
                manager.close();
                factory.close();


	}
}
