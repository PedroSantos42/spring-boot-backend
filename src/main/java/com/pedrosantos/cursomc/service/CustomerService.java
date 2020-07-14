package com.pedrosantos.cursomc.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pedrosantos.cursomc.domain.Customer;
import com.pedrosantos.cursomc.dto.CustomerDTO;
import com.pedrosantos.cursomc.repositories.CustomerRepository;
import com.pedrosantos.cursomc.service.exceptions.DataIntegrityException;
import com.pedrosantos.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;

	public Customer find(Integer id) {
		Optional<Customer> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Customer.class.getSimpleName()));
	}

	public Customer insert(Customer obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Customer update(Customer obj) {
		find(obj.getId());
		return repo.save(obj);
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

	public Customer fromDTO(@Valid CustomerDTO objDto) {
		// return new Customer(objDto.getId(), objDto.getName(), objDto.getEmail(),
		// objDto.);
		return null;
	}
}