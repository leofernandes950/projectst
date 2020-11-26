package com.leofaria.projectst.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leofaria.projectst.domain.Carro;
import com.leofaria.projectst.repositories.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository repo;
	
	public Carro buscar(Integer id) {
		Optional<Carro> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
