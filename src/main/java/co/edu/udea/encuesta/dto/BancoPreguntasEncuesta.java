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
public class BancoPreguntasEncuesta implements Serializable{
    private int numero;
    private String pregunta;
    private String tipo;
    private String opcion_otro;
    private int tema;
    private String opcion_unica;
    private String tipodato;
    private String temaDesc;

    public BancoPreguntasEncuesta() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOpcion_otro() {
        return opcion_otro;
    }

    public void setOpcion_otro(String opcion_otro) {
        this.opcion_otro = opcion_otro;
    }

    public int getTema() {
        return tema;
    }

    public void setTema(int tema) {
        this.tema = tema;
    }

    public String getOpcion_unica() {
        return opcion_unica;
    }

    public void setOpcion_unica(String opcion_unica) {
        this.opcion_unica = opcion_unica;
    }

    public String getTipodato() {
        return tipodato;
    }

    public void setTipodato(String tipodato) {
        this.tipodato = tipodato;
    }

    public String getTemaDesc() {
        return temaDesc;
    }

    public void setTemaDesc(String temaDesc) {
        this.temaDesc = temaDesc;
    }
    
    
    
    
}
