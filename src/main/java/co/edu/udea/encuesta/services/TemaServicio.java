/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.services;

import co.edu.udea.encuesta.bl.TemaBL;
import co.edu.udea.encuesta.dto.Tema;
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
@Path("/temas")
public class TemaServicio implements Serializable{
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Tema> getTemas(){
        return TemaBL.getInstance().getTemas();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addTema(Tema tema){
        return TemaBL.getInstance().addTema(tema);
    }
    
    @PUT
    @Path("/{idTema}") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateTema(Tema tema){
        return TemaBL.getInstance().updateTema(tema);
    }
}
