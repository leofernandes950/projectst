package com.leofaria.projectst.services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leofaria.projectst.domain.Produto;
import com.leofaria.projectst.dto.ProdutoDTO;
import com.leofaria.projectst.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Produto insert(Produto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public List<Produto> findAll() {
		return repo.findAll();
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public Produto update(Produto obj) {
		Produto newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	private void updateData(Produto newObj,Produto obj) {
		newObj.setNome(obj.getNome());
		newObj.setMarca(obj.getMarca());
		newObj.setQuantidade(obj.getQuantidade());
		newObj.setValorVenda(obj.getValorVenda());
		newObj.setValorCompra(obj.getValorCompra());
	}

	public Produto fromDTO(ProdutoDTO objDto) {
		return new Produto(objDto.getId(),objDto.getNome(),objDto.getMarca(),objDto.getQuantidade(),objDto.getValorVenda(),objDto.getValorCompra());
	}

	public HashMap<Integer, Produto> adicionaItem(int idProduto, HashMap<Integer, Produto> produtoHashMap,
			Integer key) {
		Produto produto = new Produto();
		produto = find(idProduto);
		produtoHashMap.put(key, produto);
		return produtoHashMap;
	}
	
	
	

}
