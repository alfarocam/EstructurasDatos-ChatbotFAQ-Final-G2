/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author VILLALV
 */
public class Pila {
    
    private NodoPila top; 

    public NodoPila getTop() {
        return top;
    }

    public void setTop(NodoPila top) {
        this.top = top;
    }
    
    public void pila(){
        top = null; //Inicializamos el nulo para indicar que la pila esta vacia

    }
    //metodo apilar 
    
    public void apilar(int valor){
    
    Dato miDato = new Dato(valor);
    //crear el nodo 
    NodoPila miNodo = new NodoPila(miDato);
    //hasta acá estamos creando el nodo que va a hacer apicado
    //vamos a aplicarlo
    if (top == null){
        top = miNodo;          //El nodo deja de estar vacio y apubta al nuevo Nodo creado
    }else{                    // si la pila no esta vacia 
        miNodo.setAbajo(top); // amarro mi nuevo nodo a mi top
        top = miNodo;         //mueve el top para dque vuelva a estar en la cima(nueva cima) 
        }

    }
    
    public Dato despilar(){
         if (top == null){
         System.out.println("Error la pila esta vacia, no puede desapilarce");
         return null;
         }else{
         // 1. guardar el tod en una variable temploral 
         Dato valorTemp = top.getMiDato();
         // 2. movemos el top al segundo
         top = top.getAbajo();
         // 3. retornar el valor
         return valorTemp;
         }
     }

     
    public boolean esVacia(){
        if (top == null)
            return true; 
        else
            return false;
        }
    public void imprimirPila(){
        if (esVacia()){
        System.out.println("La pila esta vacia");
        
        }
        else{
        NodoPila actual = top; //Creo una variable temporal y la igualo al top.
        while (actual != null){
            System.out.println(actual.getMiDato().getValor());
            actual = actual.getAbajo();
            
        }
        
        }
    }
}
