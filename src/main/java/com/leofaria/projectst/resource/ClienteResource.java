package com.leofaria.projectst.resource;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leofaria.projectst.domain.Cliente;
import com.leofaria.projectst.dto.ClienteDTO;
import com.leofaria.projectst.services.ClienteService;

@Controller
@RequestMapping(value="/clientes")
public class ClienteResource implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClienteService service;
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cliente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(value="/lista")
	public String findAll(Model model) {
			List <Cliente> list = service.findAll();
			List<ClienteDTO> listDto = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		model.addAttribute("modelLista", listDto);
		return "cliente";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/clientes/lista";
	}
	
	@RequestMapping(value="/novo" ,method= RequestMethod.POST)
	public String insert(@Valid ClienteDTO objDto, @RequestParam("nome") String nome,@RequestParam("cpfOuCnpj") String cpfOuCnpj,
			@RequestParam("endereco") String endereco,@RequestParam("dataNascimento") Date dataNascimento,
			@RequestParam("sexo") String sexo,@RequestParam("email") String email) {	
		Date dataAtual = new Date();
		Cliente obj = service.fromDTO(objDto);
		obj.setDataCadastro(dataAtual);
		obj = service.insert(obj);
		return "redirect:/clientes/lista";
	}
	
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String update( @Valid ClienteDTO objDto, @PathVariable Integer id){
		Cliente obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return "redirect:/clientes/lista";
	}
	
	@RequestMapping(value="/cadastrarCliente")
	public String cadastrar() {
		return "addCliente";
	}
	
	
	@RequestMapping(value="/atualiza/{id}")
	public String atualizar(@PathVariable("id") int id, Model model) {
		model.addAttribute("modelCliente", service.find(id));
		return "updateCliente";
	}

	

}
