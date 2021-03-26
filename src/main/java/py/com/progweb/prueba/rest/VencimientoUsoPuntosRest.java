package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.VencimientoUsoPuntosDAO;
import py.com.progweb.prueba.model.VencimientoUsoPuntos;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("vencimiento")
@Consumes("application/json")
@Produces("application/json")
public class VencimientoUsoPuntosRest {
    @Inject
    VencimientoUsoPuntosDAO vencimientoUsoPuntos;

    @GET
    @Path("/")
    public Response listar(){
        return Response.ok(this.vencimientoUsoPuntos.lista()).build();
    }
    @POST
    @Path("/")
    public Response crear(VencimientoUsoPuntos p){
        this.vencimientoUsoPuntos.agregar(p);
        return Response.ok().build();
    }
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id){
        this.vencimientoUsoPuntos.eliminar(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") int id,VencimientoUsoPuntos p){
        this.vencimientoUsoPuntos.actualizar(id,p);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") int id){
        return Response.ok(this.vencimientoUsoPuntos.get(id)).build();
    }

}