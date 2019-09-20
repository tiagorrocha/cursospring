package com.cursospring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursospring.domain.Categoria;
import com.cursospring.domain.Cidade;
import com.cursospring.domain.Cliente;
import com.cursospring.domain.Endereco;
import com.cursospring.domain.Estado;
import com.cursospring.domain.Produto;
import com.cursospring.domain.enums.TipoCliente;
import com.cursospring.repositories.CategoriaRepository;
import com.cursospring.repositories.CidadeRepository;
import com.cursospring.repositories.ClienteRepository;
import com.cursospring.repositories.EnderecoRepository;
import com.cursospring.repositories.EstadoRepository;
import com.cursospring.repositories.ProdutoRepository;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null, "Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
				
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Minas Gerias");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade cid1 = new Cidade(null,"Uberlância",est1);
		Cidade cid2 = new Cidade(null,"São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2,cid3));
				
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		Cliente cli1 = new Cliente(null,"Maria","maria@mial.com","12345678925",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("12548","21815"));
		
		Endereco end = new Endereco(null,"Rua Flores","25","Apt A","Centro","563185",cli1,cid1);
		Endereco end2 = new Endereco(null,"Rua Matos","35","Apt A","Centro","453185",cli1,cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(end,end2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end,end2));
	}

}
