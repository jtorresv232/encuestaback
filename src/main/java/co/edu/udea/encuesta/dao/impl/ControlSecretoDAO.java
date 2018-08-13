/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.dao.impl;

import co.edu.udea.encuesta.dao.ConnectionPool;
import co.edu.udea.encuesta.dto.ControlSecreto;
import co.edu.udea.encuesta.properties.Properties;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Jonathan
 */
public class ControlSecretoDAO extends ConnectionPool{
    
    public Collection<ControlSecreto> getControles(){
        CallableStatement ps = null;
        ResultSet rs = null;
        Collection<ControlSecreto> listaControles = new LinkedList<>();
        ControlSecreto control;
        
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("control.obtener"));
            rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    control = new ControlSecreto();
                    control.setPunto(rs.getInt("PUNTO"));
                    control.setIdentificacion(rs.getString("IDENTIFICACION"));
                    control.setCedula(rs.getString("CEDULA"));
                    control.setMetadato(rs.getString("METADATO"));
                    control.setFecha(rs.getDate("FECHA"));
                    listaControles.add(control);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return listaControles;
    }
    
    public boolean addControl(ControlSecreto control){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean agregado= false;
        
        try{
        ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("control.agregar"));
        ps.setInt(1, control.getPunto());
        ps.setString(2, control.getIdentificacion());
        ps.setString(3, control.getCedula());
        ps.setString(4, control.getMetadato());
        ps.setDate(5, (Date) control.getFecha());
        agregado = ps.executeUpdate() > 0;
        
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return agregado;
    }
    
    public boolean update(ControlSecreto control){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean actualizado = false;
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("control.actualizar"));
            ps.setInt(1, control.getPunto());
            ps.setString(2, control.getIdentificacion());
            ps.setString(3, control.getCedula());
            ps.setString(4, control.getMetadato());
            ps.setDate(5, (Date) control.getFecha());
            actualizado = ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return actualizado;
    }
}
