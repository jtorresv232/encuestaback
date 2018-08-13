/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.dao.impl;

import co.edu.udea.encuesta.dao.ConnectionPool;
import co.edu.udea.encuesta.dto.RelacionSecreta;
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
public class RelacionSecretaDAO extends ConnectionPool{
    
    public Collection<RelacionSecreta> getRelaciones(){
        CallableStatement ps = null;
        ResultSet rs = null;
        Collection<RelacionSecreta> listaRelaciones = new LinkedList<>();
        RelacionSecreta relacion;
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("relacion.obtener"));
            rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    relacion = new RelacionSecreta();
                    relacion.setPunto(rs.getInt("PUNTO"));
                    relacion.setIdentificacion(rs.getString("IDENTIFICACION"));
                    relacion.setIdentificador(rs.getString("IDENTIFICADOR"));
                    relacion.setMetadato(rs.getString("METADATO"));
                    listaRelaciones.add(relacion);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return listaRelaciones;
    }
    
    public boolean addRelacion(RelacionSecreta relacion){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean agregado = false;
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("relacion.agregar"));
            ps.setInt(1, relacion.getPunto());
            ps.setString(2, relacion.getIdentificacion());
            ps.setString(3, relacion.getIdentificador());
            ps.setString(4, relacion.getMetadato());
            agregado = ps.executeUpdate() > 0;
            
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return agregado;
    }
    
    public boolean updateRelacion(RelacionSecreta relacion){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean actualizado = false;
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("relacion.actualizar"));
            ps.setInt(1, relacion.getPunto());
            ps.setString(2, relacion.getIdentificacion());
            ps.setString(3, relacion.getIdentificador());
            ps.setString(4, relacion.getMetadato());
            actualizado = ps.executeUpdate() > 0;
            
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return actualizado;
    }
    
}
