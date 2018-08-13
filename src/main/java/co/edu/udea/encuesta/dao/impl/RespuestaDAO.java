/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.dao.impl;

import co.edu.udea.encuesta.dao.ConnectionPool;
import co.edu.udea.encuesta.dto.Respuesta;
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
public class RespuestaDAO extends ConnectionPool{
    
    public Collection<Respuesta> getRespuestas(){
        CallableStatement ps = null;
        ResultSet rs = null;
        Collection<Respuesta> listaRespuestas = new LinkedList<>();
        Respuesta respuesta;
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("respuesta.obtener"));
            rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    respuesta = new Respuesta();
                    respuesta.setPunto(rs.getInt("PUNTO"));
                    respuesta.setIdentificacion(rs.getString("IDENTIFICACION"));
                    respuesta.setNumero(rs.getInt("NUMERO"));
                    respuesta.setCedula(rs.getString("CEDULA"));
                    respuesta.setRespuestaOpcion(rs.getInt("RESPUESTAOPCION"));
                    respuesta.setRespuestaAbierta(rs.getString("RESPUESTAABIERTA"));
                    respuesta.setCual(rs.getString("CUAL"));
                    listaRespuestas.add(respuesta);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return listaRespuestas;
    }
    
    public boolean addRespuesta(Respuesta respuesta){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean agregado = false;
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("respuesta.agregar"));
            ps.setInt(1, respuesta.getPunto());
            ps.setString(2, respuesta.getIdentificacion());
            ps.setInt(3, respuesta.getNumero());
            ps.setString(4, respuesta.getCedula());
            ps.setInt(5, respuesta.getRespuestaOpcion());
            ps.setString(6, respuesta.getRespuestaAbierta());
            ps.setString(7, respuesta.getCual());
            
            agregado = ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return agregado;
    }
    
    public boolean updateRespuesta(Respuesta respuesta){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean actualizado = false;
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("respuesta.actualizar"));
            ps.setInt(1, respuesta.getPunto());
            ps.setString(2, respuesta.getIdentificacion());
            ps.setInt(3, respuesta.getNumero());
            ps.setString(4, respuesta.getCedula());
            ps.setInt(5, respuesta.getRespuestaOpcion());
            ps.setString(6, respuesta.getRespuestaAbierta());
            ps.setString(7, respuesta.getCual());
            
            actualizado = ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return actualizado;
    }
    
}