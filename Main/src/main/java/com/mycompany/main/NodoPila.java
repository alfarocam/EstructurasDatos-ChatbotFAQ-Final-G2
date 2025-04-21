/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author VILLALV
 */
public class NodoPila {
    private Dato miDato;  // Contendrá el valor
    private NodoPila abajo;  // Apunta al siguiente nodo en la pila

    // Constructor del nodo
    public NodoPila(Dato miDato) {
        this.miDato = miDato;
        this.abajo = null; // Apunta a null, ya que es el último nodo
    }

    // Getters y Setters
    public Dato getMiDato() {
        return miDato;
    }

    public void setMiDato(Dato miDato) {
        this.miDato = miDato;
    }

    public NodoPila getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoPila abajo) {
        this.abajo = abajo;
    }
}
