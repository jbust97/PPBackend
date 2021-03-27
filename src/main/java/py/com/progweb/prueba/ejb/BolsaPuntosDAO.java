package py.com.progweb.prueba.ejb;

import org.jboss.remoting.marshal.VersionedMarshaller;
import py.com.progweb.prueba.model.BolsaPuntos;
import py.com.progweb.prueba.model.Persona;
import py.com.progweb.prueba.model.ReglaUsoPuntos;
import py.com.progweb.prueba.model.VencimientoUsoPuntos;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Stateless
public class BolsaPuntosDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public void agregar(BolsaPuntos entidad) {
        this.em.persist(entidad);
    }

    public List<BolsaPuntos> getListaFiltrada(Integer idPersona,Integer limiteInferior,Integer limiteSuperior){
        String condicion = "";
        if (idPersona != null)
            condicion += "b.persona.idPersona = " + idPersona;
        if (limiteInferior != null){
            condicion += condicion.length() > 0? " AND ":  "";
            condicion += "b.saldoDePuntos >= " + limiteInferior;
        }
        if (limiteSuperior != null){
            condicion += condicion.length() > 0? " AND ":  "";
            condicion += "b.saldoDePuntos <= " + limiteSuperior;
        }
        condicion = condicion.length() > 0? "WHERE " + condicion: "";
        Query q = this.em.createQuery("select b from BolsaPuntos b " + condicion);
        return (List<BolsaPuntos>) q.getResultList();

    }

    public void cargarPuntos(Integer idPersona, Integer montoDeLaOperacion) {
        Persona persona = em.find(Persona.class,idPersona);
        /*
            Si la persona existe
                Encontrar rango de asignacion de puntos
                Encontrar rango de fechas para encontrar validez
                Guardar Fecha de asignacion de puntaje
                Calcular y guardar fecha de caducidad
                Calcular y guardar puntos
                Guardar monto de la operacion
                Colocar en 0 los puntos utilizados y el saldo en los puntos de puntos
         */
        if (persona != null){
            //Encontrar Regla
            Query q = em.createQuery("select r from ReglaUsoPuntos r WHERE r.limiteInferior <= :montoDeLaOperacion AND r.limiteSuperior >= :montoDeLaOperacion");
            ReglaUsoPuntos regla = (ReglaUsoPuntos) q.setParameter("montoDeLaOperacion",montoDeLaOperacion).getSingleResult();
            //Encontrar rango de fechas
            q = em.createQuery("select v from VencimientoUsoPuntos v WHERE v.inicioValidez <= current_date AND v.finValidez >= current_date");
            VencimientoUsoPuntos vencimiento = (VencimientoUsoPuntos) q.getSingleResult();

            Date fechaAsignacion = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
            Date fechaCaducidad =  Date.from(LocalDate.now().plusDays(vencimiento.getDiasDeDuracion()).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
            Integer puntos = montoDeLaOperacion/regla.getMontoDeEquivalencia();

            BolsaPuntos bolsa = new BolsaPuntos();
            bolsa.setAsignacionDePuntaje(fechaAsignacion);
            bolsa.setCaducidadDePuntaje(fechaCaducidad);
            bolsa.setPersona(persona);
            bolsa.setSaldoDePuntos(puntos);
            bolsa.setMontoDeLaOperacion(montoDeLaOperacion);
            bolsa.setPuntajeAsignado(puntos);
            bolsa.setPuntajeUtilizado(0);

            em.persist(bolsa);
        }
    }
}
