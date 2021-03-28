package py.com.progweb.prueba.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name="bolsa")
public class BolsaPuntos {
    @Id
    @Column(name="id_bolsa")
    @Basic(optional=false)
    @GeneratedValue(generator="bolsaSec", strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="bolsaSec", sequenceName="bolsa_sec", allocationSize=0)
    private Integer idBolsa;



    @Temporal(DATE)
    @Column(name="asignacion_de_puntaje")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="America/Asuncion")
    @Basic(optional = false)
    private Date asignacionDePuntaje;

    @Temporal(DATE)
    @Column(name="caducidad_de_puntaje")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="America/Asuncion")
    @Basic(optional = false)
    private Date caducidadDePuntaje;

    @Column(name="puntaje_asignado")
    @Basic(optional = false)
    private Integer puntajeAsignado;

    @Column(name="puntaje_utilizado")
    @Basic(optional = false)
    private Integer puntajeUtilizado;

    @Column(name="saldo_de_puntos")
    @Basic(optional = false)
    private Integer saldoDePuntos;

    @Column(name="monto_de_la_operacion")
    @Basic(optional = false)
    private Integer montoDeLaOperacion;

    @JoinColumn(name="id_persona",referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    //@JsonBackReference
    private Persona persona;

    public Integer getIdBolsa() {
        return idBolsa;
    }

    public void setIdBolsa(Integer idBolsa) {
        this.idBolsa = idBolsa;
    }


    public Integer getPuntajeAsignado() {
        return puntajeAsignado;
    }

    public void setPuntajeAsignado(Integer puntajeAsignado) {
        this.puntajeAsignado = puntajeAsignado;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Integer getSaldoDePuntos() {
        return saldoDePuntos;
    }

    public void setSaldoDePuntos(Integer saldoDePuntos) {
        this.saldoDePuntos = saldoDePuntos;
    }

    public Integer getMontoDeLaOperacion() {
        return montoDeLaOperacion;
    }

    public void setMontoDeLaOperacion(Integer montoDeLaOperacion) {
        this.montoDeLaOperacion = montoDeLaOperacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Date getAsignacionDePuntaje() {
        return asignacionDePuntaje;
    }

    public void setAsignacionDePuntaje(Date asignacionDePuntaje) {
        this.asignacionDePuntaje = asignacionDePuntaje;
    }

    public Date getCaducidadDePuntaje() {
        return caducidadDePuntaje;
    }

    public void setCaducidadDePuntaje(Date caducidadDePuntaje) {
        this.caducidadDePuntaje = caducidadDePuntaje;
    }
}
