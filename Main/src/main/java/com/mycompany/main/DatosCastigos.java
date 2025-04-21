/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author VILLALV
 */
public class DatosCastigos {
    private String Numero;
    private String castigo;
    private int PosicionesMenos;


    public DatosCastigos(String Numero, String castigo, int PosicionesMenos) {
        this.castigo = castigo;
        this.PosicionesMenos = PosicionesMenos;
    }
    
    public String getCastigo() {
        return castigo;
    }

    public void setCastigo(String castigo) {
        this.castigo = castigo;
    }

    public int getPosicionesMenos() {
        return PosicionesMenos;
    }

    public void setPosicionesMenos(int PosicionesMenos) {
        this.PosicionesMenos = PosicionesMenos;
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
        return "Numero" + Numero + "Castigo: " + castigo + ", Posiciones -: " + PosicionesMenos;
    }
}
