/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.services;

import co.edu.udea.encuesta.bl.EncuestaBL;
import co.edu.udea.encuesta.dto.Encuestas;
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
@Path("/encuestas")
public class EncuestaServicio implements Serializable{
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Encuestas> getEncuestas(){
        System.out.println("servicio");
        return EncuestaBL.getInstance().getEncuestas();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addEncuesta(Encuestas encuesta){
        return EncuestaBL.getInstance().addEncuestas(encuesta);
    }
    
    @PUT
    @Path("/{idEncuesta}") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateEncuesta(Encuestas encuesta){
        return EncuestaBL.getInstance().updateEncuestas(encuesta);
    }
    
}
