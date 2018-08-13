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
public class RolPregunta implements Serializable{
    private String rolusuario;
    private int tema;

    public RolPregunta() {
    }

    public String getRolusuario() {
        return rolusuario;
    }

    public void setRolusuario(String rolusuario) {
        this.rolusuario = rolusuario;
    }

    public int getTema() {
        return tema;
    }

    public void setTema(int tema) {
        this.tema = tema;
    }
    
    
}
