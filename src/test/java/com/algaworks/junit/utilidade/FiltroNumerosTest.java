package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FiltroNumerosTest {

    @Test
    void deve_retornar_numeros_pares_() {
        List<Integer> lista = Arrays.asList(1, 2, 3, 4);
        List<Integer> numerosEsperados = Arrays.asList(2, 4);
        List<Integer> resultado = FiltroNumeros.numerosPares(lista);
        assertIterableEquals(numerosEsperados, resultado);
    }

    @Test
    void deve_Retornar_Numeros_Impares_() {
        List<Integer> lista = Arrays.asList(1, 2, 3, 4);
        List<Integer> numerosEsperados = Arrays.asList(1, 3);
        List<Integer> resultado = FiltroNumeros.numerosImpares(lista);
        assertArrayEquals(numerosEsperados.toArray(new Object[]{}), resultado.toArray(new Object[]{}));
    }

    @Test
    void deve_Aceitar_Somente_Numero_Positivo_() {
        boolean positivo = FiltroNumeros.isPositivo(1);
        assertTrue(positivo);
    }

}