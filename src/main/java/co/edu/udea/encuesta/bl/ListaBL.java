/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.bl;

import co.edu.udea.encuesta.dao.impl.ListaDAO;
import co.edu.udea.encuesta.dto.Lista;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
public class ListaBL implements Serializable{
    
    private static ListaBL singletonInstance = new ListaBL();

    public ListaBL() {
    }
        
        public static ListaBL getInstance() {
        synchronized (ListaBL.class) {
            if (singletonInstance == null) { 
                singletonInstance = new ListaBL();
            }
        }
        return singletonInstance;
    }
        
        public Collection<Lista> getListas(){
            return obtenerListaDAO().getListas();
        
        }
        
        public boolean addLista(Lista lista){
            return obtenerListaDAO().addLista(lista);
        }
        
        public boolean updateLista(Lista lista){
            return obtenerListaDAO().updateLista(lista);
        }
        
        private ListaDAO obtenerListaDAO() {
        ListaDAO DAO = new ListaDAO();
        return DAO;
    }
}
