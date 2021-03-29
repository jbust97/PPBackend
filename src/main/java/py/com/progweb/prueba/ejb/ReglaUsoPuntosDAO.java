package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.ReglaUsoPuntos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ReglaUsoPuntosDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;
    public void agregar(ReglaUsoPuntos entidad){
        if (entidad.getLimiteInferior() == null){
            entidad.setLimiteInferior(0);
        }
        if(entidad.getLimiteSuperior() == null){
            entidad.setLimiteSuperior(Integer.MAX_VALUE);
        }
        this.em.persist(entidad);
    }

    public List<ReglaUsoPuntos> lista (){
        Query q = this.em.createQuery("select r from ReglaUsoPuntos r");
        return (List<ReglaUsoPuntos>) q.getResultList();
    }

    public void eliminar(int id){
        //Query q = this.em.createQuery("delete from Persona p where p.id = id");
        ReglaUsoPuntos p = em.find(ReglaUsoPuntos.class,id);
        this.em.remove(p);
    }

    public void actualizar(int id,ReglaUsoPuntos np){

        ReglaUsoPuntos p = em.merge(np);
        //em.persist(p);
    }

    public ReglaUsoPuntos get(int id){
        return em.find(ReglaUsoPuntos.class,id);
    }

    public Integer equivalenciaMonto(Integer monto) {
        Query q = em.createQuery("select r from ReglaUsoPuntos r WHERE r.limiteInferior <= :monto AND r.limiteSuperior >= :monto").setParameter("monto",monto);
        return monto/((ReglaUsoPuntos) q.getSingleResult()).getMontoDeEquivalencia();
    }
}
