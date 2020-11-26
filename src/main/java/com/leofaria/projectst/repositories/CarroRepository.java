package com.leofaria.projectst.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leofaria.projectst.domain.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro,Integer>{

	

}
