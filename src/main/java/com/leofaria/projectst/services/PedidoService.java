package com.leofaria.projectst.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leofaria.projectst.domain.ItemPedido;
import com.leofaria.projectst.domain.Pagamento;
import com.leofaria.projectst.domain.Pedido;
import com.leofaria.projectst.domain.Produto;
import com.leofaria.projectst.domain.enums.EstadoPagamento;
import com.leofaria.projectst.repositories.ItemPedidoRepository;
import com.leofaria.projectst.repositories.PagamentoRepository;
import com.leofaria.projectst.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Pedido insert(Pedido obj,HashMap<Integer,Produto> produtoHashMap) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setCliente(clienteService.find(obj.getCliente().getId()));
		Pagamento pagamento = new Pagamento(null,EstadoPagamento.QUITADO,obj);
		obj.setPagamento(pagamento);
		System.out.println(obj.getItens());
			//obj.getPagamento().setPedido(obj);
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for(int i=0;i<produtoHashMap.size();i++) {
		
			ItemPedido item = new ItemPedido();
	
			item.setDesconto(0.0);
			item.setProduto(produtoHashMap.get(i));
			item.setPreco(item.getProduto().getValorVenda());
			item.setPedido(obj);
			itemPedidoRepository.save(item);
		}

		
		return obj;
	}
	
	public List<Pedido> findAll() {
		return repo.findAll();
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public Pedido update(Pedido obj) {
		Pedido newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	private void updateData(Pedido newObj,Pedido obj) {
		newObj.setId(obj.getId());
		//newObj.setDesconto(obj.getDesconto());
		//newObj.setTotal(obj.getTotal());
		//newObj.setData(obj.getData());
	}

	
	

}
