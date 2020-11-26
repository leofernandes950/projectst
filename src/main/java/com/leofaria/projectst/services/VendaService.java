package com.leofaria.projectst.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leofaria.projectst.domain.Venda;
import com.leofaria.projectst.repositories.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repo;
	
	public Venda buscar(Integer id) {
		Optional<Venda> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
