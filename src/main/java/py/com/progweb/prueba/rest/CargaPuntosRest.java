package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.BolsaPuntosDAO;
import py.com.progweb.prueba.model.CargaPuntosPayload;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("cargar-puntos")
@Consumes("application/json")
@Produces("application/json")
public class CargaPuntosRest {

    @Inject
    private BolsaPuntosDAO bolsaPuntosDAO;



    @POST
    @Path("/")
    public Response cargarPuntos(CargaPuntosPayload cargaPuntosPayload){
        if (cargaPuntosPayload.getIdPersona() == null || cargaPuntosPayload.getMontoDeLaOperacion() == null)
            return Response.ok().build();

        bolsaPuntosDAO.cargarPuntos(cargaPuntosPayload.getIdPersona(),cargaPuntosPayload.getMontoDeLaOperacion());
        return Response.ok().build();

    }
}
