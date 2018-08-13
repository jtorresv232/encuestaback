/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.services;

import co.edu.udea.encuesta.bl.RelacionSecretaBL;
import co.edu.udea.encuesta.dto.RelacionSecreta;
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
@Path("/relaciones")
public class RelacionSecretaServicio {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<RelacionSecreta> getRelaciones(){
        return RelacionSecretaBL.getInstance().getRelaciones();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addRelacion(RelacionSecreta relacion){
        return RelacionSecretaBL.getInstance().addRelacion(relacion);
    }
    
    @PUT
    @Path("/{idRelacion}") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateRelacion(RelacionSecreta relacion){
        return RelacionSecretaBL.getInstance().updateRelacion(relacion);
    }
}