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




}
