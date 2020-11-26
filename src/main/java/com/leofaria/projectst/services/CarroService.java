package com.leofaria.projectst.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leofaria.projectst.domain.Carro;
import com.leofaria.projectst.services.exceptions.ObjectNotFoundException;
import com.leofaria.projectst.repositories.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository repo;
	
	public Carro find(Integer id) {
		Optional<Carro> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public List<Carro> findAll() {
		return repo.findAll();
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}



}
