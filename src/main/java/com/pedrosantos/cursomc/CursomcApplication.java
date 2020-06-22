package com.pedrosantos.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedrosantos.cursomc.domain.Category;
import com.pedrosantos.cursomc.domain.City;
import com.pedrosantos.cursomc.domain.Product;
import com.pedrosantos.cursomc.domain.State;
import com.pedrosantos.cursomc.repositories.CategoryRepository;
import com.pedrosantos.cursomc.repositories.CityRepository;
import com.pedrosantos.cursomc.repositories.ProductRepository;
import com.pedrosantos.cursomc.repositories.StateRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	@Autowired
	private CategoryRepository categoriaRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product prod1 = new Product(null, "Notebook", 1800.0);
		Product prod2 = new Product(null, "Impressora", 400.0);
		Product prod3 = new Product(null, "Mouse", 80.0);
		
		cat1.getProducts().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProducts().addAll(Arrays.asList(prod2));
		
		prod1.getCategories().addAll(Arrays.asList(cat1));
		prod2.getCategories().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategories().addAll(Arrays.asList(cat1));
		
		State state1 = new State(null, "Minas Gerais");
		State state2 = new State(null, "São Paulo");

		City city1 = new City(null, "Uberlândia", state1);
		City city2 = new City(null, "São Paulo", state2);
		City city3 = new City(null, "Campinas", state2);
		
		state1.getCities().addAll(Arrays.asList(city1));
		state2.getCities().addAll(Arrays.asList(city2, city3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		stateRepository.saveAll(Arrays.asList(state1, state2));
		
		cityRepository.saveAll(Arrays.asList(city1, city2, city3));
	}
}
