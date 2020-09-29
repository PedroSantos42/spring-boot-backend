package com.pedrosantos.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrosantos.application.domain.Purchase;
import com.pedrosantos.application.repositories.PurchaseRepository;
import com.pedrosantos.application.service.exceptions.ObjectNotFoundException;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository repo;

	public Purchase find(Integer id) {
		Optional<Purchase> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Purchase.class.getName()));
	}
}
