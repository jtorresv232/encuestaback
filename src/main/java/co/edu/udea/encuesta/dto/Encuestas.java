/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jonathan
 */
public class Encuestas implements Serializable{
    private int punto;
    private String identificacion;
    private Date fechaInicio;
    private Date fechaTerminacion;
    private String modificable;
    private String sql_personasAplica;
    private String nombreEncuesta;
    private String encabezado;
    private String requiereLogeo;
    private String secreta;
    private String estructuraMetadato;

    public Encuestas() {
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    public String getModificable() {
        return modificable;
    }

    public void setModificable(String modificable) {
        this.modificable = modificable;
    }

    public String getSql_personasAplica() {
        return sql_personasAplica;
    }

    public void setSql_personasAplica(String sql_personasAplica) {
        this.sql_personasAplica = sql_personasAplica;
    }

    public String getNombreEncuesta() {
        return nombreEncuesta;
    }

    public void setNombreEncuesta(String nombreEncuesta) {
        this.nombreEncuesta = nombreEncuesta;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getRequiereLogeo() {
        return requiereLogeo;
    }

    public void setRequiereLogeo(String requiereLogeo) {
        this.requiereLogeo = requiereLogeo;
    }

    public String getSecreta() {
        return secreta;
    }

    public void setSecreta(String secreta) {
        this.secreta = secreta;
    }

    public String getEstructuraMetadato() {
        return estructuraMetadato;
    }

    public void setEstructuraMetadato(String estructuraMetadato) {
        this.estructuraMetadato = estructuraMetadato;
    }
    
    
    
    
}