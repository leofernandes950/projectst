package com.leofaria.projectst.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.leofaria.projectst.domain.Cliente;

public class ClienteDTO {
	
	private Integer id;
	private String nome;
	private String cpfOuCnpj;
	private String endereco;
	private Date dataNascimento;
	private Date dataCadastro;
	private String sexo;
	private String email;
	private Integer tipo;
	private Set<String> telefones = new HashSet<>();
	
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
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}
	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	public String getEndereço() {
		return endereco;
	}
	public void setEndereço(String endereco) {
		this.endereco = endereco;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	public ClienteDTO() {
		super();
	}
	public ClienteDTO(Cliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpfOuCnpj = obj.getCpfOuCnpj();
		this.endereco = obj.getEndereco();
		this.dataNascimento = obj.getDataNascimento();
		this.dataCadastro = obj.getDataCadastro();
		this.sexo = obj.getSexo();
		this.email = obj.getEmail();
		this.tipo = obj.getTipo();
	}
	public Set<String> getTelefones() {
		return telefones;
	}
	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
		

}
