package com.leofaria.projectst.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Carro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String marca;
	
	@ManyToOne
	@JoinColumn(name="venda_id")
	private Venda venda;
	
	//ao construir relacionamento venda 1 para carros * é necessário adiconar ao contrutor 
	public Carro(Integer id, String nome, String marca) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
	}
	
	//ao construir relacionamento venda 1 para carros * é necessário criar um novo connstrutor
	public Carro(Integer id, String nome, String marca, Venda venda) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.venda = venda;
	}
	
	public Carro() {}
	
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
	
	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Carro [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", marca=");
		builder.append(marca);
		builder.append("]");
		return builder.toString();
	}
	
	
}
