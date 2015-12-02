package br.com.k19.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.action.internal.OrphanRemovalAction;

@Entity
public class Topico {

	@Id @GeneratedValue
	private Long id;
	
	private String titulo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@OneToMany(cascade={CascadeType.PERSIST}, orphanRemoval=true)
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	
	
}
