package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
