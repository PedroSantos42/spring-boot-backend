package com.pedrosantos.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrosantos.cursomc.domain.Purchase;
import com.pedrosantos.cursomc.repositories.PurchaseRepository;

import com.pedrosantos.cursomc.service.exceptions.ObjectNotFoundException;

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
