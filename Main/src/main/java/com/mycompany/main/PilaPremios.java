/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 * @author Ian
 * @author CamilaAlfaro 3/2/2025
 */

public class PilaPremios {
   
    NodoPremiosCastigos top; 

    public NodoPremiosCastigos getTop() {
        return top;
    }

    public void setTop(NodoPremiosCastigos top) {
        this.top = top;
    }
    
    public void pila(){
        top = null;
 
    }

    /**
   * Con este Metodo apilamos los castigos
   * @author Ian Villalobos Alvarez                   
   * @param Numero nuemro de premio 
   * @param castigo que tipo de premio
   * @param PosicionesMenos cantida de posiciones mas
   * @return No retorna nada
   */
    public void apilar(String Numero, String premio, int PosicionesMas) {

    DatosPremios miDato = new DatosPremios(Numero, premio, PosicionesMas);
    NodoPremiosCastigos miNodo = new NodoPremiosCastigos(miDato);
    
    if (esVacia()) {
        top = miNodo; 
    } else {                   
        miNodo.setAbajo(top); 
        top = miNodo; 
    }
}
    /**
   * Con este Metodo sacamos los premios
   * @author Ian Villalobos Alvarez                   
   * @return el premios sacado
   */
    public DatosPremios despilar(){
        if (esVacia()){
            System.out.println("Error: la pila está vacía, no se puede desapilar.");
            return null;
        } else {
            DatosPremios valorTemp = top.getMiDatoPremio();
            top = top.getAbajo();
            return valorTemp;
        }
    }

    /**
   * Con este Metodo indica si esta vacia
   * @author Ian Villalobos Alvarez                   
   * @return No retorna nada
   */
    public boolean esVacia(){
        if (top == null)
            return true; 
        else
            return false;
        }
    /**
   * Con este Metodo imprime la pila 
   * @author Ian Villalobos Alvarez                   
   * @return No retorna nada
   */
    public void imprimirPila(){
        if (esVacia()){
        System.out.println("La pila esta vacia");
        
        }
        else{
        NodoPremiosCastigos actual = top; 
        while (actual != null){
            System.out.println("####Premios Restantres####");
            System.out.println("Premio: " + actual.getMiDatoPremio().getPremio());
            System.out.println("Ganas +"+ actual.getMiDatoPremio().getPosicionesMas());

            actual = actual.getAbajo();
            
        }
        
        }
    }
    public String sacarPremio() {
        if (top == null) {
            return "No hay mas premios disponibles."; 
        }
        String premio = top.getMiDatoPremio().getPremio();  
        top = top.getAbajo();      
        return premio;
    }
  
}