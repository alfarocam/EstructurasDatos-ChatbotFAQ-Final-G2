/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author VILLALV
 */
public class NodoPremiosCastigos {
    private DatosPremios miDatoPremio;
    private DatosCastigos miDatoCastigo;
    private DatosJugadores miDatoJugadores;
    private NodoPremiosCastigos abajo;


    public NodoPremiosCastigos(DatosCastigos miDatoC) {
        this.miDatoCastigo = miDatoC;
        this.miDatoPremio = null;
        this.miDatoJugadores = null;
        this.abajo = null; 
    }

    public NodoPremiosCastigos(DatosPremios miDatoP) {
        this.miDatoPremio = miDatoP;
        this.miDatoCastigo = null;
        this.miDatoJugadores = null;
        this.abajo = null; 
    }


    public NodoPremiosCastigos(DatosJugadores miDatoJugadores) {
        this.miDatoJugadores = miDatoJugadores;
        this.miDatoCastigo = null;
        this.miDatoPremio = null;
        this.abajo = null; 
    }
    

    public DatosPremios getMiDatoPremio() {
        return miDatoPremio;
    }

    public void setMiDatoPremio(DatosPremios miDatoPremio) {
        this.miDatoPremio = miDatoPremio;
    }

    public DatosCastigos getMiDatoCastigo() {
        return miDatoCastigo;
    }

    public void setMiDatoCastigo(DatosCastigos miDatoCastigo) {
        this.miDatoCastigo = miDatoCastigo;
    }

    public DatosJugadores getMiDatoJugadores() {
        return miDatoJugadores;
    }

    public void setMiDatoJugadores(DatosJugadores miDatoJugadores) {
        this.miDatoJugadores = miDatoJugadores;
    }

    public NodoPremiosCastigos getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoPremiosCastigos abajo) {
        this.abajo = abajo;
    }

    private static class DatosJugadores {

        public DatosJugadores() {
        }
    }
}