/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author VILLALV
 */
public class DatosPremios {
    
    private String Numero;
    private String Premio;
    private int PosicionesMas;

    // Constructor
    public DatosPremios(String Numero, String Premio, int PosicionesMas) {
        this.Premio = Premio;
        this.PosicionesMas = PosicionesMas;
    }

    public String getPremio() {
        return Premio;
    }

    public void setPremio(String Premio) {
        this.Premio = Premio;
    }

    public int getPosicionesMas() {
        return PosicionesMas;
    }

    public void setPosicionesMas(int PosicionesMas) {
        this.PosicionesMas = PosicionesMas;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    // Método toString corregido
    @Override
    public String toString() {
        return "Numero" + Numero + ", Premio: " + Premio +", Posiciones +: " + PosicionesMas;
    }
}