/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author VILLALV
 */
public class NodoCola {
    private DatosJugadores datos; 
    private NodoCola siguiente;
    private NodoCola anterior;
    
    public NodoCola(DatosJugadores datos) {
        this.datos = datos;
        this.siguiente = null;
        this.anterior = null;
    }

    public DatosJugadores getDato() {
        return datos;
    }

    public void setDato(DatosJugadores datos) {
        this.datos = datos;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCola getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCola anterior) {
        this.anterior = anterior;
    }
    
}
