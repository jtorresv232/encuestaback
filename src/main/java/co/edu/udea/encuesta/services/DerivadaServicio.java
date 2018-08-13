/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.services;

import co.edu.udea.encuesta.bl.DerivadaBL;
import co.edu.udea.encuesta.dto.Derivada;
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
@Path("/derivadas")
public class DerivadaServicio {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Derivada> obtenerPuntos(){
        return DerivadaBL.getInstance().getDerivadas();
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean agregarPunto(Derivada derivada) throws Exception {
        return DerivadaBL.getInstance().addDerivadas(derivada);
    }
    
    @PUT
    @Path("/{idDerivada}") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean actualizarPunto(Derivada derivada) throws Exception {
        return DerivadaBL.getInstance().updateDerivadas(derivada);
    }
    
}
