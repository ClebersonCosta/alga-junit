package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.modelo.Editor;
import com.algaworks.junit.blog.modelo.Ganhos;
import com.algaworks.junit.blog.modelo.Post;
import com.algaworks.junit.blog.utilidade.ProcessadorTextoSimples;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculadora de ganhos")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CalculadoraGanhosTest {

    static CalculadoraGanhos calculadora;

    @BeforeAll
    static void beforeAll() {
        calculadora = new CalculadoraGanhos(new ProcessadorTextoSimples(), BigDecimal.TEN);
    }

    Post post;
    Editor autor;

    @BeforeEach
    void beforeEach() {
        autor = new Editor(1L, "Cleberson", "cleberson@email.com", BigDecimal.TEN, false);
        post = new Post(1L, "Ecossistema Java", "O ecossistema do Java é muito maduro", autor, "ecossistema-java-123", null, false, false);
    }

    @Test
    @DisplayName("Dado um post premium, Quando calcular ganhos, Então deve calcular corretamente")
    void deveCalcularGanhos() {
        //Arrange
        autor.setPremium(true);

        //Act
        Ganhos ganhos = calculadora.calcular(post);

        //Assert
        assertEquals(new BigDecimal(80), ganhos.getTotalGanho());
    }

    @Test
    @DisplayName("Dado um post premium, Quando calcular ganhos, Então deve calcular corretamente a quantidade de palavras")
    void deveCalcularQuantidadePalavras() {
        //Arrange
        autor.setPremium(true);

        //Act
        Ganhos ganhos = calculadora.calcular(post);

        //Assert
        assertEquals(7, ganhos.getQuantidadePalavras());
    }

    @Test
    @DisplayName("Dado um post premium, Quando calcular ganhos, Então deve calcular corretamente o valor pago por palavra")
    void deveCalcularValorPagoPorPalavra() {
        //Arrange
        autor.setPremium(true);

        //Act
        Ganhos ganhos = calculadora.calcular(post);

        //Assert
        assertEquals(autor.getValorPagoPorPalavra(), ganhos.getValorPagoPorPalavra());
    }

    @Test
    @DisplayName("Dado um post não premium, Quando calcular ganhos, Então deve calcular corretamente")
    void deveCalcularGanhosSemBonus() {
        //Act
        Ganhos ganhos = calculadora.calcular(post);

        //Assert
        assertEquals(new BigDecimal(70), ganhos.getTotalGanho());
    }
}