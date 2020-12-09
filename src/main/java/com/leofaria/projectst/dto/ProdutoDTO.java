package com.leofaria.projectst.dto;

import com.leofaria.projectst.domain.Produto;

public class ProdutoDTO {
	
	private Integer id;
	private String nome;
	private String marca;
	private int quantidade;
	private double valorVenda;
	private double valorCompra;
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public ProdutoDTO() {
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

	public ProdutoDTO(Produto obj) {
		id = obj.getId();
		nome = obj.getNome();
		marca= obj.getMarca();
		quantidade = obj.getQuantidade();
		valorVenda = obj.getValorVenda();
		valorCompra = obj.getValorCompra();
	}
	
	

}
