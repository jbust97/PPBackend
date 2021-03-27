package py.com.progweb.prueba.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;

import py.com.progweb.prueba.model.BolsaPuntos;
import py.com.progweb.prueba.model.Persona;

import java.util.List;

@Stateless
public class PersonaDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public void agregar(Persona entidad) {
        this.em.persist(entidad);
    }

    public List<Persona> lista() {
        Query q = this.em.createQuery("select p from Persona p");
        return (List<Persona>) q.getResultList();
    }

    public void eliminar(int id) {
        //Query q = this.em.createQuery("delete from Persona p where p.id = id");
        Persona p = em.find(Persona.class, id);
        this.em.remove(p);
    }

    public void actualizar(int id, Persona np) {

        Persona p = em.merge(np);
        //em.persist(p);
    }

    public Persona get(int id) {
        return em.find(Persona.class, id);
    }

}
