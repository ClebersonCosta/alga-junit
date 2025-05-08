package com.algaworks.junit.utilidade;

import java.math.BigDecimal;

public class ContaBancaria {

    private BigDecimal saldo;

    public ContaBancaria(BigDecimal saldo) {
        //TODO 1 - validar saldo: não pode ser nulo, caso seja, deve lançar uma IllegalArgumentException
        if (saldo == null) {
            throw new IllegalArgumentException("Saldo não pode ser nulo");
        }

        //TODO 2 - pode ser zero ou negativo
        this.saldo = saldo;
    }

    public void saque(BigDecimal valor) {
        //TODO 1 - validar valor: não pode ser nulo, zero ou menor que zero, caso seja, deve lançar uma IllegalArgumentException
        if (valor == null ||valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor não pode ser nulo, zero ou menor que zero");
        }

        //TODO 2 - Se o saldo for insuficiente deve lançar uma RuntimeException
        if (this.saldo.subtract(valor).compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        //TODO 3 - Deve subtrair o valor do saldo
        this.saldo = this.saldo.subtract(valor);
    }

    public void deposito(BigDecimal valor) {
        //TODO 1 - validar valor: não pode ser nulo, zero ou menor que zero, caso seja, deve lançar uma IllegalArgumentException
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor não pode ser nulo, zero ou menor que zero");
        }

        //TODO 2 - Deve adicionar o valor ao saldo
        this.saldo = this.saldo.add(valor);
    }

    public BigDecimal saldo() {
        //TODO 1 - retornar saldo
        return this.saldo;
    }
}
