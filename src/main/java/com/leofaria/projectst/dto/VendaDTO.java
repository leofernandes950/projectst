package com.leofaria.projectst.dto;

import java.util.Date;

import com.leofaria.projectst.domain.Produto;
import com.leofaria.projectst.domain.Venda;

public class VendaDTO {
	
	private Integer id;
	private double desconto;
	private double total;
	private Date data;
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public double getDesconto() {
		return desconto;
	}



	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}




	public VendaDTO(Venda obj) {
		id = obj.getId();
		desconto = obj.getDesconto();
		total= obj.getTotal();
		data = obj.getData();		
	}
	
	

}
