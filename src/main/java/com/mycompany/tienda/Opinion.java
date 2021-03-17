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
public class Opinion implements Comparable<Opinion>{
    Usuario usuario;
    Puntuacion puntuacion;
    String comentario;
    int votopositivo;
    int votonegativo;
    
    public Opinion(){
        votopositivo=0;
        votonegativo=0;  
    }
    
    public Opinion(Usuario u, Puntuacion p, String c){
        usuario=u;
        puntuacion=p;
        comentario=c;
        votopositivo=0;
        votonegativo=0;
    }
    
    public void sumapositivo(){
        votopositivo++;
    }
    
    public void sumanegativo(){
        votonegativo++;
    }
    
    @Override
    public String toString(){
        return usuario.getNombre()+
                "\n------------------\npuntuacion: "+
                puntuacion+
                "\ncomentario: "+
                comentario+
                "\nlike: "+
                votopositivo+
                " dislike: "+
                votonegativo;
    }

    @Override
    public int compareTo(Opinion o) {
       int a=0;
       int punt=0;
       int punto=0;
       
       switch(puntuacion){
           case excelente:
               punt=5;
               break;
           case muybueno:
               punt=4;
               break;
           case bueno:
               punt=3;
               break;
           case malo:
               punt=2;
               break;
           case terriblepapa:
               punt=2;
               break;
       }
       
       switch(o.puntuacion){
           case excelente:
               punto=5;
               break;
           case muybueno:
               punto=4;
               break;
           case bueno:
               punto=3;
               break;
           case malo:
               punto=2;
               break;
           case terriblepapa:
               punto=2;
               break;
       }
       
       if(punt==punto){
           a = 0;
       }else if(punt>punto){
           a = 1;
       }else{
           a = -1;
       }
       
       return a;
    }

}
