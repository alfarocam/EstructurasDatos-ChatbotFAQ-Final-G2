/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 * @author Ian
 * @author CamilaAlfaro 2/26/2025
 */
public class PilaCastigos{
   
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
   * @param Numero nuemro de castigo 
   * @param castigo que tipo de castigo
   * @param PosicionesMenos cantida de posiciones restadas
   * @return No retorna nada
   */
    public void apilar(String Numero, String castigo, int PosicionesMenos) {

    DatosCastigos miDato = new DatosCastigos(Numero, castigo, PosicionesMenos);
    NodoPremiosCastigos miNodo = new NodoPremiosCastigos(miDato);
    
    if (esVacia()) {
        top = miNodo; 
    } else {                   
        miNodo.setAbajo(top); 
        top = miNodo; 
    }
}
    /**
   * Con este Metodo sacamos los castigos
   * @author Ian Villalobos Alvarez                   
   * @return el castigo sacado
   */
    public DatosCastigos despilar(){
        if (esVacia()){
            System.out.println("Error: la pila está vacía, no se puede desapilar.");
            return null;
        } else {
            DatosCastigos valorTemp = top.getMiDatoCastigo();
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
            System.out.println("####Castigos Restantres####");
            System.out.println("Castigo: " + actual.getMiDatoCastigo().getCastigo());
            System.out.println("Pierdes -"+ actual.getMiDatoCastigo().getPosicionesMenos());

            actual = actual.getAbajo();
            
        }
        
        }
    }
    
        public String sacarCastigo() {
        if (top == null) {
            return "No hay mas premios disponibles."; 
        }
        String Castigo = top.getMiDatoCastigo().getCastigo();
        top = top.getAbajo();      
        return Castigo;
    }
  
}
