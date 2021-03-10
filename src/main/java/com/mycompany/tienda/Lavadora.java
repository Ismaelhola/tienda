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
public class Lavadora extends Electrodomestico{
    private int potencia;
    private int volumen;
    private float consumo;
    private Marca marca;
    
    public Lavadora(){
        
    }
    public Lavadora(String cod, String n, float pe, int s,ClasE cl, String g, int po, int v, float con, Marca m){
        super(cod, n, pe, s, cl, g);
        setPotencia(po);
        setVolumen(v);
        setConsumo(con);
        setMarca(m);
        
    }

    /**
     * @return the potencia
     */
    public int getPotencia() {
        return potencia;
    }
    
    /**
     * @return the volumen
     */
    public int getVolumen() {
        return volumen;
    }
    
    /**
     * @return the consumo
     */
    public float getConsumo() {
        return consumo;
    }
    
    /**
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }
    
    /**
     * @param potencia the potencia to set
     */
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    /**
     * @param volumen the volumen to set
     */
    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }
    
    /**
     * @param consumo the consumo to set
     */
    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }
    
    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    @Override
    public String toString(){
        return super.toString()+"\nPotencia: "+potencia+"W \nvolumen: "+volumen+"L \nconsumo: "+consumo+"L \nmarca: "+marca;
    }
    
}
