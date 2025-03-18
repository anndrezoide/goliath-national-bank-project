package com.goliathnationalbank.domain;

import java.time.LocalDate;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.goliathnationalbank.controller.dtos.ContaDTO;
import com.goliathnationalbank.enums.StatusConta;
import com.goliathnationalbank.enums.TipoConta;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "conta")
@Table(name = "conta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String numeroConta;
	private String agencia;
	private Double saldo;
	
	@Enumerated(EnumType.STRING)
	private TipoConta tipoConta;
	
	@Enumerated(EnumType.STRING)
	private StatusConta status;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataAbertura;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	public Conta(ContaDTO conta) {
		this.numeroConta = conta.numeroConta();
		this.agencia = conta.agencia();
		this.saldo = conta.saldo();
		this.tipoConta = conta.tipoConta();
		this.status = conta.status();
		this.dataAbertura = conta.dataAbertura();
		this.cliente = conta.cliente();
	}
}

