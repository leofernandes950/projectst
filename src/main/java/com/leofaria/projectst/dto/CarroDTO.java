package com.leofaria.projectst.dto;

import com.leofaria.projectst.domain.Carro;

public class CarroDTO {
	
	private Integer id;
	private String nome;
	private String marca;
	
	public CarroDTO() {
		// TODO Auto-generated constructor stub
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public CarroDTO(Carro obj) {
		id = obj.getId();
		nome = obj.getNome();
		marca= obj.getMarca();
	}
	
	

}
