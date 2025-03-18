package com.goliathnationalbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goliathnationalbank.domain.Conta;
import com.goliathnationalbank.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaService contaService;
	
	@PostMapping
	public ResponseEntity<Conta> criarConta(@RequestBody Conta conta){
		Conta novaConta = contaService.criarConta(conta);
		return new ResponseEntity<>(novaConta, HttpStatus.CREATED);
	}
	
	@PostMapping("/depositar")
	public ResponseEntity<Conta> depositar(@RequestBody Long contaId, @RequestBody Double valor){
		Conta conta = contaService.deposito(contaId, valor);
		return new ResponseEntity<>(conta, HttpStatus.OK);
	}
	
	public ResponseEntity<Conta> sacar(@RequestBody Long contaId, @RequestBody Double valor){
		Conta conta = contaService.sacar(contaId, valor);
	
		return new ResponseEntity<>(conta, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Conta>> getAllContas(){
		List<Conta> contas = this.contaService.getAllContas();
		return new ResponseEntity<>(contas, HttpStatus.OK);
	}
}
