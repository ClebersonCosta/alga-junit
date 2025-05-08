package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {

    @Test
    void saudar() {
        //Arrange
        int horaValida = 9;

        //Act
        String saudacao = SaudacaoUtil.saudar(9);

        //Assert
        assertEquals("Bom dia", saudacao);
    }

    @Test
    void deveLancarExcecao() {
        //Arrange
        int horaInvalida = -10;

        //Act
        Executable executavel = () -> SaudacaoUtil.saudar(-10);

        //Assert
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, executavel);
        assertEquals("Hora inválida", excecao.getMessage());
    }

    @Test
    void naoDeveLancarExcecao() {
        assertDoesNotThrow(() -> SaudacaoUtil.saudar(0));
    }

    @Test
    void saudarBoaTarde() {
        String saudacao = SaudacaoUtil.saudar(12);
        assertEquals("Boa tarde", saudacao);
    }

    @Test
    void saudarBoaNoite() {
        String saudacao = SaudacaoUtil.saudar(18);
        assertEquals("Boa noite", saudacao);
    }

    @Test
    void saudarBomDiaAPartir5h() {
        String saudacao = SaudacaoUtil.saudar(5);
        assertEquals("Bom dia", saudacao);
    }

    @Test
    void saudarBoaNoiteAs4h() {
        String saudacao = SaudacaoUtil.saudar(4);
        assertEquals("Boa noite", saudacao);
    }

}