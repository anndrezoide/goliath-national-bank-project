package com.goliathnationalbank.controller.dtos;

import java.time.LocalDate;

import com.goliathnationalbank.domain.Cliente;
import com.goliathnationalbank.enums.StatusConta;
import com.goliathnationalbank.enums.TipoConta;

public record ContaDTO(String numeroConta, String agencia, Double saldo, TipoConta tipoConta, StatusConta status, LocalDate dataAbertura, Cliente cliente) {

}
