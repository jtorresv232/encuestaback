/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.dao.impl;

import co.edu.udea.encuesta.dao.ConnectionPool;
import co.edu.udea.encuesta.dto.Tema;
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
public class TemaDAO extends ConnectionPool{
    public Collection<Tema> getTemas(){
        CallableStatement ps = null;
        ResultSet rs = null;
        Collection<Tema> listaTemas = new LinkedList<>();
        Tema tema;
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("tema.obtener"));
            rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    tema = new Tema();
                    tema.setTema(rs.getInt("TEMA"));
                    tema.setDescripcion(rs.getString("DESCRIPCION"));
                    listaTemas.add(tema);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return listaTemas;
    }
    
    public boolean addTema(Tema tema){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean agregado = false;
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("tema.agregar"));
            ps.setInt(1, tema.getTema());
            ps.setString(2, tema.getDescripcion());
            agregado = ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return agregado;
    }
    
    public boolean updateTema(Tema tema){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean actualizado = false;
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("tema.actualizar"));
            ps.setInt(1, tema.getTema());
            ps.setString(2, tema.getDescripcion());
            actualizado = ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return actualizado;
    }
}
