package com.goliathnationalbank.controller.dtos;

import java.time.LocalDate;

import com.goliathnationalbank.enums.Genero;

public record ClienteDTO(String primeiroNome, String ultimoNome, LocalDate dataNascimento, String cpf, Genero genero) {

}
