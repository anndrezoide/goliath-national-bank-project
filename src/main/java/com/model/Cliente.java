package com.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.model.enums.Genero;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cliente {
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String primeiroNome;
	private String ultimoNome;
	private Date dataNascimento;
	private String cpf;
	private Genero genero;
}
