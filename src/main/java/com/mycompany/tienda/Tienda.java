/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tienda;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Ismael m
 */
public class Tienda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn= new Scanner(System.in);
		Scanner sct= new Scanner(System.in);
		
		int opcion= 0;
		Carrito carro= new Carrito();
		ArrayList<Articulo>catalogo= new ArrayList<Articulo>();
		
		inicializarcatalogo(catalogo);		
		
		do {
			menu();
			opcion= scn.nextInt();
			
			switch(opcion) {
				case 0:
					System.out.println("Muchas gracias por su compra");
					break;
				case 1:
					meterarticulocatalogo(catalogo, scn, sct);
					mostrarcatalogo(catalogo);
					break;
				case 2:
					comprar(catalogo, carro, sct, scn);
					break;
				case 3:
					confirmarcarrito(carro,scn,catalogo);
					break;
				default:
					System.out.println("Esta opcion no existe escribe otra");
					break;
			}
		}while(opcion!=0);
		
		scn.close();
		sct.close();

	}
	private static void inicializarcatalogo(ArrayList<Articulo> c) {
		c.add(new Articulo("0001", "Monitor", 200.00F, 10));
		c.add(new Articulo("0002", "Teclado", 10.00F, 100));
		c.add(new Articulo("0003", "RJ45 2M", 4.50F, 50));
		c.add(new Articulo("0004", "Raton", 20.00F, 15));
	}
	
	private static void menu() {
		System.out.println("Estas son las opciones");
		System.out.println("1. Alta articulo");
		System.out.println("2. Comprar");
		System.out.println("3. Confirmar compra");
		System.out.println("0. salir");
		System.out.println("¿Cual es tu opcion?");
	}
	
	private static void meterarticulocatalogo(ArrayList<Articulo> c, Scanner scn, Scanner sct) {
		String codigo;
		String nombre;
		float precio;
		int stock;
		System.out.println("Introduce el codigo:");
		codigo=sct.nextLine();
		System.out.println("Introduce el nombre:");
		nombre=sct.nextLine();
		System.out.println("Introduce el precio");
		precio=scn.nextFloat();
		System.out.println("Introduce el stock");
		stock=scn.nextInt();
		c.add(new Articulo(codigo, nombre, precio, stock));
	}
	
	private static void mostrarcatalogo(ArrayList<Articulo>c) {
		for(Articulo a: c) {
			System.out.println(a+"\n");
		}
	}
	

	private static void comprar(ArrayList<Articulo>c, Carrito ca, Scanner sct, Scanner scn) {
		int opcions=0;
		do {
			String codigo;
			int cantidad;
			boolean salir=false;
			boolean entrar=true;
			int opcion=0;
			Articulo meter=new Articulo();
			
			mostrarcatalogo(c);
			do {
				System.out.println("¿Que articulo quieres comprar?");
				System.out.println("Escribe el codigo del articulo:");
				codigo=sct.nextLine();
				for(int i=0; i<c.size(); i++) {
					if(c.get(i).getcodigo().equals(codigo)) {
						salir=true;
						meter=c.get(i);
					}
				}
				if(salir==false) {
					System.out.println("no existe ese articulo coje otro");
				}
			}while(salir!=true);
			salir=false;
			do {
				System.out.println("¿Que cantidad quieres?");
				cantidad=scn.nextInt();
				if(meter.disponible(cantidad)==true){
					salir=true;
					entrar=true;
				}
				if(salir==false) {
					System.out.println("no tenemos articulos necesarios para darte");
					System.out.println("¿Quieres pedir menos o que no se realize la operacion?");
					System.out.println("1. escojo menos articulos");
					System.out.println("2. cancelo la operacion");
					System.out.println("¿Que opcion elijes?");
					opcion=scn.nextInt();
					if(opcion==2) {
						salir=true;
					}
				}
			}while(salir!=true);
			
			if(entrar==true) {
				ca.meterarticulo(meter, cantidad);
				ca.mostrarcarrito();
			}
			System.out.println("¿Quieres seguir comprando?");
			System.out.println("1.si 0.no");
			System.out.println("Escribe tu opcion aqui:");
			opcions=scn.nextInt();
		}while(opcions!=0);
		
	}
	
	private static void confirmarcarrito(Carrito c, Scanner sc, ArrayList<Articulo>ca) {
		int opcion=0;
		
		System.out.println(c.mostrarcarrito());
		System.out.println("Esta es tu compra estas seguro que no quieres añadir mas articulos");
		System.out.println("1. quiero confirmar ya");
		System.out.println("2. quiero comprar mas");
		System.out.println("Escribe tu opcion aqui:");
		opcion=sc.nextInt();
		if(opcion==1) {
			c.confirmar();
			for(int i=0; i<c.pedido.size(); i++) {
				for(int j=0; j<ca.size(); j++) {
					if(c.pedido.get(i).elemento.getcodigo().equals(ca.get(j).getcodigo())) {
						ca.get(j).setstock((ca.get(j).getstock())-(c.pedido.get(i).cantidad));
					}
				}
			}
			System.out.println(c.mostrarcarrito());
			System.out.println("Esta a sido tu compra.");
			c = new Carrito();
			mostrarcatalogo(ca);
		}
	}
    
}
