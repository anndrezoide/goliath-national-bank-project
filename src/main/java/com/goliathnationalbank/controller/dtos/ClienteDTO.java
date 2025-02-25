package com.goliathnationalbank.controller.dtos;

import java.util.Date;

import com.goliathnationalbank.enums.Genero;

public record ClienteDTO(String primeiroNome, String ultimoNome, Date dataNascimento, String cpf, Genero genero) {

}
