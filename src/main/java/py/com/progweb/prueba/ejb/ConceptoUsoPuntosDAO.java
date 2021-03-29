package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.ConceptoUsoPuntos;
import py.com.progweb.prueba.model.Persona;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ConceptoUsoPuntosDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

        public void agregar(ConceptoUsoPuntos entidad) {
            this.em.persist(entidad);
        }

    public List<ConceptoUsoPuntos> lista (){
        Query q = this.em.createQuery("select c from ConceptoUsoPuntos c");
        return (List<ConceptoUsoPuntos>) q.getResultList();
    }

    public void actualizar(int id, ConceptoUsoPuntos np) {

        ConceptoUsoPuntos p = em.merge(np);
        //em.persist(p);
    }

    public void eliminar(int id) {
        //Query q = this.em.createQuery("delete from ConceptoUsoPuntos p where p.id = id");
        ConceptoUsoPuntos p = em.find(ConceptoUsoPuntos.class, id);
        this.em.remove(p);
    }

    public ConceptoUsoPuntos get(int id) {
        return em.find(ConceptoUsoPuntos.class, id);
    }

}
