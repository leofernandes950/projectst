package com.leofaria.projectst;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leofaria.projectst.domain.Carro;
import com.leofaria.projectst.repositories.CarroRepository;

@SpringBootApplication
public class ProjectstApplication implements CommandLineRunner{
	
	@Autowired
	CarroRepository carroRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjectstApplication.class, args);
	}
		
		@Override
		public void run(String...args)throws Exception{
		
		
		Carro carro1 = new Carro(1,"Strada","Fiat");
		Carro carro2 = new Carro(2,"Palio","Fiat");
		
		carroRepository.saveAll(Arrays.asList(carro1,carro2));
	
		}
}
