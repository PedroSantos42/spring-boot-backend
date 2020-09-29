package com.pedrosantos.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrosantos.application.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
