/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.bl;

import co.edu.udea.encuesta.dao.impl.RespuestaDAO;
import co.edu.udea.encuesta.dto.Respuesta;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
public class RespuestaBL implements Serializable{
    private static RespuestaBL singletonInstance = new RespuestaBL();

    public RespuestaBL() {
    }
        
        public static RespuestaBL getInstance() {
        synchronized (RespuestaBL.class) {
            if (singletonInstance == null) { 
                singletonInstance = new RespuestaBL();
            }
        }
        return singletonInstance;
    }
        
        public Collection<Respuesta> getRespuestas(){
            return obtenerRespuestaDAO().getRespuestas();
        
        }
        
        public boolean addRespuesta(Respuesta respuesta){
            return obtenerRespuestaDAO().addRespuesta(respuesta);
        }
        
        public boolean updateRespuesta(Respuesta respuesta){
            return obtenerRespuestaDAO().updateRespuesta(respuesta);
        }
        
        private RespuestaDAO obtenerRespuestaDAO() {
        RespuestaDAO DAO = new RespuestaDAO();
        return DAO;
    }
}
