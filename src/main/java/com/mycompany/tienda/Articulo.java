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
public abstract class Articulo {
    private String codigo;
    private String nombre;
    private float precio;
    private int stock;
    private ArrayList<Opinion> opinion;
	
    public Articulo(){
		
    }
	
    public Articulo(String c, String n, float p, int s) {
	setcodigo(c);
	setnombre(n);
	setprecio(p);
	setstock(s);
        opinion = new ArrayList<Opinion>();
    }
	
    public String getcodigo() {
	return codigo;
    }
    public String getnombre() {
	return nombre;
    }
    public float getprecio() {
	return precio;
    }
    public int getstock() {
        return stock;
    }
    public ArrayList<Opinion> getopinion(){
        return opinion;
    }
	
    public void setcodigo(String c) {
	codigo=c;
    }
    public void setnombre(String n) {
	nombre=n;
    }
    public void setprecio(float p) {
	precio=p;
    }
    public void setstock(int s) {
	stock=s;
    }
	
    @Override
    public String toString() {
	return "Codigo: "+codigo+"\nNombre: "+nombre+"\nmedia de opiniones: "+mediaopinion()+"\nPrecio: "+precio+"\nStock: "+stock;
    }
	
    @Override
    public boolean equals(Object o) {
        if(o == null) {
            return false;
	}
	if(this.getClass() != o.getClass()) {
            return false;
	}else {
            Articulo a = (Articulo) o;
            if(codigo.equals(a.getcodigo())) {
		return true;
            }else {
		return false;
            }
	}
    }
	
    public boolean disponible(int cantidad) {
	return cantidad<stock;
    }
	
    public String sinstock() {
	return "Codigo: "+codigo+"\nNombre: "+nombre+"\nmedia de opiniones: "+mediaopinion()+"\nPrecio: "+precio;
    }
    
    private float mediaopinion(){
        float media=0;
        
        for(Opinion a:opinion){
            if(a.puntuacion.equals(Puntuacion.excelente)){
                media=media+5;
            }
            if(a.puntuacion.equals(Puntuacion.muybueno)){
                media=media+4;
            }
            if(a.puntuacion.equals(Puntuacion.bueno)){
                media=media+3;
            }
            if(a.puntuacion.equals(Puntuacion.malo)){
                media=media+2;
            }
            if(a.puntuacion.equals(Puntuacion.terriblepapa)){
                media=media+1;
            }
        }
        
        media=media/opinion.size();
        
        return media;
    }
    
}
