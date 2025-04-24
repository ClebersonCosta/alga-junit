package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {

    @Test
    void saudar() {
        String saudacao = SaudacaoUtil.saudar(9);
        assertEquals("Bom dia", saudacao);
    }

    @Test
    void deveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> SaudacaoUtil.saudar(-10));
        assertEquals("Hora inválida", excecao.getMessage());
    }

    @Test
    void naoDeveLancarExcecao() {
        assertDoesNotThrow(() -> SaudacaoUtil.saudar(0));
    }

}