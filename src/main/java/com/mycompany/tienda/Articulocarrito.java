/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tienda;

/**
 *
 * @author Ismael m
 */
public class Articulocarrito {
    Articulo elemento;
	int cantidad;
	
	public Articulocarrito() {
		
	}
	
	public Articulocarrito(Articulo e, int c) {
		elemento=e;
		cantidad=c;
	}
	
	@Override
	public String toString() {
		return elemento.sinstock()+" x "+cantidad+"\n";
	}
}
