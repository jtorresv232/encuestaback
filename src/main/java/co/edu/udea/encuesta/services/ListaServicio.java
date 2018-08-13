/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.services;

import co.edu.udea.encuesta.bl.ListaBL;
import co.edu.udea.encuesta.dto.Lista;
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
@Path("/listas")
public class ListaServicio {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Lista> getListas(){
        return ListaBL.getInstance().getListas();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addLista(Lista lista){
        return ListaBL.getInstance().addLista(lista);
    }
    
    @PUT
    @Path("/{idLista}") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateLista(Lista lista){
        return ListaBL.getInstance().updateLista(lista);
    }
}
