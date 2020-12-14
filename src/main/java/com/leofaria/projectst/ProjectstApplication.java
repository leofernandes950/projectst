package com.leofaria.projectst;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leofaria.projectst.domain.Cliente;
import com.leofaria.projectst.domain.Pagamento;
import com.leofaria.projectst.domain.PagamentoComBoleto;
import com.leofaria.projectst.domain.PagamentoComCartao;
import com.leofaria.projectst.domain.Pedido;
import com.leofaria.projectst.domain.Produto;
import com.leofaria.projectst.domain.enums.EstadoPagamento;
import com.leofaria.projectst.repositories.ClienteRepository;
import com.leofaria.projectst.repositories.PagamentoRepository;
import com.leofaria.projectst.repositories.PedidoRepository;
import com.leofaria.projectst.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjectstApplication implements CommandLineRunner{
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjectstApplication.class, args);
	}
		
		@Override
		public void run(String...args)throws Exception{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
			
			Cliente cli1 = new Cliente(null,"Leonardo De Melo","12068375605","Rua do Morro",sdf.parse("03/08/2020 09:33"),sdf.parse("07/10/2020 10:45"),"Masculino","leo@leo.com",1);
			cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
			clienteRepository.saveAll(Arrays.asList(cli1));
			Cliente cli2 = new Cliente(null,"Dayane Silveira","15085547205","Rua do Praia",sdf.parse("03/08/2020 09:33"),sdf.parse("07/10/2020 10:45"),"Feminino","dayane@dayane.com",1);
			cli2.getTelefones().addAll(Arrays.asList("58121653", "15121253"));
			clienteRepository.saveAll(Arrays.asList(cli2));
			
			
			Pedido ped1 = new Pedido(null,sdf.parse("30/08/2020 19:30"),cli1);
			Pedido ped2 = new Pedido(null,sdf.parse("17/05/2019 05:39"),cli2);
			
			Pagamento pgto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped1,6);
			ped1.setPagamento(pgto1);
			
			Pagamento pgto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("03/08/2020 09:45"),null);
			ped2.setPagamento(pgto2);
			
			cli1.getPedido().addAll(Arrays.asList(ped1,ped2));
			
			pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
			pagamentoRepository.saveAll(Arrays.asList(pgto1,pgto2));
			
	
			
			Produto produto1 = new Produto(null,"Strada","Fiat",5,50.000,33.000);
			Produto produto2 = new Produto(null,"Palio","Fiat",7,60.000,44.000);
			//ped1.getProdutos().addAll(Arrays.asList(produto1));
			//ped2.getProdutos().addAll(Arrays.asList(produto2));
			produtoRepository.saveAll(Arrays.asList(produto1,produto2));
			
			
			
			
			
			
			
			}
		
		
}
