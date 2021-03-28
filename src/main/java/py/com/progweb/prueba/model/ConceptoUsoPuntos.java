package py.com.progweb.prueba.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="concepto_uso_puntos")
public class ConceptoUsoPuntos {

    @Id
    @Column(name="id_concepto")
    @Basic(optional=false)
    @GeneratedValue(generator="conceptoSec", strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="conceptoSec", sequenceName="concepto_sec", allocationSize=0)
    private Integer idConcepto;

    @Column(name="descripcion", length=50)
    @Basic(optional=false)
    private String descripcion;

    @Column(name="puntos_requeridos")
    @Basic(optional=false)
    private Integer puntosRequeridos;


    public ConceptoUsoPuntos(){}

    public Integer getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Integer idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPuntosRequeridos() {
        return puntosRequeridos;
    }

    public void setPuntosRequeridos(Integer puntosRequeridos) {
        this.puntosRequeridos = puntosRequeridos;
    }

}
