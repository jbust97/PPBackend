package py.com.progweb.prueba.ejb;


import py.com.progweb.prueba.model.ConceptoUsoPuntos;
import py.com.progweb.prueba.model.UsoPuntos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UsoPuntosDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public void agregar(UsoPuntos entidad) {
        this.em.persist(entidad);
    }

    public List<UsoPuntos> lista (){
        Query q = this.em.createQuery("select u from UsoPuntos u");
        return (List<UsoPuntos>) q.getResultList();
    }
}
