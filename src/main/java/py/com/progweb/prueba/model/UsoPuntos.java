package py.com.progweb.prueba.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name="uso")
public class UsoPuntos {

    @Id
    @Column(name="id_uso")
    @Basic(optional = false)
    @GeneratedValue(generator = "usoSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="usoSec",sequenceName = "uso_sec",allocationSize = 0)
    private Integer idUso;

    @Temporal(DATE)
    @Column(name="fecha")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="America/Asuncion")
    @Basic(optional = false)
    private Date fecha;

    @Column(name="puntaje_utilizado")
    @Basic(optional = false)
    private Integer puntajeUtilizado;

    @JoinColumn(name="id_persona",referencedColumnName = "id_persona")
    @ManyToOne(optional = false)

    private Persona persona;

    @JoinColumn(name="id_concepto",referencedColumnName = "id_concepto")
    @ManyToOne(optional = false)
    private ConceptoUsoPuntos concepto;

    public Integer getIdUso() {
        return idUso;
    }

    public void setIdUso(Integer idUso) {
        this.idUso = idUso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public ConceptoUsoPuntos getConcepto() {
        return concepto;
    }

    public void setConcepto(ConceptoUsoPuntos concepto) {
        this.concepto = concepto;
    }
}
