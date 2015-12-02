package br.com.k19.modelo;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Cacheable(true)
public class Cidade {
	@Id @GeneratedValue
	private Long id;
	
	private String nomeDaCidade;
	private String nomeDoEstado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeDaCidade() {
		return nomeDaCidade;
	}
	public void setNomeDaCidade(String nomeDaCidade) {
		this.nomeDaCidade = nomeDaCidade;
	}
	public String getNomeDoEstado() {
		return nomeDoEstado;
	}
	public void setNomeDoEstado(String nomeDoEstado) {
		this.nomeDoEstado = nomeDoEstado;
	}
	
	

}
