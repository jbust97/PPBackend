package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.BolsaPuntosDAO;
import py.com.progweb.prueba.ejb.UsoPuntosDAO;
import py.com.progweb.prueba.model.UsoPuntosPayload;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("usar-puntos")
@Consumes("Application/json")
@Produces("Application/json")
public class UsoPuntosRest {
    @Inject
    private UsoPuntosDAO usoPuntosDAO;

    @POST
    @Path("/")
    public Response usarPuntos(UsoPuntosPayload usoPuntosPayload){
        try{
            usoPuntosDAO.usarPuntos(usoPuntosPayload.getIdPersona(),usoPuntosPayload.getIdConcepto());
        }catch (Exception e){
            System.out.println(e);
            return  Response.ok().build();
        }
        return Response.ok().build();
    }

}
