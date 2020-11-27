package com.leofaria.projectst.resource;

import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		model.addAttribute("modelLista", listDto);
		return "carro";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/carros/lista";
	}
	
	@RequestMapping(value="/novo" ,method= RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CarroDTO objDto){
		Carro obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String update( @Valid CarroDTO objDto, @PathVariable Integer id){
		Carro obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return "redirect:/carros/lista";
	}
	
	@RequestMapping(value="/cadastrarCarro")
	public String cadastrarCarro(Model model) {
		return "cadastrarCarro";
	}
	
	@RequestMapping(value="/atualiza/{id}")
	public String atualizar(@PathVariable("id") int id, Model model) {
		model.addAttribute("modelCarro", service.find(id));		
		return "cadastrarCarro";
	}

	

}
