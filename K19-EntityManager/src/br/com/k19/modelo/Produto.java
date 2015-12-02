package br.com.k19.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

@Entity
public class Produto {

	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	private Double preco;
	
	@PrePersist
	public void prePersist() {
		System.out.println("Persistinfo um novo objeto com persist() ou merge()");
	}
	
	@PostPersist
	public void postPersist() {
		System.out.println("O comando insert foi executado no banco de dados");
		System.out.println("Um rollback ainda pode desfazer o comando insert");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
}
