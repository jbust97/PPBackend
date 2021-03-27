package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.DetalleUso;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class DetalleUsoDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public void agregar(DetalleUso entidad) {
        this.em.persist(entidad);
    }

    public List<DetalleUso> lista (){
        Query q = this.em.createQuery("select d from DetalleUso d");
        return (List<DetalleUso>) q.getResultList();
    }
}
