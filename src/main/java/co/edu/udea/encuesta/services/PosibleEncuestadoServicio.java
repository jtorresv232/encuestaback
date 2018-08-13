/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.services;

import co.edu.udea.encuesta.bl.PosibleEncuestadoBL;
import co.edu.udea.encuesta.dto.PosibleEncuestado;
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
@Path("/posibles")
public class PosibleEncuestadoServicio implements Serializable{
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<PosibleEncuestado> getPosiblesEncuestados(){
        return PosibleEncuestadoBL.getInstance().getPosiblesEncuestados();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addPosibleEncuestado(PosibleEncuestado posible){
        return PosibleEncuestadoBL.getInstance().addPosibleEncuestado(posible);
    }
    
    @PUT
    @Path("/{idPosible}") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updatePosibleEncuestado(PosibleEncuestado posible){
        return PosibleEncuestadoBL.getInstance().updatePosibleEncuestado(posible);
    }
}
