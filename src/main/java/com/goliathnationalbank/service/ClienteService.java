package com.goliathnationalbank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goliathnationalbank.controller.dtos.ClienteDTO;
import com.goliathnationalbank.domain.Cliente;
import com.goliathnationalbank.exception.EntityNotFoundException;
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
	
	public void deleteCliente(Long id) {
		if(!clienteRepository.existsById(id)) {
			throw new EntityNotFoundException("Id do usuário não encontrado: " + id);
		}
		this.clienteRepository.deleteById(id);
	}
	
	public Cliente updateCliente(Long id, Cliente cliente) {
		Optional<Cliente> clienteExistente = clienteRepository.findById(id);
		
		if(clienteExistente.isPresent()) {
			Cliente clienteAtualizado = clienteExistente.get();
			
			clienteAtualizado.setPrimeiroNome(cliente.getPrimeiroNome());
			clienteAtualizado.setUltimoNome(cliente.getUltimoNome());
			clienteAtualizado.setGenero(cliente.getGenero());
			clienteAtualizado.setDataNascimento(cliente.getDataNascimento());
			clienteAtualizado.setCpf(cliente.getCpf());
			
			return clienteRepository.save(clienteAtualizado);
		}else {
			throw new EntityNotFoundException("Usuário não encontrado com o ID" + id);
		}
	}
}
