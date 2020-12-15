package com.leofaria.projectst.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String marca;
	private int quantidade;
	private double valorVenda;
	private double valorCompra;
	

	@ManyToOne
	@JoinColumn(name="venda_id")
	private Venda venda;
	
	@OneToMany(mappedBy="id.produto")
	private Set<ItemPedido> itens = new HashSet<>();
	
	
	public Produto(Integer id, String nome, String marca,int quantidade,double valorVenda,double valorCompra) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.quantidade= quantidade;
		this.valorVenda= valorVenda;
		this.valorCompra = valorCompra;
	}
	
	//ao construir relacionamento venda 1 para carros * é necessário criar um novo connstrutor
	public Produto(Integer id, String nome, String marca,int quantidade,double valorVenda,double valorCompra,Venda venda) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.quantidade= quantidade;
		this.valorVenda= valorVenda;
		this.valorCompra = valorCompra;
		this.venda = venda;
	}
	
	public Produto() {}
	
	 public List<Pedido> getPedidos(){
		 List<Pedido> lista = new ArrayList<>();
		 for (ItemPedido x : itens) {
			 lista.add(x.getPedido());
		 }
		 return lista;
	 }
	
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
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
	
	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuatidade(int quantidade) {
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

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
	
	
}
