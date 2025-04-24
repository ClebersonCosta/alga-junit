package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void assercoesAgrupadas() {
        Pessoa pessoa = new Pessoa("Cleberson", "Costa");
        assertAll(
                () -> assertEquals("Cleberson", pessoa.getNome()),
                () -> assertEquals("Costa", pessoa.getSobrenome())
        );
    }
}