package com.leofaria.projectst.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leofaria.projectst.domain.Carro;
import com.leofaria.projectst.services.CarroService;

@Controller
@RequestMapping(value="/carros")
public class CarroResource implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CarroService service;
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Carro obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/lista")
	public String lstCarro(Model model) {
		
		List<Carro> lista = new ArrayList<>();
		
		Carro carro1 = new Carro(1,"Palio","Fiat");
		Carro carro2 = new Carro(2,"Onix","Chevrolet");
		
		lista.add(carro1);
		lista.add(carro2);
		model.addAttribute("lista", lista);
		return "carro";
	}
	
	

	

}
