/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author VILLALV
 */
public class BITACORA_HISTORICA {
    
   private NodoCola frente;
   private NodoCola ultimo;

    public BITACORA_HISTORICA() {
    }

    public BITACORA_HISTORICA(NodoCola cabeza, NodoCola ultimo) {
        this.frente = cabeza;
        this.ultimo = ultimo;
    }

    public void setCabeza(NodoCola cabeza) {
        this.frente = cabeza;
    }

    public void setUltimo(NodoCola ultimo) {
        this.ultimo = ultimo;
    }

    public NodoCola getCabeza() {
        return frente;
    }

    public NodoCola getUltimo() {
        return ultimo;
    }
    /**
   * Con este Metodo agregamos el nombre y las posiciones en la que a estado el jugador
   * @author Ian Villalobos Alvarez                   
   * @param nombre agregamos el nombre del jugador 
   * @param Lista agregamos la lista de posiciones transcuridas dentro del juego
   * @return No retorna nada
   */
    public void insertar (String nombre, ListaEnlazada Lista){

        DatosJugadores miDato = new DatosJugadores(nombre, Lista);
        NodoCola temp = new NodoCola(miDato);
        if (frente == null ){       
            frente = temp;                
            ultimo = frente;             
            ultimo.setSiguiente(frente);  
            frente.setAnterior(ultimo);    
        }
        else if (temp.getDato().getNombreJugador().compareTo(frente.getDato().getNombreJugador()) < 0){  
           
            temp.setSiguiente(frente);        
            frente.setAnterior(temp);
            frente = temp; 
            frente.setAnterior(ultimo);    
            ultimo.setSiguiente(frente); 
        }
        else if (temp.getDato().getNombreJugador().compareTo(ultimo.getDato().getNombreJugador()) >= 0){
         
            ultimo.setSiguiente(temp);    
            temp.setAnterior(ultimo);      
            ultimo = temp;               
            ultimo.setSiguiente(frente);
            frente.setAnterior(ultimo);
        }else {     
            NodoCola aux = frente;      
            while (aux.getSiguiente().getDato().getNombreJugador().compareTo(temp.getDato().getNombreJugador()) < 0){ 
                aux = aux.getSiguiente();
            }  
            temp.setSiguiente(aux.getSiguiente()); 
            temp.setAnterior(aux);                   
        
            aux.setSiguiente(temp);             
            temp.getSiguiente().setAnterior(temp);    
        }
    }
    /**
   * Con este Metodo sacamos el historial del jugador que se fue del juego
   * @author Ian Villalobos Alvarez                   
   * @param nombre Agregamos el nombre del jugador a eliminar.
   * @return No retorna nada
   */
    public NodoCola desencolar(String nombre) {
        if (this.frente == null) {
            return null; // La lista está vacía.
        }

        NodoCola actual = this.frente;
        NodoCola aux = null;

        // Recorremos la lista circular
        while (actual != null) {

            if (actual.getDato().getNombreJugador().equals(nombre)) {
                aux = actual;


                if (actual == this.frente && actual == this.ultimo) {
                    this.frente = null;
                    this.ultimo = null;
                }
                else if (actual == this.frente) {
                    this.frente = this.frente.getSiguiente();
                    this.frente.setAnterior(this.ultimo);
                    this.ultimo.setSiguiente(this.frente);
                }

                else if (actual == this.ultimo) {
                    this.ultimo = this.ultimo.getAnterior();
                    this.ultimo.setSiguiente(this.frente);
                    this.frente.setAnterior(this.ultimo);
                }
                else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }

                return aux; 
            }

            actual = actual.getSiguiente();

           
            if (actual == this.frente) {
                break;
            }
        }

        return null; // Si no se encontró el nodo con el nombre especificado
    }
    /**
   * Con este Metodo imprimimos todos los jugadores como su historial de juego respectivo
   * @author Ian Villalobos Alvarez                   
   * @return No retorna nada
   */
    public void imprimir() {
        if (this.frente == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        NodoCola actual = this.frente;
        NodoCola fin = this.ultimo;

        while (actual != null) {
            System.out.println("Nombre: " + actual.getDato().getNombreJugador());
            System.out.println("Posiciones:");
            actual.getDato().getPosicion().recorrer();  // Llamar a recorrer para imprimir

            // Si llegamos al final, rompemos el bucle
            if (actual == fin) {
                break;
            }

            // Avanzamos al siguiente nodo
            actual = actual.getSiguiente();
        }
    }

}