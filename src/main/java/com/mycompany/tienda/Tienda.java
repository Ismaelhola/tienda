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
        Carrito carrito= new Carrito();
        ArrayList<Articulo>catalogo= new ArrayList<Articulo>();
        ArrayList<Usuario>usuarios= new ArrayList<Usuario>();
        Usuario actual= new Usuario();
        
        inicializarcatalogo(catalogo);
        
        do{
            menuu();
            opcion=scn.nextInt();
            switch(opcion){
                case 0:
                    System.out.println("Muchas gracias por su compra");
                    break;
                case 1:
                    daraltausuario(usuarios, sct);
                    break;
                case 2:
                    actual=iniciarusuario(usuarios, sct);
                    if(actual!=null){
                        do {
                            menuc();
                            opcion= scn.nextInt();
                            
                            switch(opcion) {
                                case 1:
                                    meterarticulocatalogo(catalogo, scn, sct);
                                    mostrarcatalogo(catalogo);
                                    break;
                                case 2:
                                    comprar(catalogo, carrito, sct, scn);
                                    break;
                                case 3:
                                    confirmarcarrito(carrito,scn,catalogo);
                                    break;
                                case 4:
                                    mostrarcatalogo(catalogo);
                                    break;
                                case 5:
                                    veropiniones(catalogo, scn);
                                    break;
                                case 6:
                                    daropinio(catalogo, actual, sct, scn);
                                    break;
                                case 7:
                                    opcion=salirusuario(actual,scn,opcion);
                                    break;
                                default:
                                    System.out.println("Esta opcion no existe escribe otra");
                                    break;
                            }
                        }while(opcion!=7);
                    }
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
        c.add(new Ropa("azul",Talla.S,"0001", "pantalon", 20.00F, 10));
        c.add(new Electrodomestico("0002", "tostadora", 90.00F, 100, ClasE.C,"alta"));
        c.add(new Ropa("verde", Talla.XL,"0003", "sudadera", 40.50F, 50));
        c.add(new Ropa("rojo con rajas azules",Talla.L,"0004", "camiseta", 20.00F, 15));
        c.add(new Ropa("rojo", Talla.S, "0005", "jersey", 25.50F, 200));
        c.add(new Electrodomestico("0006", "nevera", 500.00F, 200, ClasE.A, "alta"));
        c.add(new Lavadora("0007", "lavadora", 200.00F, 100, ClasE.A, "alta", 1000, 30, 39.50F, Marca.Beko));
    }
    
    private static void menuu(){
        System.out.println("Estas son las opciones");
        System.out.println("1. dar alta usuario");
        System.out.println("2. iniciar usuario");
        System.out.println("0. salir");
        System.out.println("¿Cual es tu opcion?");
        
    }
    
    private static void menuc() {
        System.out.println("Estas son las opciones");
        System.out.println("1. Alta articulo");
        System.out.println("2. Comprar");
        System.out.println("3. Confirmar compra");
        System.out.println("4. mostrar catalogo");
        System.out.println("5. ver opiniones");
        System.out.println("6. dar opinion");
        System.out.println("7. salir usuario");
        System.out.println("¿Cual es tu opcion?");
    }
    
    private static void meterarticulocatalogo(ArrayList<Articulo> c, Scanner scn, Scanner sct) {
        String codigo;
        String nombre;
        float precio;
        int stock;
        String color;
        String gama;
        int opcion;
        boolean salir=false;
        
        do{
            System.out.println("¿Que tipo de articulo quieres añadir");
            System.out.println("1. electrodomestico");
            System.out.println("2. ropa");
            System.out.println("¿Que opcion eliges?");
            opcion=scn.nextInt();
            switch(opcion){
                case 1:
                    do{
                        salir=false;
                        System.out.println("¿cual es el codigo?");
                        codigo=sct.nextLine();
                        for(Articulo a : c){
                            if(a.getcodigo().equals(codigo)){
                             salir=true;
                                System.out.println("este codigo esta cojido escribe otro");
                            }
                        }
                    }while(salir);
                    System.out.println("¿Cual es el nombre?");
                    nombre=sct.nextLine();
                    System.out.println("¿Cual es el precio?");
                    precio=scn.nextFloat();
                    System.out.println("¿Cuanto stock tiene?");
                    stock=scn.nextInt();
                    System.out.println("¿Cual es la gama del producto?");
                    gama=sct.nextLine();
                    System.out.println("¿Que clasificacion electronica tiene?");
                    System.out.println("1. "+ClasE.A);
                    System.out.println("2. "+ClasE.B);
                    System.out.println("3. "+ClasE.C);
                    System.out.println("4. "+ClasE.D);
                    System.out.println("5. "+ClasE.E);
                    System.out.println("6. "+ClasE.F);
                    do{
                        salir=false;
                        System.out.println("¿Cual es tu opcion?");
                        opcion=scn.nextInt();
                        switch(opcion){
                            case 1:
                                c.add(new Electrodomestico(codigo, nombre, precio, stock, ClasE.A, gama));
                                break;
                            case 2:
                                c.add(new Electrodomestico(codigo, nombre, precio, stock, ClasE.B, gama));
                                break;
                            case 3:
                                c.add(new Electrodomestico(codigo, nombre, precio, stock, ClasE.C, gama));
                                break;
                            case 4:
                                c.add(new Electrodomestico(codigo, nombre, precio, stock, ClasE.D, gama));
                                break;
                            case 5:
                                c.add(new Electrodomestico(codigo, nombre, precio, stock, ClasE.E, gama));
                                break;
                            case 6:
                                c.add(new Electrodomestico(codigo, nombre, precio, stock, ClasE.F, gama));
                                break;
                            default:
                                System.out.println("Este clasificacion no existe");
                                salir=true;
                                break;
                        }
                    }while(salir);
                    System.out.println("Se ha añadido el articulo");
                    salir=true;
                    break;
                case 2:
                    do{
                        salir=false;
                        System.out.println("¿cual es el codigo?");
                        codigo=sct.nextLine();
                        for(Articulo a : c){
                            if(a.getcodigo().equals(codigo)){
                             salir=true;
                                System.out.println("este codigo esta cojido escribe otro");
                            }
                        }
                    }while(salir);
                    System.out.println("¿Cual es el nombre?");
                    nombre=sct.nextLine();
                    System.out.println("¿Cual es el precio?");
                    precio=scn.nextFloat();
                    System.out.println("¿Cuanto stock tiene?");
                    stock=scn.nextInt();
                    System.out.println("¿Cual es el color de la prenda?");
                    color=sct.nextLine();
                    System.out.println("¿Que talla tiene?");
                    System.out.println("1. "+Talla.XXS);
                    System.out.println("2. "+Talla.XS);
                    System.out.println("3. "+Talla.S);
                    System.out.println("4. "+Talla.M);
                    System.out.println("5. "+Talla.L);
                    System.out.println("6. "+Talla.XL);
                    System.out.println("7. "+Talla.XXL);
                    do{
                        salir=false;
                        System.out.println("¿Cual es tu opcion?");
                        opcion=scn.nextInt();
                        switch(opcion){
                            case 1:
                                c.add(new Ropa(color, Talla.XXS, codigo, nombre, precio, stock));
                                break;
                            case 2:
                                c.add(new Ropa(color, Talla.XS, codigo, nombre, precio, stock));
                                break;
                            case 3:
                                c.add(new Ropa(color, Talla.S, codigo, nombre, precio, stock));
                                break;
                            case 4:
                                c.add(new Ropa(color, Talla.M, codigo, nombre, precio, stock));
                                break;
                            case 5:
                                c.add(new Ropa(color, Talla.L, codigo, nombre, precio, stock));
                                break;
                            case 6:
                                c.add(new Ropa(color, Talla.XL, codigo, nombre, precio, stock));
                                break;
                            case 7:
                                c.add(new Ropa(color, Talla.XXL, codigo, nombre, precio, stock));
                                break;
                            default:
                                System.out.println("Este talla no existe");
                                salir=true;
                                break;
                        }
                    }while(salir);
                    System.out.println("Se ha añadido el articulo");
                    salir=true;
                    break;
                default:
                    System.out.println("Ese tipo de articulo no existe");
                    break;
            }
        }while(!salir);       
    }
    
    private static void mostrarcatalogo(ArrayList<Articulo> c) {
        for(Articulo a: c) {
            System.out.println(a+"\n");
        }
    }
    
    private static void comprar(ArrayList<Articulo> c, Carrito ca, Scanner sct, Scanner scn) {
        int opcions=0;
        do {
            String codigo;
            int cantidad;
            boolean salir=false;
            boolean entrar=true;
            int opcion=0;
            Articulo meter = null;
            
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
    
    private static void daraltausuario(ArrayList<Usuario> u, Scanner sc){
        Usuario nuevo = new Usuario();
        boolean correcto = false;
        
        do{
            System.out.println("Escribe el nombre del usuario:");
            nuevo.setNombre(sc.nextLine());
            correcto= nuevo.compnombre();
            if(correcto){
                for(Usuario a:u){
                    if(a.getNombre().equals(nuevo.getNombre())){
                        System.out.println("Este nombre ya esta cojido pon otro.");
                        correcto=false;
                    }
                }
            }else{
                System.out.println("Este nombre es muy corto escribe otro.");
            }
        }while(!correcto);
        
        do{
            System.out.println("Escribe la contraseña:");
            nuevo.setPassword(sc.nextLine());
            correcto=nuevo.compcont();
            if(!correcto){
                System.out.println("Esta contraseña no es valida escribe otra.");
            }
        }while(!correcto);
        
        do{
            System.out.println("Escribe el email:");
            nuevo.setEmail(sc.nextLine());
            correcto=nuevo.compemail();
            if(!correcto){
                System.out.println("Este email no es valida escribe otro.");
            }
        }while(!correcto);
        
        u.add(nuevo);
        System.out.println("el usuario "+nuevo.getNombre()+" a sido dado de alta.");
    }
    
    private static Usuario iniciarusuario(ArrayList<Usuario> u, Scanner sc){
        boolean salir=false;
        Usuario encontrado = new Usuario();
        String nombre;
        if(u.size()!=0){
            do{
                System.out.println("¿Cual es el usuario que quieres usar?");
                nombre=sc.nextLine();
                for(Usuario a: u){
                    if(a.getNombre().equals(nombre)){
                        encontrado=a;
                        salir=true;
                    }
                }
                if(!salir){
                    System.out.println("Este usuario no existe escribe otro.");
                }else{
                    do{
                        System.out.println("Escribe la contraseña:");
                        if(encontrado.getPassword().equals(sc.nextLine())){
                            salir=true;
                        }else{
                            System.out.println("Esta contraseña no es correcta escribe otra");
                            salir=false;
                        }
                    }while(!salir);
                }
                
            }while(!salir);
            
            System.out.println("Has iniciado con el usuario "+encontrado.getNombre());
        }else{
            System.out.println("no hay ningun usuario crea uno.");
            encontrado=null;
        }
        
        return encontrado;
    }
    
    private static void veropiniones(ArrayList<Articulo> c, Scanner sc){
        
        int opcion;
        
        for(int i=0;i<c.size();i++){
            System.out.println(c.get(i).toString());
            if(c.get(i).getopinion().size()!=0){
                for(Opinion a: c.get(i).getopinion()){
                    System.out.println(a.toString());
                    System.out.println("1. like");
                    System.out.println("2. dislike");
                    System.out.println("0. no poner nada");
                    System.out.println("¿Que Quieres hacer?");
                    opcion=sc.nextInt();
                    
                    if(opcion==1){
                        a.sumapositivo();
                    }else if(opcion==2){
                        a.sumanegativo();
                    }
                }
            }else{
                System.out.println("Este articulo no tiene opiniones");
            }
        }
        
    }
    
    private static void daropinio(ArrayList<Articulo> c, Usuario u, Scanner sct, Scanner scn){
        
        Opinion opinion = new Opinion();
        int opcion=0;
        String codigo;
        int contador=0;
        
        System.out.println("¿Cual es el codigo de articulo a opinar?");
        codigo=sct.nextLine();
        for(Articulo a:c){
            if(a.getcodigo().equals(codigo)){
                do{
                    opinion.usuario=u;
                    System.out.println("¿Que puntuacion quieres dar?");
                    System.out.println("1. "+Puntuacion.excelente);
                    System.out.println("2. "+Puntuacion.muybueno);
                    System.out.println("3. "+Puntuacion.bueno);
                    System.out.println("4. "+Puntuacion.malo);
                    System.out.println("5. "+Puntuacion.terriblepapa);
                    System.out.println("Escribe tu opcion:");
                    opcion=scn.nextInt();
                    switch(opcion){
                        case 1:
                            opinion.puntuacion=Puntuacion.excelente;
                            break;
                        case 2:
                            opinion.puntuacion=Puntuacion.muybueno;
                            break;
                        case 3:
                            opinion.puntuacion=Puntuacion.bueno;
                            break;
                        case 4:
                            opinion.puntuacion=Puntuacion.malo;
                            break;
                        case 5:
                            opinion.puntuacion=Puntuacion.terriblepapa;
                            break;
                        default:
                            System.out.println("Esta puntuacion no es correcta escribe otra.");
                            break;
                    }
                }while(opcion<1||opcion>5);
                System.out.println("Escribe tu comentario");
                opinion.comentario=sct.nextLine();
                a.getopinion().add(opinion);
            } else{
                contador++;
            }
        }
        if(contador==c.size()){
            System.out.println("este articulo no existe");
        }
    }
    
    private static int salirusuario(Usuario u, Scanner sc, int o){
        
        int opcion;
        
        System.out.println("¿Estas seguro que quieres salir del usuario actual?");
        System.out.println("1. si 2.no");
        opcion=sc.nextInt();
        if(opcion==1){
            u=new Usuario();
            System.out.println("has salido del usuario");
        }else{
            System.out.println("no se a borrado el usuario");
            o=0;
        }
        return o;
    }
    
}
