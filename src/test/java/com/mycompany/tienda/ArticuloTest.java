/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tienda;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ismael m
 */
public class ArticuloTest {
    
    public ArticuloTest() {
    }

    /**
     * Test of disponible method, of class Articulo.
     */
    @Test
    public void testDisponible() {
        int cantidad = 1;
        Articulo articulo = new Articulo("0001", "Monitor", 200.00F, 10);
        boolean resultado = articulo.disponible(cantidad);
        assertTrue(resultado);
    }

    /**
     * Test of sinstock method, of class Articulo.
     */
    @Test
    public void testSinstock() {
        Articulo articulo = new Articulo("0001", "Monitor", 200.00F, 0);
        String resultadoesperado = "Codigo: 0001\nNombre: Monitor\nPrecio: 200.0";
        String resultado = articulo.sinstock();
        assertEquals(resultadoesperado, resultado);

    }
    
}
