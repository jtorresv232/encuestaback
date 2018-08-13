/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.dao.impl;

import co.edu.udea.encuesta.dao.ConnectionPool;
import co.edu.udea.encuesta.dto.PreguntaPorEncuesta;
import co.edu.udea.encuesta.properties.Properties;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Jonathan
 */
public class PreguntaPorEncuestaDAO extends ConnectionPool{
    
    public Collection<PreguntaPorEncuesta> getPreguntas(){
        CallableStatement ps = null;
        ResultSet rs = null;
        Collection<PreguntaPorEncuesta> listaPreguntas = new LinkedList<>();        
        PreguntaPorEncuesta pregunta;
        
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("preguntaXEncuesta.obtener"));
            rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    pregunta = new PreguntaPorEncuesta();
                    pregunta.setPunto(rs.getInt("PUNTO"));
                    pregunta.setIdentificacion(rs.getString("IDENTIFICACION"));
                    pregunta.setNumero(rs.getInt("NUMERO"));
                    pregunta.setOrden(rs.getInt("ORDEN"));
                    pregunta.setObligatoriedad(rs.getString("OBLIGATORIEDAD"));
                    listaPreguntas.add(pregunta);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return listaPreguntas;
    }
    
    public boolean addPregunta(PreguntaPorEncuesta pregunta){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean agregado = false;
        
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("preguntaXEncuesta.agregar"));
            ps.setInt(1, pregunta.getPunto());
            ps.setString(2, pregunta.getIdentificacion());
            ps.setInt(3, pregunta.getNumero());
            ps.setInt(4,pregunta.getOrden());
            ps.setString(5, pregunta.getObligatoriedad());
            
            agregado = ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
            return agregado;
    }    
    
    public boolean updatePregunta(PreguntaPorEncuesta pregunta){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean actualizado = false;
        
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("preguntaXEncuesta.actualizar"));
            ps.setInt(1, pregunta.getPunto());
            ps.setString(2, pregunta.getIdentificacion());
            ps.setInt(3, pregunta.getNumero());
            ps.setInt(4,pregunta.getOrden());
            ps.setString(5, pregunta.getObligatoriedad());
            
            actualizado = ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
            return actualizado;
    }
}
