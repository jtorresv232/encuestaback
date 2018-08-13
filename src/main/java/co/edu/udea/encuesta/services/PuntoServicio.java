/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.services;

import java.io.Serializable;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.udea.encuesta.bl.PuntoBL;
import co.edu.udea.encuesta.dto.PuntoAplicacion;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Jonathan
 */
@Path("/puntos")
public class PuntoServicio implements Serializable{
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<PuntoAplicacion> obtenerPuntos(){
        return PuntoBL.getInstance().obtenerPuntos();
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean agregarPunto(PuntoAplicacion punto) throws Exception {
        return PuntoBL.getInstance().agregarPunto(punto);
    }
    
    @PUT
    @Path("/{idPunto}") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean actualizarPunto(PuntoAplicacion punto) throws Exception {
        System.out.println("Llame el servicio");
        return PuntoBL.getInstance().actualizarPunto(punto);
    }
    
}
