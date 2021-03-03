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
public class Ropa extends Articulo{
    String color;
    int talla;
    
    public Ropa(){
        
    }
    
    public Ropa(String c, int t, String co, String n, float p, int s){
        super(co, n, p, s);
        color=c;
        talla=t;
    }
    
    @Override
    public String toString(){
        return super.toString()+"\ncolor:"+color+"\ntalla: "+talla;
    }
    
}
