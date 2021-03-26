package py.com.progweb.prueba.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="vencimiento")
public class VencimientoUsoPuntos {
    @Id
    @Column(name = "id_vencimiento")
    @Basic(optional=false)
    @GeneratedValue(generator="vencimientoSec", strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="vencimientoSec", sequenceName="vencimiento_sec", allocationSize=0)
    private Integer idVencimiento;

    @Column(name = "dias_de_duracion")
    @Basic(optional = false)
    private Integer diasDeDuracion;

    @Temporal(TemporalType.DATE)
    @Column(name="inicio_validez")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "America/Asuncion")
    private Date inicioValidez;

    @Temporal(TemporalType.DATE)
    @Column(name="fin_validez")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "America/Asuncion")
    private Date finValidez;


    public Integer getIdVencimiento() {
        return idVencimiento;
    }

    public void setIdVencimiento(Integer idVencimiento) {
        this.idVencimiento = idVencimiento;
    }

    public Integer getDiasDeDuracion() {
        return diasDeDuracion;
    }

    public void setDiasDeDuracion(Integer diasDeDuracion) {
        this.diasDeDuracion = diasDeDuracion;
    }

    public Date getInicioValidez() {
        return inicioValidez;
    }

    public void setInicioValidez(Date inicioValidez) {
        this.inicioValidez = inicioValidez;
    }

    public Date getFinValidez() {
        return finValidez;
    }

    public void setFinValidez(Date finValidez) {
        this.finValidez = finValidez;
    }
}
