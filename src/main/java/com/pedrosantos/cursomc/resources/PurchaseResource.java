package com.pedrosantos.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosantos.cursomc.domain.Purchase;
import com.pedrosantos.cursomc.service.PurchaseService;

@RestController
@RequestMapping(value = "/purchases")
public class PurchaseResource {

	@Autowired
	private PurchaseService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Purchase> list(@PathVariable Integer id) {
		
		Purchase obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
