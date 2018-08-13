/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.bl;

import co.edu.udea.encuesta.dao.impl.TemaDAO;
import co.edu.udea.encuesta.dto.Tema;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
public class TemaBL {
    private static TemaBL singletonInstance = new TemaBL();

    public TemaBL() {
    }
        
        public static TemaBL getInstance() {
        synchronized (TemaBL.class) {
            if (singletonInstance == null) { 
                singletonInstance = new TemaBL();
            }
        }
        return singletonInstance;
    }
        
        public Collection<Tema> getTemas(){
            return obtenerTemaDAO().getTemas();
        
        }
        
        public boolean addTema(Tema tema){
            return obtenerTemaDAO().addTema(tema);
        }
        
        public boolean updateTema(Tema tema){
            return obtenerTemaDAO().updateTema(tema);
        }
        
        private TemaDAO obtenerTemaDAO() {
        TemaDAO DAO = new TemaDAO();
        return DAO;
    }
}
