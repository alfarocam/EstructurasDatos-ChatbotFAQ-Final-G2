/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author VILLALV
 */
public class Cola {
    NodoCola frente;   
    private NodoCola ultimo;    

    public Cola() {
        frente = null;  
        ultimo = null;  
    }

    public NodoCola getFrente() {
        return frente;
    }

    public NodoCola getUltimo() {
        return ultimo;
    }

    public void setFrente(NodoCola frente) {
        this.frente = frente;
    }

    public void setUltimo(NodoCola ultimo) {
        this.ultimo = ultimo;
    }
    
    /**
   * Con este Metodo metemos a la cola a los jugadores que vayan a jugar.
   * @author Ian Villalobos Alvarez                   
   * @param NombreJugador Se agrega a la cola el jugador que se alla agregado
   * @param PosicionActual Se agrega la posicion del jugador agregado 
   * @return No retorna nada
   */
    public void encolar (String NombreJugador, int PosicionActual){

        DatosJugadores miDato = new DatosJugadores(NombreJugador, PosicionActual);
        NodoCola aux = new NodoCola(miDato);

        if (this.ultimo != null){  

            this.ultimo.setSiguiente(aux);  
        }
        else{    

            this.frente = aux;
        }
 
        this.ultimo = aux;    
    }
    
    /**
   * Con este Metodo sacamos de la lista al jugador que ya no quiera jugar.
   * @author Ian Villalobos Alvarez                   
   * @param nombre Seleccionamos al jhugadore que va a salir.
   * @return null si la cola esta vacia o si no encontro al jugador, aux si encontro a la persona 
   */
    public NodoCola desencolar(String nombre) {
        if (this.frente == null) {
            return null; // La cola está vacía, no hay nada que desencolar.
        }

        NodoCola aux = null;

        // Si el jugador a eliminar está en el frente
        if (this.frente.getDato().getNombreJugador().equals(nombre)) {
            aux = this.frente; // Guardamos el nodo encontrado.
            this.frente = this.frente.getSiguiente(); // Movemos el frente al siguiente nodo.

            // Si la cola queda vacía, ajustamos `ultimo`.
            if (this.frente == null) {
                this.ultimo = null;
            }
            return aux; // Retornamos el nodo eliminado.
        }

        // Buscar en el resto de la cola
        NodoCola actual = this.frente;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getDato().getNombreJugador().equals(nombre)) {
                aux = actual.getSiguiente(); // Guardamos el nodo encontrado.
                actual.setSiguiente(actual.getSiguiente().getSiguiente()); // Eliminamos el nodo.

                // Si eliminamos el último nodo, actualizamos `ultimo`
                if (actual.getSiguiente() == null) {
                    this.ultimo = actual;
                }
                return aux;
            }
            actual = actual.getSiguiente(); // Avanzamos en la cola.
        }

        return null; // Si no se encontró el jugador, retorna `null`.
    }

        public NodoCola frente(){
            return this.frente;
        }
        /**
       * Con este Metodo vemos si la cola esta vacia o llena
       * @author CHAVES BARBOZA JOSE ALFREDO                   
       * @return Retorna false si la cola esta llena o true si la cola esta vacía
       */    
        public boolean estaVacia(){
            if (this.frente == null)
               return true;
            else
               return false;
        }   
        
     /**
     * Con este Metodo pasamos el jugador que estaba al frente al final
     * @author Ian Villalobos Alvarez                   
     * @return No retorna nada
     */
    public void moverJugadorAlFinal() {
    if (!estaVacia()) {
        NodoCola jugador = desencolar(frente.getDato().getNombreJugador()); // Desencolamos al jugador del frente
        encolar(jugador.getDato().getNombreJugador(), jugador.getDato().getPosicionActual()); // Lo volvemos a encolar al final
    }

        
    }
     
    /**
   * Con este Metodo sacamos de la lista al jugador que ya no quiera jugar.
   * @author Ian Villalobos Alvarez                   
   * @param nombre Seleccionamos al jhugadore que va a salir.
   * @return null si la cola esta vacia o si no encontro al jugador, aux si encontro a la persona 
   */
        public void mostrarPosiciones(){
         NodoCola actual = this.frente; // Comienza en el frente de la cola
    int posicion = 1; // Contador de posiciones en la cola (puede ser cualquier valor, 1, 2, 3... según la estructura)
    
    // Recorremos la cola hasta que lleguemos al final
    while (actual != null) {
        // Imprimimos el nombre y la posición del jugador
        System.out.println("Jugador " + posicion + ": " + actual.getDato().getNombreJugador() + " - Posición: " + actual.getDato().getPosicionActual());
        
        // Avanzamos al siguiente nodo
        actual = actual.getSiguiente();
        posicion++; // Incrementamos la posición
    }
    }
        
        
    /**
   * Con este Metodo buscamos jugadores en la cola
   * @author Ian Villalobos Alvarez                   
   * @param nombre persona a la que se desea buscar
   * @return null si la cola esta vacia o si no encontro al jugador, aux si encontro a la persona 
   */    
    public NodoCola buscarJugador(String nombre) {
    NodoCola actual = this.frente; // Comenzamos desde el frente de la cola

    while (actual != null) {
        if (actual.getDato().getNombreJugador().equalsIgnoreCase(nombre)) {
            return actual; // Si el nombre coincide, devolvemos el nodo encontrado
        }
        actual = actual.getSiguiente(); // Avanzamos al siguiente nodo
    }

    return null; // Si no se encontró el jugador, retornamos null
}
}

    

