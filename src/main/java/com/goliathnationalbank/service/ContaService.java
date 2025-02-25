package com.goliathnationalbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goliathnationalbank.domain.Conta;
import com.goliathnationalbank.exception.InsufficientFundsException;
import com.goliathnationalbank.repository.ContaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	
	
	public Conta criarConta(Conta conta) {
		return contaRepository.save(conta);
	}

	public Conta deposito(Long contaId, Double valor) {
		Conta conta = contaRepository.findById(contaId)
				.orElseThrow(() -> new EntityNotFoundException("Conta não encontrada."));
		conta.setSaldo(conta.getSaldo() + valor);
		return contaRepository.save(conta);
	}
	
	public Conta sacar(Long contaId, Double valor) {
		Conta conta = contaRepository.findById(contaId)
				.orElseThrow(() -> new EntityNotFoundException("Conta não encontrada."));
		
		if(conta.getSaldo() < valor) {
			throw new InsufficientFundsException("Saldo insuficiente");
		}
		conta.setSaldo(conta.getSaldo() - valor);
		return contaRepository.save(conta);
	}
}
