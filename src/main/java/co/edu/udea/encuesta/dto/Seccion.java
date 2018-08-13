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
public class Seccion implements Serializable{
    private String seccion;
    private String texto;
    private int punto;
    private String identificacion;
    private int preguntaDondeArranca;

    public Seccion() {
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    public int getPreguntaDondeArranca() {
        return preguntaDondeArranca;
    }

    public void setPreguntaDondeArranca(int preguntaDondeArranca) {
        this.preguntaDondeArranca = preguntaDondeArranca;
    }
    
}
