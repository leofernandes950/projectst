package com.leofaria.projectst.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leofaria.projectst.damain.Carro;

@Controller
public class CarroResource implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	@RequestMapping("/carro")
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
