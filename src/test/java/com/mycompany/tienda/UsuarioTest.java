/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tienda;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ismael m
 */
public class UsuarioTest {
    
    public UsuarioTest() {
    }

    /**
     * Test of compcont method, of class Usuario.
     */
    @Test
    public void testCompcont() {
        Usuario instance = new Usuario("holahola", "HOlaHOla", "hola@gmail.com");
        boolean result = instance.compcont();
        assertTrue(result);
    }

    /**
     * Test of compnombre method, of class Usuario.
     */
    @Test
    public void testCompnombre() {
        Usuario instance = new Usuario("holahola", "HOlaHOla", "hola@gmail.com");
        boolean result = instance.compnombre();
        assertTrue(result);
    }

    /**
     * Test of compemail method, of class Usuario.
     */
    @Test
    public void testCompemail() {
        Usuario instance = new Usuario("holahola", "HOlaHOla", "hola@gmail.com");
        boolean result = instance.compemail();
        assertTrue(result);
    }
    
}
