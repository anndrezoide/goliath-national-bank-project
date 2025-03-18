package com.goliathnationalbank.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.goliathnationalbank.controller.dtos.ClienteDTO;
import com.goliathnationalbank.enums.Genero;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "clientes")
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of= "id")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String primeiroNome;
	private String ultimoNome;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	
	
	@Column(unique = true)
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	public Cliente(ClienteDTO cliente) {
		this.primeiroNome = cliente.primeiroNome();
		this.ultimoNome = cliente.ultimoNome();
		this.dataNascimento = cliente.dataNascimento();
		this.cpf = cliente.cpf();
		this.genero = cliente.genero();
	}
}
