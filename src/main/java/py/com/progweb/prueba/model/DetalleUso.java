package py.com.progweb.prueba.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name="detalle")
public class DetalleUso {
    @Id
    @Column(name="id_detalle")
    @Basic(optional = false)
    @GeneratedValue(generator = "detalleSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="detalleSec",sequenceName = "detalle_sec",allocationSize = 0)
    private Integer idDetalle;

    @Column(name="puntaje_utilizado")
    @Basic(optional = false)
    private Integer puntajeUtilizado;

    @JoinColumn(name="id_uso",referencedColumnName = "id_uso")
    @ManyToOne(optional = false)
    private UsoPuntos uso;

    @JoinColumn(name="id_bolsa",referencedColumnName = "id_bolsa")
    @ManyToOne(optional = false)
    private BolsaPuntos bolsa;

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public UsoPuntos getUso() {
        return uso;
    }

    public void setUso(UsoPuntos uso) {
        this.uso = uso;
    }

    public BolsaPuntos getBolsa() {
        return bolsa;
    }

    public void setBolsa(BolsaPuntos bolsa) {
        this.bolsa = bolsa;
    }
}
