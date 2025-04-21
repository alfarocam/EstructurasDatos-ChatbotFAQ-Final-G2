/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import java.util.Scanner;
/**
 *
 * @author VILLALV
 */
public class Arbolchatbot {
    private NodoArbol raiz;

    public Arbolchatbot() {
        raiz = null;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public void insertar(Nodo dato) {
        raiz = insertarRec(raiz, dato);
    }
    Scanner scanner = new Scanner(System.in);
    NodoArbol insertarRec(NodoArbol nodoActual, Nodo valor) {
        if (nodoActual == null) {
            return new NodoArbol(valor);
        } else {
            if (valor.getOrden() < nodoActual.getDato().getOrden()) {
                nodoActual.setIzquierda(insertarRec(nodoActual.getIzquierda(), valor));
            } else if (valor.getOrden() > nodoActual.getDato().getOrden()) {
                nodoActual.setDerecha(insertarRec(nodoActual.getDerecha(), valor));
            }
        }
        return nodoActual;
    }

    public void inOrden() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(NodoArbol actual) {
        if (actual != null) {
            inOrdenRec(actual.getIzquierda());
            System.out.println("Orden: " + actual.getDato().getOrden() + " - " + actual.getDato().getDescripcion());
            inOrdenRec(actual.getDerecha());
        }
    }

    public void preOrden() {
        preOrdenRec(raiz);
    }

    private void preOrdenRec(NodoArbol actual) {
        if (actual != null) {
            System.out.println("Orden: " + actual.getDato().getOrden() +
                            " - Pregunta: " + actual.getDato().getNombrePregunta() +
                            " - Respuesta: " + actual.getDato().getDescripcion());
        }
    }

    public void postOrden() {
        postOrdenRec(raiz);
    }

    private void postOrdenRec(NodoArbol actual) {
        if (actual != null) {
            postOrdenRec(actual.getIzquierda());
            postOrdenRec(actual.getDerecha());
            System.out.println("Orden: " + actual.getDato().getOrden() +
                            " - Pregunta: " + actual.getDato().getNombrePregunta() +
                            " - Respuesta: " + actual.getDato().getDescripcion());
        }
    }
    public void postOrdenRecpregunta1() {
        postOrdenRecpregunta1(raiz);
    }

    private void postOrdenRecpregunta1(NodoArbol actual) {
        if (actual != null) {
            postOrdenRecpregunta1(actual.getIzquierda());
            postOrdenRecpregunta1(actual.getDerecha());

            if (actual.getDato().getNombrePregunta().trim().equals("Preguntas Frecuentes")) {
                System.out.println(actual.getDato().getNombrePregunta() + actual.getDato().getDescripcion());
            }
        }
    }
    public void postOrdenPrueba() {
        postOrdenRecPrueva(raiz);

        System.out.println("Si no tienes preguntas, escribe 'Regresar' para salir al menu.");
        System.out.print("Cual pregunta tienes?: ");
        String seleccion = scanner.nextLine();

        if (seleccion.equalsIgnoreCase("Regresar")) {
            // Simplemente salimos del método sin repetir
            return;
        }

        if (!buscarYMostrarDescripcion(raiz, seleccion)) {
            System.out.println("No se encontró esa pregunta.");
        }

        // Solo volvemos a preguntar si no escribió "Regresar"
        postOrdenPrueba();
    }

    private void postOrdenRecPrueva(NodoArbol actual) {
        if (actual != null) {
            postOrdenRecPrueva(actual.getIzquierda());
            postOrdenRecPrueva(actual.getDerecha());
            System.out.println("Preguntas: " + actual.getDato().getNombrePregunta());
        }
    }

    private boolean buscarYMostrarDescripcion(NodoArbol actual, String seleccion) {
        if (actual != null) {
            if (actual.getDato().getNombrePregunta().equalsIgnoreCase(seleccion.trim())) {
                System.out.println("\nRespuesta: " + actual.getDato().getDescripcion());
                return true;
            }

            // Buscar en la izquierda o derecha
            boolean encontradoIzq = buscarYMostrarDescripcion(actual.getIzquierda(), seleccion);
            boolean encontradoDer = buscarYMostrarDescripcion(actual.getDerecha(), seleccion);
            return encontradoIzq || encontradoDer;
        }

        return false;
    }

    private NodoArbol buscarNodo(NodoArbol actual, int orden) {
        if (actual == null) return null;

        if (actual.getDato().getOrden() == orden) {
            return actual;
        }

        NodoArbol nodoIzquierda = buscarNodo(actual.getIzquierda(), orden);
        if (nodoIzquierda != null) return nodoIzquierda;

        return buscarNodo(actual.getDerecha(), orden);
    }
    public void eliminar(Nodo valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private NodoArbol eliminarRec(NodoArbol actual, Nodo valor) {
        if (actual == null) return actual;

        if (valor.getOrden() < actual.getDato().getOrden()) {
            actual.setIzquierda(eliminarRec(actual.getIzquierda(), valor));
        } else if (valor.getOrden() > actual.getDato().getOrden()) {
            actual.setDerecha(eliminarRec(actual.getDerecha(), valor));
        } else {
            if (actual.getIzquierda() == null && actual.getDerecha() == null) {
                return null;
            }
            if (actual.getIzquierda() == null)
                return actual.getDerecha();
            else if (actual.getDerecha() == null)
                return actual.getIzquierda();

            NodoArbol sucesor = minValorSucesor(actual.getDerecha());
            actual.setDato(sucesor.getDato());
            actual.setDerecha(eliminarRec(actual.getDerecha(), sucesor.getDato()));
        }
        return actual;
    }

    private NodoArbol minValorSucesor(NodoArbol nodo) {
        while (nodo.getIzquierda() != null) {
            nodo = nodo.getIzquierda();
        }
        return nodo;
    }

    public int obtenerNivel(Nodo valor, int nivel) {
        return obtenerNivelRec(raiz, valor, nivel);
    }

    public int obtenerNivelRec(NodoArbol actual, Nodo valor, int nivel) {
        if (actual == null) return -1;
        if (actual.getDato().getOrden() == valor.getOrden()) return nivel;
        int nivelIzq = obtenerNivelRec(actual.getIzquierda(), valor, nivel + 1);
        if (nivelIzq != -1) return nivelIzq;
        return obtenerNivelRec(actual.getDerecha(), valor, nivel + 1);
    }

    public int obtenerAltura(NodoArbol actual) {
        if (actual == null) return -1;
        int alturaIzq = obtenerAltura(actual.getIzquierda());
        int alturaDer = obtenerAltura(actual.getDerecha());
        return Math.max(alturaIzq, alturaDer) + 1;
    }
}