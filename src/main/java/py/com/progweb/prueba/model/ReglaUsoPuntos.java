package py.com.progweb.prueba.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="regla")
public class ReglaUsoPuntos {
    @Id
    @Column(name = "id_regla")
    @Basic(optional=false)
    @GeneratedValue(generator="reglaSec", strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="reglaSec", sequenceName="regla_sec", allocationSize=0)
    private Integer idRegla;

    @Column(name = "monto_de_equivalencia")
    @Basic(optional = false)
    private Integer montoDeEquivalencia;

    @Temporal(TemporalType.DATE)
    @Column(name="limite_inferior")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "America/Asuncion")
    private Date limiteInferior;

    @Temporal(TemporalType.DATE)
    @Column(name="limite_superior")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "America/Asuncion")
    private Date limiteSuperior;

    public Integer getIdRegla() {
        return idRegla;
    }

    public void setIdRegla(Integer idRegla) {
        this.idRegla = idRegla;
    }

    public Integer getMontoDeEquivalencia() {
        return montoDeEquivalencia;
    }

    public void setMontoDeEquivalencia(Integer montoDeEquivalencia) {
        this.montoDeEquivalencia = montoDeEquivalencia;
    }

    public Date getLimiteInferior() {
        return limiteInferior;
    }

    public void setLimiteInferior(Date limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public Date getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(Date limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

}
