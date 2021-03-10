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
public class Usuario {
    private String nombre;
    private String password;
    private String email;
    
    public Usuario(){
        
    }
    public Usuario(String n, String p, String e){
        setNombre(n);
        setPassword(p);
        setEmail(e);
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean compcont(){
        boolean salir=false;
        if(password.matches(".*[A-Z].*")){
            if(password.length()>=8){
                salir=true;
            }
        }
        return salir;
    }
    
    public boolean compnombre(){
        boolean salir=false;
        if(nombre.length()>=6){
            salir=true;
        }
        return salir;
    }
    
    public boolean compemail(){
        return email.matches("[-\\w\\.]+@\\w+\\.\\w+");
    }    
}
