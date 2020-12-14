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

import com.leofaria.projectst.domain.Cliente;
import com.leofaria.projectst.domain.Produto;
import com.leofaria.projectst.domain.Pedido;
import com.leofaria.projectst.dto.ClienteDTO;
import com.leofaria.projectst.dto.ProdutoDTO;
import com.leofaria.projectst.services.ClienteService;
import com.leofaria.projectst.services.ProdutoService;
import com.leofaria.projectst.services.PedidoService;

@Controller
@RequestMapping(value="/pedidos")
public class PedidoResource implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PedidoService servicePedido;
	@Autowired
	private ProdutoService serviceProduto;
	@Autowired
	private ClienteService serviceCliente;
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pedido obj = servicePedido.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(value="/lista")
	public String findAll(Model model) {
			List <Pedido> list = servicePedido.findAll();
		model.addAttribute("modelLista", list);
		return "pedido";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id){
		servicePedido.delete(id);
		return "redirect:/pedidos/lista";
	}
	
	@RequestMapping(value="/novo" ,method= RequestMethod.POST)
	public String insert(@Valid Pedido obj) {	
		servicePedido.insert(obj);
		return "redirect:/pedidos/lista";
	}
	
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String update( @Valid Pedido obj, @PathVariable Integer id){
		obj.setId(id);
		obj = servicePedido.update(obj);
		return "redirect:/pedidos/lista";
	}
	
	@RequestMapping(value="/cadastrarPedido")
	public String cadastrar(Model model) {
		List<Produto> listProduto = serviceProduto.findAll();
		List<ProdutoDTO> listProdutoDto = listProduto.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
		List<Cliente> listCliente = serviceCliente.findAll();
		List<ClienteDTO> listClienteDto = listCliente.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		model.addAttribute("modelProduto", listProdutoDto);
		model.addAttribute("modelCliente", listCliente);
		return "addPedido";
	}
	

	
	@RequestMapping(value="/atualiza/{id}")
	public String atualizar(@PathVariable("id") int id, Model model) {
		model.addAttribute("modelPedido", servicePedido.find(id));		
		return "updatePedido";
	}

	

}
