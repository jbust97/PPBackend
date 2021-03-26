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
}
