package py.com.progweb.prueba.rest;



import py.com.progweb.prueba.ejb.BolsaPuntosDAO;
import py.com.progweb.prueba.ejb.PersonaDAO;
import py.com.progweb.prueba.ejb.UsoPuntosDAO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("consulta")
@Consumes("Application/json")
@Produces("Application/json")
public class ConsultaRest {

    @Inject
    private BolsaPuntosDAO bolsaPuntosDAO;
    @Inject
    private UsoPuntosDAO usoPuntosDAO;
    @Inject
    private PersonaDAO personaDAO;

    @GET
    @Path("/bolsa")
    public Response consultaBolsa(@QueryParam("id_persona") Integer idPersona,
                                  @QueryParam("limite_inferior") Integer limiteInferior,
                                  @QueryParam("limite_superior") Integer limiteSuperior){
        return Response.ok(bolsaPuntosDAO.getListaFiltrada(idPersona,limiteInferior,limiteSuperior)).build();
    }

    @GET
    @Path("/uso-punto")
    public Response consultaUso(@QueryParam("id_concepto") Integer idConcepto,
                                  @QueryParam("fecha") String fechaUso,
                                  @QueryParam("id_persona") Integer idPersona){

        return Response.ok(usoPuntosDAO.getListaFiltrada(idConcepto,fechaUso,idPersona)).build();
    }
    /*
    consulta de clientes por: nombre (aproximación), apellido (aproximación),cumpleaños
     */
    @GET
    @Path("/persona")
    public Response consultaPersona(@QueryParam("nombre") String nombre,
                                    @QueryParam("apellido") String apellido,
                                    @QueryParam("fecha_nacimiento") String fechaNacimiento){
        return Response.ok(personaDAO.getListaFiltrada(nombre,apellido,fechaNacimiento)).build();
    }

}
