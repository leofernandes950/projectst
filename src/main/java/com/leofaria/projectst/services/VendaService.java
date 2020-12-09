package com.leofaria.projectst.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leofaria.projectst.domain.Venda;
import com.leofaria.projectst.dto.VendaDTO;
import com.leofaria.projectst.repositories.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repo;
	
	public Venda find(Integer id) {
		Optional<Venda> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Venda insert(Venda obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public List<Venda> findAll() {
		return repo.findAll();
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public Venda update(Venda obj) {
		Venda newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	private void updateData(Venda newObj,Venda obj) {
		newObj.setId(obj.getId());
		newObj.setDesconto(obj.getDesconto());
		newObj.setTotal(obj.getTotal());
		newObj.setData(obj.getData());
	}

	public Venda fromDTO(VendaDTO objDto) {
		return new Venda(objDto.getId(),objDto.getDesconto(),objDto.getTotal(),objDto.getData());
	}
	
	
	

}
