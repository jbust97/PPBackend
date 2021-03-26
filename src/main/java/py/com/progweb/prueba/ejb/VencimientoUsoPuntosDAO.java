package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.VencimientoUsoPuntos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class VencimientoUsoPuntosDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;
    public void agregar(VencimientoUsoPuntos entidad){
        this.em.persist(entidad);
    }

    public List<VencimientoUsoPuntos> lista (){
        Query q = this.em.createQuery("select r from VencimientoUsoPuntos r");
        return (List<VencimientoUsoPuntos>) q.getResultList();
    }

    public void eliminar(int id){
        //Query q = this.em.createQuery("delete from Persona p where p.id = id");
        VencimientoUsoPuntos p = em.find(VencimientoUsoPuntos.class,id);
        this.em.remove(p);
    }

    public void actualizar(int id,VencimientoUsoPuntos np){

        VencimientoUsoPuntos p = em.merge(np);
        //em.persist(p);
    }

    public VencimientoUsoPuntos get(int id){
        return em.find(VencimientoUsoPuntos.class,id);
    }
}
