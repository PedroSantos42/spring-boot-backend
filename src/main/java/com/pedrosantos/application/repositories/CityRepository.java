package com.pedrosantos.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrosantos.application.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
