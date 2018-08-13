/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.dao.impl;

import co.edu.udea.encuesta.dao.ConnectionPool;
import co.edu.udea.encuesta.dto.RolPunto;
import co.edu.udea.encuesta.properties.Properties;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Jonathan
 */
public class RolPuntoDAO extends ConnectionPool{
    
    public Collection<RolPunto> getRolesPuntos(){
        CallableStatement ps = null;
        ResultSet rs = null;
        Collection<RolPunto> listaRoles = new LinkedList<>();
        RolPunto rol;
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("rolpunto.obtener"));
            rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    rol = new RolPunto();
                    rol.setPunto(rs.getInt("PUNTO"));
                    rol.setRolusuario(rs.getString("ROLUSUARIO"));
                    listaRoles.add(rol);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return listaRoles;
    }
    
    public boolean addRolPunto(RolPunto rol){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean agregado = false;
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("rolpunto.agregar"));
            ps.setInt(1, rol.getPunto());
            ps.setString(2, rol.getRolusuario());
            agregado = ps.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return agregado;
    }
    
    public boolean updateRolPunto(RolPunto rol){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean actualizado = false;
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("rolpunto.actualizar"));
            ps.setInt(1, rol.getPunto());
            ps.setString(2, rol.getRolusuario());
            actualizado = ps.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return actualizado;
    }
    
}
