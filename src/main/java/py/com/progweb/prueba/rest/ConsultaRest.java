package py.com.progweb.prueba.rest;



import py.com.progweb.prueba.ejb.BolsaPuntosDAO;
import py.com.progweb.prueba.ejb.PersonaDAO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("consulta")
@Consumes("Application/json")
@Produces("Application/json")
public class ConsultaRest {

    @Inject
    private PersonaDAO personaDAO;
    @Inject
    private BolsaPuntosDAO bolsaPuntosDAO;
    @GET
    @Path("/bolsa")
    public Response consultaBolsa(@QueryParam("id_persona") Integer idPersona,
                                  @QueryParam("limite_inferior") Integer limiteInferior,
                                  @QueryParam("limite_superior") Integer limiteSuperior){
        return Response.ok(bolsaPuntosDAO.getListaFiltrada(idPersona,limiteInferior,limiteSuperior)).build();
    }
}
