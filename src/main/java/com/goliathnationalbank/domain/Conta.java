package com.goliathnationalbank.domain;

import java.util.Date;

import com.goliathnationalbank.enums.StatusConta;
import com.goliathnationalbank.enums.TipoConta;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String numeroConta;
	private String agencia;
	private Double saldo;
	private TipoConta tipoConta;
	private StatusConta status;
	private Date dataAbertura;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
}

