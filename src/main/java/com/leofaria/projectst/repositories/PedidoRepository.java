package com.leofaria.projectst.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leofaria.projectst.domain.Produto;
import com.leofaria.projectst.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer>{

	

}
