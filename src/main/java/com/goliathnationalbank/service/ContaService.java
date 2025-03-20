package com.goliathnationalbank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goliathnationalbank.domain.Cliente;
import com.goliathnationalbank.domain.Conta;
import com.goliathnationalbank.exception.InsufficientFundsException;
import com.goliathnationalbank.repository.ClienteRepository;
import com.goliathnationalbank.repository.ContaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void saveConta(Conta conta) {
		contaRepository.save(conta);
	}
	
	@Transactional
	public Conta criarConta(Conta conta) {
		Cliente cliente = conta.getCliente();
		Optional<Cliente> clienteExistente = clienteRepository.findByCpf(cliente.getCpf());
		
		if(clienteExistente.isPresent()) {
			conta.setCliente(clienteExistente.get());
		}else{
			clienteRepository.save(cliente);
		}
		return contaRepository.save(conta);
	}
	
	public Conta deposito(String numeroConta, Double valor) {
		Conta conta = contaRepository.findByNumeroConta(numeroConta)
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

	public List<Conta> getAllContas() {
		return this.contaRepository.findAll();
	}
}
