/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Chatbot con funcionalidad de mantenimiento para preguntas padres e hijas.
 * Incluye métodos para insertar/modificar nodos padres y hijas con código
 * dinámico basado en la jerarquía de códigos.
 *
 * @author VILLALV
 * @author CamilaAlfaro
 * @author Kevin Guifarro
 */
public class Chatbot extends Arbolchatbot {

    public void ChatBotPreguntas() {

        insertar(new Nodo(1, "Preguntas Frecuentes ", "FAQ"));
        insertar(new Nodo(0, "", ""));
        insertar(new Nodo(2, "", ""));
        insertar(new Nodo(3, "", ""));
        insertar(new Nodo(4, "", ""));
        insertar(new Nodo(5, "", ""));
        insertar(new Nodo(6, "", ""));
        insertar(new Nodo(7, "", ""));
        insertar(new Nodo(8, "Agregar jugadores", "Usa la opcion 1 antes de jugar o 3 durante la partida"));
        insertar(new Nodo(9, "Cambiar configuracion", "Usa 'Opciones del juego' (opcion 2)"));
        insertar(new Nodo(10, "Como ganar", "Llega primero a la posicion final del laberinto"));
        insertar(new Nodo(11, "Como jugar", "Selecciona 'Jugar' (opcion 5) en el menu principal"));
        insertar(new Nodo(12, "Que hacen los premios", "Avanzas posiciones si sacas par en los datos"));
        insertar(new Nodo(13, "Los dados de cuantas careas son?", "Objetivo: Encuentra la llave"));
        insertar(new Nodo(14, "Se pueden tirar mas de dos beses los dados?", "Objetivo: Llega al castillo"));
    }

    /**
     * inserta-modifica una pregunta hija en un nodo hoja
     *
     * @param codigoPadre codigo del nodo hoja
     * @param nombrePregunta nombre de la pregunta hija
     * @author CamilaAlfaro
     */
    public void insertarOModificarHija(int codigoPadre, String nombrePregunta, String respuesta) {
        NodoArbol nodo = buscarNodoPorOrden(this.getRaiz(), codigoPadre);
        if (nodo == null) {
            System.out.println("Nodo no encontrado");
            return;
        }
        //si tiene hijos no se puede
        if (nodo.getIzquierda() != null || nodo.getDerecha() != null) {
            System.out.println("No se puede agregar una pregunta hija a un nodo que no es hoja");
            return;
        }
        //se crea la lista si no exiaste
        if (nodo.getPreguntasHijas() == null) {
            nodo.setPreguntasHijas(new ListaEnlazada());
        }
        nodo.getPreguntasHijas().insertaPregunta(nombrePregunta, respuesta);
        System.out.println("Pregunta hija agregada o modificada");
    }

    /**
     * Inserta o modifica un nodo padre (pregunta padre) con código dinámico
     * basado en el algoritmo de jerarquía. Si el padre no existe, lo crea como
     * placeholder vacío antes de añadir al nuevo hijo.
     *
     * @param codigoPadre código del nodo padre bajo el cual se inserta el nuevo
     * nodo
     * @param nombrePregunta texto de la pregunta padre
     * @param descripcion descripción asociada al nodo padre
     * @author Kevin Guifarro
     */
    public void insertarOModificarPadre(int codigoPadre, String nombrePregunta, String descripcion) {
        // Buscar o crear placeholder del padre
        NodoArbol padre = buscarNodoPorOrden(getRaiz(), codigoPadre);
        if (padre == null) {
            insertar(new Nodo(codigoPadre, "", ""));
            padre = buscarNodoPorOrden(getRaiz(), codigoPadre);
        }
        // Calcular el nuevo código según los hijos directos existentes
        String padreStr = String.valueOf(padre.getDato().getOrden());
        List<Integer> sufijos = new ArrayList<>();
        collectChildSuffixes(getRaiz(), padreStr, sufijos);
        int max = 0;
        for (int s : sufijos) {
            if (s > max) {
                max = s;
            }
        }
        int nuevoSufijo = max + 1;
        String nuevoCodigoStr = padreStr + nuevoSufijo;
        int nuevoCodigo = Integer.parseInt(nuevoCodigoStr);
        // Insertar el nuevo nodo padre con sus datos definitivos
        insertar(new Nodo(nuevoCodigo, nombrePregunta, descripcion));
        System.out.println("Pregunta padre agregada o modificada con código " + nuevoCodigo);
    }

    /**
     * Recorre el árbol y colecta los sufijos numéricos de los hijos directos de
     * un padre.
     *
     * @param actual nodo actual en la recursión
     * @param padreStr representación de cadena del código del padre
     * @param sufijos lista donde se añaden los sufijos encontrados
     * @author Kevin Guifarro
     */
    private void collectChildSuffixes(NodoArbol actual, String padreStr, List<Integer> sufijos) {
        if (actual == null) {
            return;
        }
        String codigoStr = String.valueOf(actual.getDato().getOrden());
        if (codigoStr.startsWith(padreStr) && codigoStr.length() == padreStr.length() + 1) {
            String suf = codigoStr.substring(padreStr.length());
            try {
                sufijos.add(Integer.parseInt(suf));
            } catch (NumberFormatException e) {
            }
        }
        collectChildSuffixes(actual.getIzquierda(), padreStr, sufijos);
        collectChildSuffixes(actual.getDerecha(), padreStr, sufijos);
    }

    /**
     * Print todas las preguntas hijas de un nodo hoja
     *
     * @param codigo codigo del nodo a consultar
     * @author CamilaAlfaro
     */
    public void imprimirPreguntasHijas(int codigoPadre) {
        NodoArbol nodo = buscarNodoPorOrden(getRaiz(), codigoPadre);
        if (nodo == null) {
            System.out.println("Nodo no encontrado");
            return;
        }
        if (nodo.getPreguntasHijas() == null || nodo.getPreguntasHijas().getPrimero() == null) {
            System.out.println("Este nodo no tiene preguntas hijas");
            return;
        }
        Nodo actual = nodo.getPreguntasHijas().getPrimero();
        while (actual != null) {
            System.out.println("Pregunta: " + actual.getNombrePregunta());
            System.out.println("Respuesta: " + actual.getDescripcion());
            actual = actual.getSiguiente();
        }
    }

    /**
     * Busca un nodo por su codigo es decr orden
     *
     * @param actual nodo actual del arbol
     * @param codigo codigo a buscar
     * @return NodoArbol encontrado o null
     * @author CamilaAlfaro
     */
    private NodoArbol buscarNodoPorOrden(NodoArbol actual, int codigo) {
        if (actual == null) {
            return null;
        }
        if (actual.getDato().getOrden() == codigo) {
            return actual;
        }
        NodoArbol izq = buscarNodoPorOrden(actual.getIzquierda(), codigo);
        return (izq != null) ? izq : buscarNodoPorOrden(actual.getDerecha(), codigo);
    }

}
