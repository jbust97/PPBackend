package py.com.progweb.prueba.ejb;


import py.com.progweb.prueba.model.*;

import javax.ejb.ApplicationException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

import static java.util.Collections.min;

@ApplicationException(rollback = true)
class BusinessException extends Exception{
    public BusinessException(String e){
        super(e);
    }
}

@Stateless
public class UsoPuntosDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;
    @Inject
    private EnviaCorreos ec;
    public void agregar(UsoPuntos entidad) {
        this.em.persist(entidad);
    }

    public List<UsoPuntos> lista (){
        Query q = this.em.createQuery("select u from UsoPuntos u");
        return (List<UsoPuntos>) q.getResultList();
    }

    public void usarPuntos(Integer idPersona, Integer idConcepto) throws BusinessException {


        if(idPersona != null && idConcepto != null){


            //EntityTransaction t= em.getTransaction();

                //t.begin();
                ConceptoUsoPuntos concepto = (ConceptoUsoPuntos) em.createQuery("select c from ConceptoUsoPuntos c where c.idConcepto =: idConcepto").setParameter("idConcepto", idConcepto).getSingleResult();
                Persona persona = (Persona) em.createQuery("select p from Persona p where p.idPersona =: idPersona").setParameter("idPersona", idPersona).getSingleResult();

                Integer puntosRequeridos = concepto.getPuntosRequeridos();

                List<BolsaPuntos> bolsas = (List<BolsaPuntos>) em.createQuery("select b from BolsaPuntos b where b.persona.idPersona =:idPersona and b.saldoDePuntos > 0 order by b.asignacionDePuntaje").setParameter("idPersona", persona.getIdPersona()).getResultList();
                Integer puntosRestantes = puntosRequeridos;
                Integer utilizado;

                UsoPuntos uso = new UsoPuntos();
                uso.setConcepto(concepto);
                uso.setPersona(persona);
                uso.setPuntajeUtilizado(puntosRequeridos);
                uso.setFecha(new Date());
                em.persist(uso);

                for (BolsaPuntos bolsa : bolsas) {
                    if(puntosRestantes == 0)
                        break;

                    utilizado = Math.min(bolsa.getSaldoDePuntos(),puntosRestantes);
                    bolsa.setSaldoDePuntos(bolsa.getSaldoDePuntos() - utilizado);
                    bolsa.setPuntajeUtilizado(bolsa.getPuntajeUtilizado() + utilizado);
                    puntosRestantes -= utilizado;

                    em.persist(bolsa);

                    DetalleUso detalle = new DetalleUso();
                    detalle.setBolsa(bolsa);
                    detalle.setUso(uso);
                    detalle.setPuntajeUtilizado(utilizado);

                    em.persist(detalle);
                }
                if (puntosRestantes > 0){
                    throw new BusinessException("No hay suficientes puntos en las bolsas");
                }else{
                    this.ec.sendMessage(persona.getEmail(),uso);
                }
                //t.commit();


        }
    }

    public List<UsoPuntos> getListaFiltrada(Integer idConcepto, String fechaUso, Integer idPersona) {
        String condicion = "";
        if (idPersona != null)
            condicion += "u.persona.idPersona = " + idPersona;
        if (idConcepto != null) {
            condicion += condicion.length() > 0 ? " AND " : "";
            condicion += "u.concepto.idConcepto = " + idConcepto;
        }
        if (fechaUso != null) {
            condicion += condicion.length() > 0 ? " AND " : "";
            condicion += "u.fecha = '" + fechaUso+ "'";
        }
        condicion = condicion.length() > 0 ? "WHERE " + condicion : "";
        Query q = this.em.createQuery("select u from UsoPuntos u " + condicion);
        return (List<UsoPuntos>) q.getResultList();
    }
}
