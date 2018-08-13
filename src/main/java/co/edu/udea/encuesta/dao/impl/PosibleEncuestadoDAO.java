/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.dao.impl;

import co.edu.udea.encuesta.dao.ConnectionPool;
import co.edu.udea.encuesta.dto.PosibleEncuestado;
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
public class PosibleEncuestadoDAO extends ConnectionPool{
    
    public Collection<PosibleEncuestado> getPosiblesEncuestados(){
        CallableStatement ps = null;
        ResultSet rs = null;
        Collection<PosibleEncuestado> listaPosibles = new LinkedList<>();
        PosibleEncuestado posible;
        
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("posible.obtener"));
            rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    posible = new PosibleEncuestado();
                    posible.setPunto(rs.getInt("PUNTO"));
                    posible.setIdentificacion(rs.getString("IDENTIFICACION"));
                    posible.setCedula(rs.getString("CEDULA"));
                    listaPosibles.add(posible);
                }
            }            
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return listaPosibles;
    }
    
    public boolean addPosible(PosibleEncuestado posible){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean agregado = false;
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("posible.agregar"));
            ps.setInt(1, posible.getPunto());
            ps.setString(2, posible.getIdentificacion());
            ps.setString(3, posible.getCedula());
            
            agregado = ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return agregado;
    }
    
    public boolean updatePosible(PosibleEncuestado posible){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean actualizado = false;
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("posible.actualizar"));
            ps.setInt(1, posible.getPunto());
            ps.setString(2, posible.getIdentificacion());
            ps.setString(3, posible.getCedula());
            
            actualizado = ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return actualizado;
    }
    
}
