package com.pedrosantos.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrosantos.application.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
