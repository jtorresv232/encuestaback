/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.dao.impl;

import co.edu.udea.encuesta.dao.ConnectionPool;
import co.edu.udea.encuesta.dto.PuntoAplicacion;
import co.edu.udea.encuesta.properties.Properties;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.LinkedList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Jonathan
 */
public class PuntoDAO extends ConnectionPool{
    
    public Collection<PuntoAplicacion> getPuntos(){
        CallableStatement psGetPuntos = null;
        ResultSet rs = null;
        Collection<PuntoAplicacion> listaPuntos = new LinkedList<>();
        PuntoAplicacion punto;
        
        try{
            psGetPuntos = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("punto.obtener"));
            System.out.println("co.edu.udea.encuesta.dao.impl.PuntoDAO.getPuntos()");
            rs = psGetPuntos.executeQuery();
            
            System.out.println("RS: " + rs);
            if(rs != null){
                System.out.println("no es nulo");
                while(rs.next()){
                    punto = new PuntoAplicacion();
                    punto.setIdPunto(rs.getInt("PUNTO"));
                    punto.setDescripcion(rs.getString("DESCRIPCION"));
                    System.out.println(punto);
                    listaPuntos.add(punto);
                    
                }
            }
        }catch(Exception e){
            System.err.println(e);
        }finally{
            close(psGetPuntos,rs);
        }
        return listaPuntos;
    }
    
    public boolean addPunto(PuntoAplicacion punto){
        PreparedStatement psGetPuntos = null;
        ResultSet rs = null;
        boolean result = false;
        
        try{
            psGetPuntos = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("punto.agregar"));
            psGetPuntos.setInt(1, punto.getIdPunto());
            psGetPuntos.setString(2, punto.getDescripcion());
            result = psGetPuntos.executeUpdate() > 0;
            
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(psGetPuntos,rs);
        }
        
        return result;
        
    }
    
    public boolean actualizar(PuntoAplicacion punto){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean actualizado = false;
        
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("punto.actualizar"));
            ps.setInt(1, punto.getIdPunto());
            ps.setString(2, punto.getDescripcion());
            actualizado = ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e);
        }finally{
            try{
                close(ps,rs);
            }catch(Exception e){
            }
        }
        
        return actualizado;
    }
}
