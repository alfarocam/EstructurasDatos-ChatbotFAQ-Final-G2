/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author VILLALV
 */
public class ListaEnlazada {

    Nodo primero;

    public ListaEnlazada() {

    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    /**
     * Con este Metodo metemos a la lista las posiuciones en las que el jugador
     * jugo
     *
     * @author Ian Villalobos Alvarez
     * @param valor agregamos a la lista las posiciones que jugo el jugador
     * @return No retorna nada
     */
    public void insertaOrdenado(int valor) {
        Nodo nuevo = new Nodo(valor);
        // #1caso: Insertar en una lista  vacia.
        if (this.getPrimero() == null) { // Significa que la lista esta vacia.
            this.setPrimero(nuevo);      // Inicializo el primer elemento con la neva cajita.

        } else if (this.getPrimero().getDato() <= valor) { // #2caso: Insertar antes del primer da la lista.
            nuevo.setSiguiente(primero);
            this.setPrimero(nuevo);

        } else {// #3caso: Insertar en cualquier lugar de la lista.

            Nodo aux = this.getPrimero();

            // Este ciclo me permite buscar la posicion correcta dentro de la lista
            while (aux.getSiguiente() != null
                    && aux.getSiguiente().getDato() < valor) {
                aux = aux.getSiguiente();

            }
            nuevo.setSiguiente(aux.getSiguiente()); // amarro la nueva caja al resto de la lista
            aux.setSiguiente(nuevo);
        }
    }

    /**
     * Con este Metodo eliminamos la lista del jugador
     *
     * @author Ian Villalobos Alvarez
     * @param valor eliminamos a la lista las posiciones que jugo el jugador
     * @return No retorna nada
     */
    public void eliminarNodo(int valor) {
        Nodo actual = primero;  // Creo un auxiliar temporal y lo igualo al primero.
        Nodo anterior = null;   // Inicializo el anterior al primero en null.

        // Recorro la lista hasta encontrar el elemento que quiero eliminar.
        while (actual != null && actual.getDato() != valor) {  // Mientras no hayamos llegado al final y no hayamos encontrado el elemento.
            anterior = actual;
            actual = actual.getSiguiente();
        }

        if (actual == null) {  // Significa que no encontré el elemento a eliminar.
            return;
        }

        if (anterior == null) {  // Significa que voy a eliminar la cabeza.
            this.setPrimero(actual.getSiguiente());
        } else {
            anterior.setSiguiente(actual.getSiguiente());
        }
    }

    /**
     * Con este Metodo clasificamos a los niños por edad a diferentes pilas
     *
     * @author Ian Villalobos Alvarez
     * @param valor busca el valor en la lista
     * @return No retorna nada
     */
    public boolean buscar(int valor) {
        Nodo actual = primero;  // Creo un puntero auxiliar y lo inicializo igual al primero.
        while (actual != null) {  // Mientras actual NO sea null. Tenemos elementos en la lista.
            if (actual.getDato() == valor) {
                return true;  // Significa que encontré el elemento que estoy buscando, por lo tanto retorno TRUE.
            }
            actual = actual.getSiguiente();  // Muevo el puntero auxiliar (actual) al sgte de la lista.
        }
        return false;  // Retorna false porque llegó al final de la lista y nunca encontró el elemento que andaba buscando.
    }

    /**
     * Con este Metodo recorre la lista
     *
     * @author Ian Villalobos Alvarez
     * @return No retorna nada
     */
    public void recorrer() {
        Nodo actual = primero;  // Creo un puntero auxiliar y lo inicializo igual al primero.
        while (actual != null) {  // Mientras actual NO sea null. Tenemos elementos en la lista.
            System.out.print(actual.getDato() + " - ");
            actual = actual.getSiguiente();  // Muevo el puntero auxiliar (actual) al sgte de la lista.
        }
    }

    /**
     * inserta una pregunta hija con su respuesta
     *
     * @param pregunta nombre de la pregunta hija
     * @author CamilaAlfaro
     */
    public void insertaPregunta(String pregunta, String respuesta) {
        Nodo nueva = new Nodo(0, pregunta, respuesta); 
        if (primero == null) {
            primero = nueva;
        } else {
            Nodo actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nueva);
        }
    }
}
