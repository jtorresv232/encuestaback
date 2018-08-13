/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.dao.impl;

import co.edu.udea.encuesta.dao.ConnectionPool;
import co.edu.udea.encuesta.dto.Derivada;
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
public class DerivadaDAO extends ConnectionPool{
    public Collection<Derivada> getDerivadas(){
        CallableStatement ps = null;
        ResultSet rs = null;
        Collection<Derivada> listaDerivadas = new LinkedList<>();
        Derivada derivada;
        
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("derivada.obtener"));
            rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    derivada = new Derivada();
                    derivada.setNumero(rs.getInt("NUMERO"));
                    derivada.setOpcion(rs.getInt("OPCION"));
                    derivada.setSecuencia(rs.getInt("SECUENCIA"));
                    derivada.setDerivada(rs.getInt("DERIVADA"));
                    listaDerivadas.add(derivada);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return listaDerivadas;
    }
    
    public boolean addDerivada(Derivada derivada){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean agregado = false;
        
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("derivada.agregar"));
            ps.setInt(1, derivada.getNumero());
            ps.setInt(2, derivada.getOpcion());
            ps.setInt(3, derivada.getSecuencia());
            ps.setInt(4, derivada.getDerivada());
            agregado = ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        
        return agregado;
    }
    
    public boolean updateDerivada(Derivada derivada){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean actualizado = false;
        
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("derivada.actualizar"));
            ps.setInt(1, derivada.getNumero());
            ps.setInt(2, derivada.getOpcion());
            ps.setInt(3, derivada.getSecuencia());
            ps.setInt(4, derivada.getDerivada());
            actualizado = ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        
        return actualizado;
    }
    
}
