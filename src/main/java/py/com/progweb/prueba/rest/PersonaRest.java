package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.PersonaDAO;
import py.com.progweb.prueba.model.Persona;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("persona")
@Consumes("application/json")
@Produces("application/json")
public class PersonaRest {
    @Inject
    private PersonaDAO personaDAO;

    @GET
    @Path("/")
    public Response listar(){
        return Response.ok(this.personaDAO.lista()).build();
    }
    @POST
    @Path("/")
    public Response crear(Persona p){
        this.personaDAO.agregar(p);
        return Response.ok().build();
    }
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id){
        this.personaDAO.eliminar(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") int id,Persona p){
        this.personaDAO.actualizar(id,p);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") int id){
        return Response.ok(this.personaDAO.get(id)).build();
    }
}
