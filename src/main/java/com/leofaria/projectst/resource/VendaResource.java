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

import com.leofaria.projectst.domain.Produto;
import com.leofaria.projectst.domain.Venda;
import com.leofaria.projectst.dto.ProdutoDTO;
import com.leofaria.projectst.dto.VendaDTO;
import com.leofaria.projectst.services.ProdutoService;
import com.leofaria.projectst.services.VendaService;

@Controller
@RequestMapping(value="/vendas")
public class VendaResource implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private VendaService serviceVenda;
	@Autowired
	private ProdutoService serviceProduto;
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Venda obj = serviceVenda.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(value="/lista")
	public String findAll(Model model) {
			List <Venda> list = serviceVenda.findAll();
			List<VendaDTO> listDto = list.stream().map(obj -> new VendaDTO(obj)).collect(Collectors.toList());
		model.addAttribute("modelLista", listDto);
		return "venda";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id){
		serviceVenda.delete(id);
		return "redirect:/vendas/lista";
	}
	
	/*@RequestMapping(value="/novo" ,method= RequestMethod.POST)
	public String insert(@Valid CarroDTO objDto, @RequestParam("desconto") double desconto,@RequestParam("Total") String marca,
			@RequestParam("quantidade") int quantidade,@RequestParam("valorVenda") double valorVenda,
			@RequestParam("valorCompra") double valorCompra) {
		
		Venda obj = service.fromDTO(objDto);
		obj.setDesconto(desconto);
		obj.setTotal(marca);
		obj.setData(quantidade);
		obj = service.insert(obj);
		return "redirect:/vendas/lista";
	}*/
	
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String update( @Valid VendaDTO objDto, @PathVariable Integer id){
		Venda obj = serviceVenda.fromDTO(objDto);
		obj.setId(id);
		obj = serviceVenda.update(obj);
		return "redirect:/vendas/lista";
	}
	
	@RequestMapping(value="/cadastrarVenda")
	public String cadastrar(Model model) {
		System.out.println("chegou");
		List<Produto> list = serviceProduto.findAll();
		System.out.println("chegou2");
		List<ProdutoDTO> listDto = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
		model.addAttribute("modelProduto", listDto);
		return "addVenda";
	}
	

	
	@RequestMapping(value="/atualiza/{id}")
	public String atualizar(@PathVariable("id") int id, Model model) {
		model.addAttribute("modelVenda", serviceVenda.find(id));		
		return "updateVenda";
	}

	

}
