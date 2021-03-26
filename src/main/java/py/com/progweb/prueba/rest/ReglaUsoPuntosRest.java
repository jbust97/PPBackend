package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.ReglaUsoPuntosDAO;
import py.com.progweb.prueba.model.ReglaUsoPuntos;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("regla")
@Consumes("application/json")
@Produces("application/json")
public class ReglaUsoPuntosRest {
    @Inject
    ReglaUsoPuntosDAO reglaUsoPuntosDAO;

    @GET
    @Path("/")
    public Response listar(){
        return Response.ok(this.reglaUsoPuntosDAO.lista()).build();
    }
    @POST
    @Path("/")
    public Response crear(ReglaUsoPuntos p){
        this.reglaUsoPuntosDAO.agregar(p);
        return Response.ok().build();
    }
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id){
        this.reglaUsoPuntosDAO.eliminar(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") int id,ReglaUsoPuntos p){
        this.reglaUsoPuntosDAO.actualizar(id,p);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") int id){
        return Response.ok(this.reglaUsoPuntosDAO.get(id)).build();
    }

}
