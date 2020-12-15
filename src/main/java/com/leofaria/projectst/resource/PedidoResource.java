package com.leofaria.projectst.resource;

import java.io.Serializable;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.leofaria.projectst.domain.Cliente;
import com.leofaria.projectst.domain.Pedido;
import com.leofaria.projectst.domain.Produto;
import com.leofaria.projectst.dto.ClienteDTO;
import com.leofaria.projectst.dto.ProdutoDTO;
import com.leofaria.projectst.services.ClienteService;
import com.leofaria.projectst.services.PedidoService;
import com.leofaria.projectst.services.ProdutoService;

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
	@Autowired
	private ProdutoService produtoService;
	
	 private HashMap<Integer, Produto> produtoHashMap;
	
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
		this.produtoHashMap = new HashMap<>();
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

	@RequestMapping(value="/adicionaItem")
	public String adicionaItem(@RequestParam("idProduto") int idProduto,@RequestParam("key") Integer key) {
		this.produtoHashMap = produtoService.adicionaItem(idProduto,this.produtoHashMap,key);
		String retorno ="";
		retorno = "<tr>\r\n" + 
				"											<th scope=\"row\">"+key+"</th>\r\n" + 
				"											<td>"+this.produtoHashMap.get(key).getNome()+"</td>\r\n" + 
				"											<td>"+this.produtoHashMap.get(key).getMarca()+"</td>\r\n" + 
				"											<td>"+this.produtoHashMap.get(key).getValorVenda()+"</td>\r\n" + 
				"										</tr>";
		
		return retorno;
	}

}
