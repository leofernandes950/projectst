package com.leofaria.projectst;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leofaria.projectst.domain.Produto;
import com.leofaria.projectst.domain.Venda;
import com.leofaria.projectst.repositories.ProdutoRepository;
import com.leofaria.projectst.repositories.VendaRepository;

@SpringBootApplication
public class ProjectstApplication implements CommandLineRunner{
	
	@Autowired
	private ProdutoRepository carroRepository;
	
	@Autowired
	private VendaRepository vendaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjectstApplication.class, args);
	}
		
		@Override
		public void run(String...args)throws Exception{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		
			Venda venda1 = new Venda(null,0.0,36000,sdf.parse("03/10/2020 10:35"));
			Venda venda2 = new Venda(null,0.0,40000,sdf.parse("07/08/2020 09:15"));
			
			Produto produto1 = new Produto(null,"Strada","Fiat",5,50.000,33.000,venda1);
			Produto produto2 = new Produto(null,"Palio","Fiat",7,60.000,44.000,venda2);
			
			venda1.getProdutos().addAll(Arrays.asList(produto1));
			venda2.getProdutos().addAll(Arrays.asList(produto2));
			
			
			vendaRepository.saveAll(Arrays.asList(venda1,venda2));
			carroRepository.saveAll(Arrays.asList(produto1,produto2));
			}
		
		
}
