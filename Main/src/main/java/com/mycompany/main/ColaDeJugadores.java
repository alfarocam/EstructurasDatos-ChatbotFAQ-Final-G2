/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author josep
 * @author Kevin G. 3/1/2025
 * @author CamilaAlfaro 3/2/2025
 */
public class ColaDeJugadores extends Cola{

    public ColaDeJugadores(){

    }
    /**
   * En este Metodo contamos a los jugadores que se encuentran en  la cola 
   * @author Ian Villalobos Alvarez                    
   * @return Retorna contador que es la cantidad de jugadores
   */    
    public int cuentaParticipantes(){
        int contador = 0;

      NodoCola actual = frente;
      while (actual != null) {
        contador++; 
        actual = actual.getSiguiente();  
    }
    return contador;
      
    }
    public static double convertirAPorcentaje(int numero, int TamañoLaberinto) {
        
        if (numero >= 0 && numero <= TamañoLaberinto) {
            
            double porcentaje = ((double) numero / TamañoLaberinto) * 100;
            return porcentaje; 
        } else {
                 int resta =  numero - TamañoLaberinto; 
                    double porcentaje = ((double)(numero - 1) / (TamañoLaberinto - 1)) * 100;
                    return porcentaje;
            }
        }    
    /**
   * En este Metodo imprimimos los datos de los niños inscritos 
   * @author Ian Villalobos Alvarez                    
   * @return No retorna nada
   */
    public void ImprimirParticipantes(String nombre, int tamañodelLaberinto) {
        NodoCola actual = frente;  
    if (actual == null) {  
        System.out.println("La cola está vacía.");
    } 
    else {
        while (actual != null) {
           
            System.out.println("#### Participante ####");
            System.out.println("Nombre Completo: " + actual.getDato().getNombreJugador());
            System.out.println("Posicion: " + actual.getDato().getPosicionActual());
            double PorsentajeJ = (double) convertirAPorcentaje(actual.getDato().getPosicionActual(),tamañodelLaberinto);
            if (PorsentajeJ <= 40){
                System.out.println("Porcentaje: verde " + convertirAPorcentaje(actual.getDato().getPosicionActual(),tamañodelLaberinto) + "%");
                System.out.println("de:" + tamañodelLaberinto);
                System.out.println("---------------------");
            }
            if (PorsentajeJ >= 41 && PorsentajeJ <= 80){
                System.out.println("Porcentaje: amarillo " + convertirAPorcentaje(actual.getDato().getPosicionActual(),tamañodelLaberinto) + "%");
                System.out.println("de:" + tamañodelLaberinto);
                System.out.println("---------------------");
            }
            if (PorsentajeJ >= 81 && PorsentajeJ <= 100){
                System.out.println("Porcentaje: rojo " + convertirAPorcentaje(actual.getDato().getPosicionActual(),tamañodelLaberinto) + "%");
                System.out.println("de:" + tamañodelLaberinto);
                System.out.println("---------------------");
            }
            actual = actual.getSiguiente();
            }
        }
    }

}
