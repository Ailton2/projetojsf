package br.com.projetojsf.classes.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "usuario")
public class Usuario {
	
	
	private Long id;
	
	private String nome;

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
	

}
