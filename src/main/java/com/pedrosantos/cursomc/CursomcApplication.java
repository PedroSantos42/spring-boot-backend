package com.pedrosantos.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedrosantos.cursomc.domain.Address;
import com.pedrosantos.cursomc.domain.Category;
import com.pedrosantos.cursomc.domain.City;
import com.pedrosantos.cursomc.domain.Customer;
import com.pedrosantos.cursomc.domain.Payment;
import com.pedrosantos.cursomc.domain.PaymentCreditCard;
import com.pedrosantos.cursomc.domain.PaymentSlip;
import com.pedrosantos.cursomc.domain.Product;
import com.pedrosantos.cursomc.domain.Purchase;
import com.pedrosantos.cursomc.domain.PurchaseProduct;
import com.pedrosantos.cursomc.domain.State;
import com.pedrosantos.cursomc.domain.enums.CustomerType;
import com.pedrosantos.cursomc.domain.enums.PaymentStage;
import com.pedrosantos.cursomc.repositories.AddressRepository;
import com.pedrosantos.cursomc.repositories.CategoryRepository;
import com.pedrosantos.cursomc.repositories.CityRepository;
import com.pedrosantos.cursomc.repositories.CustomerRepository;
import com.pedrosantos.cursomc.repositories.PaymentRepository;
import com.pedrosantos.cursomc.repositories.ProductRepository;
import com.pedrosantos.cursomc.repositories.PurchaseProductRepository;
import com.pedrosantos.cursomc.repositories.PurchaseRepository;
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
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PurchaseRepository purchaseRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private PurchaseProductRepository purchaseProductRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category category1 = new Category(null, "Informática");
		Category category2 = new Category(null, "Escritório");
		
		Product product1 = new Product(null, "Notebook", 1800.0);
		Product product2 = new Product(null, "Impressora", 400.0);
		Product product3 = new Product(null, "Mouse", 80.0);
		
		category1.getProducts().addAll(Arrays.asList(product1, product2, product3));
		category2.getProducts().addAll(Arrays.asList(product2));
		
		product1.getCategories().addAll(Arrays.asList(category1));
		product2.getCategories().addAll(Arrays.asList(category1, category2));
		product3.getCategories().addAll(Arrays.asList(category1));

		State state1 = new State(null, "Minas Gerais");
		State state2 = new State(null, "São Paulo");

		City city1 = new City(null, "Uberlândia", state1);
		City city2 = new City(null, "São Paulo", state2);
		City city3 = new City(null, "Campinas", state2);
		
		state1.getCities().addAll(Arrays.asList(city1));
		state2.getCities().addAll(Arrays.asList(city2, city3));

		Customer customer1 = new Customer(null, "Ana Paula", "ana@gmail.com", "39865644520", CustomerType.PHYSICAL);
		customer1.getTelephones().addAll(Arrays.asList("88569963", "99875263"));

		Address address1 = new Address(null, "Rua Flores", "120", "APTO 201", "Jardins", "5962050", customer1, city1);
		Address address2 = new Address(null, "Av Matos", "314", "Sala 800", "Centro", "62044230", customer1, city2);
		
		customer1.getAddresses().addAll(Arrays.asList(address1, address2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Purchase purchase1 = new Purchase(null, sdf.parse("30/09/2018 10:32"), customer1, address1);
		Purchase purchase2 = new Purchase(null, sdf.parse("10/10/2018 19:24"), customer1, address2);
		
		Payment payment1 = new PaymentCreditCard(null, PaymentStage.DONE, purchase1, 6);
		purchase1.setPayment(payment1);

		Payment payment2 = new PaymentSlip(null, PaymentStage.PENDING, purchase2, sdf.parse("20/10/2017 00:00"), null);
		purchase2.setPayment(payment2);
		
		customer1.getPurchases().addAll(Arrays.asList(purchase1));

		PurchaseProduct pp1 = new PurchaseProduct(product1, purchase1, 0.0, 1, 2000.0);
		PurchaseProduct pp2 = new PurchaseProduct(product3, purchase1, 0.0, 1, 80.0);
		PurchaseProduct pp3 = new PurchaseProduct(product2, purchase2, 100.0, 1, 800.0);
		
		purchase1.getItems().addAll(Arrays.asList(pp1, pp2));
		purchase2.getItems().addAll(Arrays.asList(pp3));

		product1.getItems().addAll(Arrays.asList(pp1));
		product2.getItems().addAll(Arrays.asList(pp3));
		product3.getItems().addAll(Arrays.asList(pp2));

		categoriaRepository.saveAll(Arrays.asList(category1, category2));

		productRepository.saveAll(Arrays.asList(product1, product2, product3));
		
		stateRepository.saveAll(Arrays.asList(state1, state2));
		
		cityRepository.saveAll(Arrays.asList(city1, city2, city3));
		
		customerRepository.saveAll(Arrays.asList(customer1));
		
		addressRepository.saveAll(Arrays.asList(address1, address2));

		purchaseRepository.saveAll(Arrays.asList(purchase1, purchase2));

		paymentRepository.saveAll(Arrays.asList(payment1, payment2));
		
		purchaseProductRepository.saveAll(Arrays.asList(pp1, pp2, pp3));
	}
}
