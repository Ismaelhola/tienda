/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tienda;
import java.util.ArrayList;
/**
 *
 * @author Ismael m
 */
public class Carrito {
    ArrayList<Articulocarrito>pedido;
	float total;
	boolean confirmado;
	
	public static boolean CONFIRMADO=true;
	public static boolean PENDIENTE=false;
	
	public Carrito() {
		pedido= new ArrayList<Articulocarrito>();
		total=0;
		confirmado=PENDIENTE;
	}
	
	private float calculatotal() {
		float resultado=0;
		for(Articulocarrito a: pedido) {
			resultado=resultado+(a.elemento.getprecio()*a.cantidad);
		}
		return resultado;
	}
	
	public void meterarticulo(Articulo a, int c) {
		boolean found = false;
		for(Articulocarrito ac : pedido) {
			if(ac.elemento.equals(a)) {
				ac.cantidad = ac.cantidad+c;
				found=true;
			}
		}
		if(!found) {
			Articulocarrito nuevo = new Articulocarrito(a, c);
			pedido.add(nuevo);
		}
		total=calculatotal();
	}
	
	public String mostrarcarrito() {
		StringBuilder sb= new StringBuilder();
		sb.append("Carrito:\n");
		for(Articulocarrito ac: pedido) {
			sb.append(ac);
		}
		sb.append(" total: ").append(total);
		if(confirmado) {
			sb.append("\nEstado: confirmado");
		}else {
			sb.append("\nEstado: pendiente");
		}
		
		return sb.toString();
	}
	
	public void confirmar() {
		confirmado=CONFIRMADO;
	}
}
