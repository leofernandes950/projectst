package com.leofaria.projectst.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leofaria.projectst.domain.Carro;
import com.leofaria.projectst.dto.CarroDTO;
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
		Carro obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(value="/lista")
	public String findAll(Model model) {
			List <Carro> list = service.findAll();
			List<CarroDTO> listDto = list.stream().map(obj -> new CarroDTO(obj)).collect(Collectors.toList());
		model.addAttribute("lista", listDto);
		return "carro";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	

	

}
