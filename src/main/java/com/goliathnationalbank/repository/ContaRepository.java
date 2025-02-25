package com.goliathnationalbank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goliathnationalbank.domain.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{
	Optional<Conta> findByNumeroConta(String numeroConta);
}
