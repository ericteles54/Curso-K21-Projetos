package br.com.k19.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Autor.class)
public abstract class Autor_ {

	public static volatile CollectionAttribute<Autor, Livro> livros;
	public static volatile SingularAttribute<Autor, String> nome;
	public static volatile SingularAttribute<Autor, Long> id;

}

