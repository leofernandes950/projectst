package com.leofaria.projectst.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leofaria.projectst.domain.Carro;
import com.leofaria.projectst.domain.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda,Integer>{

	

}
