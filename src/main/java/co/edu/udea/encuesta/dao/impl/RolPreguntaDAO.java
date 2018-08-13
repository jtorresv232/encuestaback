/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.dao.impl;

import co.edu.udea.encuesta.dao.ConnectionPool;
import co.edu.udea.encuesta.dto.RolPregunta;
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
public class RolPreguntaDAO extends ConnectionPool{
    
    public Collection<RolPregunta> getRolesPreguntas(){
        CallableStatement ps = null;
        ResultSet rs = null;
        Collection<RolPregunta> listaRoles = new LinkedList<>();
        RolPregunta rol;
        
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("rolpregunta.obtener"));
            rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    rol = new RolPregunta();
                    rol.setRolusuario(rs.getString("ROLUSUARIO"));
                    rol.setTema(rs.getInt("TEMA"));
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
    
    public boolean addRolPregunta(RolPregunta rol){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean agregado = false;
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("rolpregunta.agregar"));
            ps.setString(1, rol.getRolusuario());
            ps.setInt(2, rol.getTema());
            agregado = ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return agregado;
    }
    
    
    public boolean updateRolPregunta(RolPregunta rol){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean actualizado = false;
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("rolpregunta.actualizar"));
            ps.setString(1, rol.getRolusuario());
            ps.setInt(2, rol.getTema());
            actualizado = ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return actualizado;
    }
}
