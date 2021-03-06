package com.pedrosantos.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrosantos.application.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
