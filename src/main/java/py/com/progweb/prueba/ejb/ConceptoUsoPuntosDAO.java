package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.ConceptoUsoPuntos;

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
}
