package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para Conta Bancaria")
class ContaBancariaTest {

    @Nested
    @DisplayName("Criando uma Conta Bancaria")
    class CriandoUmaContaBancaria {
        @Test
        void quandoCriarContaComSaldoNuloDeveLancarExcecao() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new ContaBancaria(null));
            assertEquals("Saldo não pode ser nulo", exception.getMessage());
        }

        @Test
        void quandoCriarContaComSaldoZeradoNaoDeveLancarExcecao() {
            assertDoesNotThrow(() -> new ContaBancaria(BigDecimal.ZERO));
        }

        @Test
        void quandoCriarContaComSaldoNegativoNaoDeveLancarExcecao() {
            assertDoesNotThrow(() -> new ContaBancaria(BigDecimal.valueOf(-1)));
        }

        @Test
        void quandoCriarContaComSaldoPositivoNaoDeveLancarExcecao() {
            assertDoesNotThrow(() -> new ContaBancaria(BigDecimal.valueOf(1)));
        }
    }

    @Nested
    @DisplayName("Realizando Saque")
    class RealizandoSaque {

        ContaBancaria conta;

        @BeforeEach
        void setUp() {
            conta = new ContaBancaria(BigDecimal.valueOf(100));
        }

        @Test
        void quandoRealizarSaqueComValorNuloDeveLancarExcecao() {
//            ContaBancaria conta = new ContaBancaria(BigDecimal.valueOf(100));
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> conta.saque(null));
            assertEquals("Valor não pode ser nulo, zero ou menor que zero", exception.getMessage());
        }

        @Test
        void quandoRealizarSaqueComValorZeroDeveLancarExcecao() {
//            ContaBancaria conta = new ContaBancaria(BigDecimal.valueOf(100));
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> conta.saque(BigDecimal.ZERO));
            assertEquals("Valor não pode ser nulo, zero ou menor que zero", exception.getMessage());
        }

        @Test
        void quandoRealizarSaqueComValorNegativoDeveLancarExcecao() {
//            ContaBancaria conta = new ContaBancaria(BigDecimal.valueOf(100));
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> conta.saque(BigDecimal.valueOf(-1)));
            assertEquals("Valor não pode ser nulo, zero ou menor que zero", exception.getMessage());
        }

        @Test
        void quandoRealizarSaqueComSaldoInsuficienteDeveLancarExcecao() {
//            ContaBancaria conta = new ContaBancaria(BigDecimal.valueOf(100));
            RuntimeException exception = assertThrows(RuntimeException.class, () -> conta.saque(BigDecimal.valueOf(101)));
            assertEquals("Saldo insuficiente", exception.getMessage());
        }

        @Test
        void quandoRealizarSaqueComSaldoSuficienteNaoDeveLancarExcecao() {
//            ContaBancaria conta = new ContaBancaria(BigDecimal.valueOf(100));
            assertDoesNotThrow(() -> conta.saque(BigDecimal.valueOf(100)));
        }
    }

    @Nested
    @DisplayName("Realizando Deposito")
    class RealizandoDeposito {

        ContaBancaria conta;

        @BeforeEach
        void setUp() {
            conta = new ContaBancaria(BigDecimal.valueOf(100));
        }

        @Test
        void quandoRealizarDepositoComValorNuloDeveLancarExcecao() {
//            ContaBancaria conta = new ContaBancaria(BigDecimal.valueOf(100));
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> conta.deposito(null));
            assertEquals("Valor não pode ser nulo, zero ou menor que zero", exception.getMessage());
        }

        @Test
        void quandoRealizarDepositoComValorZeroDeveLancarExcecao() {
//            ContaBancaria conta = new ContaBancaria(BigDecimal.valueOf(100));
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> conta.deposito(BigDecimal.ZERO));
            assertEquals("Valor não pode ser nulo, zero ou menor que zero", exception.getMessage());
        }

        @Test
        void quandoRealizarDepositoComValorNegativoDeveLancarExcecao() {
//            ContaBancaria conta = new ContaBancaria(BigDecimal.valueOf(100));
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> conta.deposito(BigDecimal.valueOf(-1)));
            assertEquals("Valor não pode ser nulo, zero ou menor que zero", exception.getMessage());
        }

        @Test
        void quandoRealizarDepositoComValorPositivoNaoDeveLancarExcecao() {
//            ContaBancaria conta = new ContaBancaria(BigDecimal.valueOf(100));
            assertDoesNotThrow(() -> conta.deposito(BigDecimal.valueOf(100)));
        }
    }

    @Test
    void quandoConsultarSaldoDeveRetornarValor() {
        ContaBancaria conta = new ContaBancaria(BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(100), conta.saldo());
    }
}