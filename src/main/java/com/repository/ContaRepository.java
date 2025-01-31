package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

}
