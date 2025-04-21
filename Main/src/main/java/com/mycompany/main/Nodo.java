/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author VILLALV
 */
public class Nodo {
    private int dato;  
    private Nodo siguiente; 
    private String descripcion;
    private String nombrePregunta;
    private int orden;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;    
    }

    public Nodo(int orden, String nombrePregunta,String descripcion){
        this.orden = orden;
        this.descripcion = descripcion;
        this.nombrePregunta = nombrePregunta;
    }

    public int getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getOrden() {
        return orden;
    }

    public String getNombrePregunta() {
        return nombrePregunta;
    }

    public void setNombrePregunta(String nombrePregunta) {
        this.nombrePregunta = nombrePregunta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
