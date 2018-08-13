/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.services;

import co.edu.udea.encuesta.bl.RolPreguntaBL;
import co.edu.udea.encuesta.dto.RolPregunta;
import java.io.Serializable;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jonathan
 */
@Path("/rolesXpregunta")
public class RolPreguntaServicio implements Serializable{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<RolPregunta> getRolesPreguntas(){
        return RolPreguntaBL.getInstance().getRolesPreguntas();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addRolPregunta(RolPregunta rol){
        return RolPreguntaBL.getInstance().addRolPregunta(rol);
    }
    
    @PUT
    @Path("/{idRolPregunt}") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateRolPregunta(RolPregunta rol){
        return RolPreguntaBL.getInstance().updateRolPregunta(rol);
    }
}
