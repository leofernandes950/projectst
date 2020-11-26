package com.leofaria.projectst.resource;

import java.io.Serializable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leofaria.projectst.domain.Venda;
import com.leofaria.projectst.services.VendaService;

@Controller
@RequestMapping(value="/vendas")
public class VendaResource implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private VendaService service;
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Venda obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*@RequestMapping(value="/lista")
	public String lstVenda(Model model) {
		
		List<Venda> lista = new ArrayList<>();
		
		Venda venda1 = new Venda(1,"Palio","Fiat");
		Venda venda2 = new Venda(2,"Onix","Chevrolet");
		
		lista.add(venda1);
		lista.add(venda2);
		model.addAttribute("lista", lista);
		return "carro";
	}*/
	
	

	

}
