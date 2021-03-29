package py.com.progweb.prueba.rest;


import py.com.progweb.prueba.ejb.ConceptoUsoPuntosDAO;
import py.com.progweb.prueba.model.ConceptoUsoPuntos;
import py.com.progweb.prueba.model.Persona;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("concepto")
@Consumes("application/json")
@Produces("application/json")
public class ConceptoUsoPuntosRest {

    @Inject
    private ConceptoUsoPuntosDAO cupDAO;

    @GET
    @Path("/")
    public Response listar() {
        return Response.ok(cupDAO.lista()).build();
    }

    @POST
    @Path("/")
    public Response crear(ConceptoUsoPuntos c){
        this.cupDAO.agregar(c);
        return Response.ok().build();
    }
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id){
        this.cupDAO.eliminar(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") int id, ConceptoUsoPuntos p){
        this.cupDAO.actualizar(id,p);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") int id){
        return Response.ok(this.cupDAO.get(id)).build();
    }
}
