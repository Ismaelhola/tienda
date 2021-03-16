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
public class Opinion {
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

}
