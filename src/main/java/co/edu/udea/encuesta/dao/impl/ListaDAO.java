/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.dao.impl;

import co.edu.udea.encuesta.dao.ConnectionPool;
import co.edu.udea.encuesta.dto.Lista;
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
public class ListaDAO extends ConnectionPool{
    
    public Collection<Lista> getListas(){
        CallableStatement ps = null;
        ResultSet rs = null;
        Collection<Lista> listaListas = new LinkedList<>();
        Lista lista;
        
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("lista.obtener"));
            rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    lista = new Lista();
                    lista.setNumero(rs.getInt("NUMERO"));
                    lista.setItem_lista(rs.getInt("ITEM_LISTA"));
                    lista.setLista(rs.getInt("LISTA"));
                    lista.setItem_lista_texto(rs.getString("ITEM_LISTA_TEXTO"));
                    listaListas.add(lista);
                    
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
            return listaListas;
    }
    
    public boolean addLista(Lista lista){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean agregado = false;
        
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("lista.agregar"));
            ps.setInt(1, lista.getNumero());
            ps.setInt(2, lista.getLista());
            ps.setInt(3, lista.getItem_lista());
            ps.setString(4, lista.getItem_lista_texto());
            
            agregado = ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return agregado;
    }
    
    public boolean updateLista(Lista lista){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean actualizado = false;
        
        try{
            ps = getConn().prepareCall(Properties.getInstance().getEncuestasProperties().getString("lista.actualizar"));
            ps.setInt(1, lista.getNumero());
            ps.setInt(2, lista.getLista());
            ps.setInt(3, lista.getItem_lista());
            ps.setString(4, lista.getItem_lista_texto());
            
            actualizado = ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e);
        }finally{
            close(ps,rs);
        }
        return actualizado;
    }
}
