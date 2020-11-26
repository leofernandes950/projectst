package com.leofaria.projectst;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leofaria.projectst.domain.Carro;
import com.leofaria.projectst.domain.Venda;
import com.leofaria.projectst.repositories.CarroRepository;
import com.leofaria.projectst.repositories.VendaRepository;

@SpringBootApplication
public class ProjectstApplication implements CommandLineRunner{
	
	@Autowired
	private CarroRepository carroRepository;
	
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
			
			Carro carro1 = new Carro(null,"Strada","Fiat",venda1);
			Carro carro2 = new Carro(null,"Palio","Fiat",venda2);
			
			venda1.getCarros().addAll(Arrays.asList(carro1));
			venda2.getCarros().addAll(Arrays.asList(carro2));
			
			
			vendaRepository.saveAll(Arrays.asList(venda1,venda2));
			carroRepository.saveAll(Arrays.asList(carro1,carro2));
			}
		
		
}
