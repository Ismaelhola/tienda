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
    private String color;
    private Talla talla;
    
    public Ropa(){
       
    }
    
    public Ropa(String c, Talla t, String co, String n, float p, int s){
        super(co, n, p, s);
        color=c;
        talla=t;
    }
    
    
    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the talla
     */
    public Talla getTalla() {
        return talla;
    }

    /**
     * @param talla the talla to set
     */
    public void setTalla(Talla talla) {
        this.talla = talla;
    }
    
    @Override
    public String toString(){
        return super.toString()+"\ncolor: "+getColor()+"\ntalla: "+getTalla();
    }
    
    @Override
    public void applypromo(String codpromo){
        if(codpromo.equals("ROPAPROMO")){
            this.setprecio(((float)this.getprecio()*0.8));
        }
    }
    
}
