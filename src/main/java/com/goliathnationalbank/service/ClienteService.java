package com.goliathnationalbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.goliathnationalbank.controller.dtos.ClienteDTO;
import com.goliathnationalbank.domain.Cliente;
import com.goliathnationalbank.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void saveUser(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public Cliente createUser(ClienteDTO cliente) {
		Cliente novoCliente = new Cliente(cliente);
		this.saveUser(novoCliente);
		return novoCliente;
	}

	public List<Cliente> getAllUsers() {
		return this.clienteRepository.findAll();
	}
}
