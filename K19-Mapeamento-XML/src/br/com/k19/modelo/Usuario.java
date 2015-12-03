package br.com.k19.modelo;

import java.util.Calendar;

public class Usuario {
	private Long id;
	private String email;
	private Calendar dataDeCadastro;
	private byte[] foto;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getDataDeCadastro() {
		return dataDeCadastro;
	}
	public void setDataDeCadastro(Calendar dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	
}
