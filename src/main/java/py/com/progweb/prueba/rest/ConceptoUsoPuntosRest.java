package py.com.progweb.prueba.rest;


import py.com.progweb.prueba.ejb.ConceptoUsoPuntosDAO;
import py.com.progweb.prueba.model.ConceptoUsoPuntos;

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

}
