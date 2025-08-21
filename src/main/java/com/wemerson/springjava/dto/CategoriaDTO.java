package com.wemerson.springjava.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.wemerson.springjava.domain.Categoria;

import jakarta.validation.constraints.NotEmpty;

public class CategoriaDTO  implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	@org.hibernate.validator.constraints.NotEmpty(message = "Preenchimento Obrigatorio")
	@Length(min=5, max=80, message= "o tamanho deve ser entre 5 e 80  catacteres")
	private String nome;
	
	public CategoriaDTO() {
	}
	
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
