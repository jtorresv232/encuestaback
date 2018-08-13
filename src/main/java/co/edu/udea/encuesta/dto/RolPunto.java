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
public class RolPunto implements Serializable{
    private int punto;
    private String rolusuario;

    public RolPunto() {
    }

    public int getPunto() {
        return punto;
    }

    public void setPunto(int punto) {
        this.punto = punto;
    }

    public String getRolusuario() {
        return rolusuario;
    }

    public void setRolusuario(String rolusuario) {
        this.rolusuario = rolusuario;
    }
    
    
}
