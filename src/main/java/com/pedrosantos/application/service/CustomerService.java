package com.pedrosantos.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pedrosantos.application.domain.Address;
import com.pedrosantos.application.domain.City;
import com.pedrosantos.application.domain.Customer;
import com.pedrosantos.application.domain.enums.CustomerType;
import com.pedrosantos.application.dto.CustomerDTO;
import com.pedrosantos.application.dto.CustomerNewDTO;
import com.pedrosantos.application.repositories.AddressRepository;
import com.pedrosantos.application.repositories.CustomerRepository;
import com.pedrosantos.application.service.exceptions.DataIntegrityException;
import com.pedrosantos.application.service.exceptions.ObjectNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private AddressRepository repoAddress;
	
	public Customer find(Integer id) {
		Optional<Customer> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Customer.class.getSimpleName()));
	}

	public Customer insert(Customer obj) {
		obj.setId(null);
		obj = repo.save(obj);
		repoAddress.saveAll(obj.getAddresses());
		return obj;
	}

	public Customer update(Customer obj) {
		Customer newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um cliente com associações!");
		}
	}

	public List<Customer> findAll() {
		return repo.findAll();
	}

	public Page<Customer> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Customer fromDTO(CustomerDTO objDto) {
		return new Customer(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null);
	}

	public Customer fromDTO(CustomerNewDTO objDto) {
		Customer customer1 = new Customer(null, objDto.getName(), objDto.getEmail(), objDto.getCpfCnpj(), CustomerType.toEnum(objDto.getType()));
		City city1 = new City(objDto.getCityId(), null, null);
		Address address1 = new Address(null, objDto.getStreet(), objDto.getNumber(), objDto.getDistrict(), objDto.getComplement(), objDto.getZipCode(), customer1, city1);
		customer1.getAddresses().add(address1);
		customer1.getTelephones().add(objDto.getTelephone1());
		if (objDto.getTelephone2() != null) {
			customer1.getTelephones().add(objDto.getTelephone2());
		}
		if (objDto.getTelephone3() != null) {
			customer1.getTelephones().add(objDto.getTelephone3());
		}
		return customer1;
	}

	private void updateData(Customer newObj, Customer obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
}