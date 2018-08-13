/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.dto;

import java.io.Serializable;

/**
 *
 * @author Jonathan
 */
public class Derivada implements Serializable{
    private int numero;
    private int opcion;
    private int secuencia;
    private int derivada;

    public Derivada() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public int getDerivada() {
        return derivada;
    }

    public void setDerivada(int derivada) {
        this.derivada = derivada;
    }
    
    
    
    
}
