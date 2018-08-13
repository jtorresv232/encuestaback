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
public class Respuesta implements Serializable{
    private int punto;
    private String identificacion;
    private int numero;
    private String cedula;
    private int respuestaOpcion;
    private String respuestaAbierta;
    private String cual;

    public Respuesta() {
    }

    public int getPunto() {
        return punto;
    }

    public void setPunto(int punto) {
        this.punto = punto;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getRespuestaOpcion() {
        return respuestaOpcion;
    }

    public void setRespuestaOpcion(int respuestaOpcion) {
        this.respuestaOpcion = respuestaOpcion;
    }

    public String getRespuestaAbierta() {
        return respuestaAbierta;
    }

    public void setRespuestaAbierta(String respuestaAbierta) {
        this.respuestaAbierta = respuestaAbierta;
    }

    public String getCual() {
        return cual;
    }

    public void setCual(String cual) {
        this.cual = cual;
    }
    
    
}
