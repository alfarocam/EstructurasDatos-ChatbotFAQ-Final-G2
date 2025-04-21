/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author VILLALV
 */
public class NodoArbol {

    private Nodo dato;
    private NodoArbol izquierda;
    private NodoArbol derecha;
    private ListaEnlazada preguntasHijas;

    public NodoArbol(Nodo dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
        this.preguntasHijas = null;
    }

    public Nodo getDato() {
        return dato;
    }

    public void setDato(Nodo dato) {
        this.dato = dato;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }

    public void setPreguntasHijas(ListaEnlazada preguntasHijas) {
        this.preguntasHijas = preguntasHijas;
    }

    public ListaEnlazada getPreguntasHijas() {
        return preguntasHijas;
    }
}
