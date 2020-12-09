package com.leofaria.projectst.resource;

import java.io.Serializable;
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

import com.leofaria.projectst.domain.Produto;
import com.leofaria.projectst.dto.ProdutoDTO;
import com.leofaria.projectst.services.ProdutoService;

@Controller
@RequestMapping(value="/produtos")
public class ProdutoResource implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProdutoService service;
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Produto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(value="/lista")
	public String findAll(Model model) {
			List <Produto> list = service.findAll();
			List<ProdutoDTO> listDto = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
		model.addAttribute("modelLista", listDto);
		return "produto";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/produtos/lista";
	}
	
	@RequestMapping(value="/novo" ,method= RequestMethod.POST)
	public String insert(@Valid ProdutoDTO objDto, @RequestParam("nome") String nome,@RequestParam("marca") String marca,
			@RequestParam("quantidade") int quantidade,@RequestParam("valorVenda") double valorVenda,
			@RequestParam("valorCompra") double valorCompra) {
		Produto obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		return "redirect:/produtos/lista";
	}
	
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String update( @Valid ProdutoDTO objDto, @PathVariable Integer id){
		Produto obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return "redirect:/produtos/lista";
	}
	
	@RequestMapping(value="/cadastrarProduto")
	public String cadastrar() {
		return "addProduto";
	}
	
	
	@RequestMapping(value="/atualiza/{id}")
	public String atualizar(@PathVariable("id") int id, Model model) {
		model.addAttribute("modelProduto", service.find(id));		
		return "updateProduto";
	}

	

}
