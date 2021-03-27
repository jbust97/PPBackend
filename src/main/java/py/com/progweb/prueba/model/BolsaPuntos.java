package py.com.progweb.prueba.model;

import javax.persistence.*;

@Entity
@Table(name="bolsa")
public class BolsaPuntos {
    @Id
    @Column(name="id_bolsa")
    @Basic(optional=false)
    @GeneratedValue(generator="bolsaSec", strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="bolsaSec", sequenceName="bolsa_sec", allocationSize=0)
    private Integer idBolsa;

    @Column(name="asignacion_de_puntaje")
    @Basic(optional=false)
    private Integer asignacionDePuntaje;

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
    private Persona persona;

    public Integer getIdBolsa() {
        return idBolsa;
    }

    public void setIdBolsa(Integer idBolsa) {
        this.idBolsa = idBolsa;
    }

    public Integer getAsignacionDePuntaje() {
        return asignacionDePuntaje;
    }

    public void setAsignacionDePuntaje(Integer asignacionDePuntaje) {
        this.asignacionDePuntaje = asignacionDePuntaje;
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
}
