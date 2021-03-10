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
public class Electrodomestico extends Articulo{
    private ClasE clasificacionenergetica;
    private String gama;
    
    public Electrodomestico(){
        
    }
    
    public Electrodomestico(String co, String n, float p, int s,ClasE cl, String g){
        super(co, n, p, s);
        setClasificacionenergetica(cl);
        setGama(g);
    }

    /**
     * @return the clasificacionenergetica
     */
    public ClasE getClasificacionenergetica() {
        return clasificacionenergetica;
    }
    
    /**
     * @return the gama
     */
    public String getGama() {
        return gama;
    }

    /**
     * @param clasificacionenergetica the clasificacionenergetica to set
     */
    public void setClasificacionenergetica(ClasE clasificacionenergetica) {
        this.clasificacionenergetica = clasificacionenergetica;
    }
    
    /**
     * @param gama the gama to set
     */
    public void setGama(String gama) {
        this.gama = gama;
    }
    
    @Override
    public String toString(){
        return super.toString()+"\nclasificacion energetica:"+clasificacionenergetica+"\ngama :"+gama;
    }
}
