package com.goliathnationalbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goliathnationalbank.controller.dtos.ClienteDTO;
import com.goliathnationalbank.domain.Cliente;
import com.goliathnationalbank.service.ClienteService;

@RestController()
@RequestMapping("/users")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Cliente> createUser(@RequestBody ClienteDTO cliente){
		Cliente novoCliente = clienteService.createUser(cliente);
		return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> getAllUsers(){
		List<Cliente> clientes = this.clienteService.getAllUsers();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id){
		this.clienteService.deleteCliente(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado){
		Cliente cliente = clienteService.updateCliente(id, clienteAtualizado);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
}
