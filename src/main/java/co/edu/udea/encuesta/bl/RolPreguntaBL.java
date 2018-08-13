/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.bl;

import co.edu.udea.encuesta.dao.impl.RolPreguntaDAO;
import co.edu.udea.encuesta.dto.RolPregunta;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
public class RolPreguntaBL implements Serializable{
    private static RolPreguntaBL singletonInstance = new RolPreguntaBL();

    public RolPreguntaBL() {
    }
        
        public static RolPreguntaBL getInstance() {
        synchronized (RolPreguntaBL.class) {
            if (singletonInstance == null) { 
                singletonInstance = new RolPreguntaBL();
            }
        }
        return singletonInstance;
    }
        
        public Collection<RolPregunta> getRolesPreguntas(){
            return obtenerRolPreguntaDAO().getRolesPreguntas();
        
        }
        
        public boolean addRolPregunta(RolPregunta rol){
            return obtenerRolPreguntaDAO().addRolPregunta(rol);
        }
        
        public boolean updateRolPregunta(RolPregunta rol){
            return obtenerRolPreguntaDAO().updateRolPregunta(rol);
        }
        
        private RolPreguntaDAO obtenerRolPreguntaDAO() {
        RolPreguntaDAO DAO = new RolPreguntaDAO();
        return DAO;
    }
}
