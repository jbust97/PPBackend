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


    @Column(name="limite_inferior")
    private Integer limiteInferior;


    @Column(name="limite_superior")
    private Integer limiteSuperior;

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

    public Integer getLimiteInferior() {
        return limiteInferior;
    }

    public void setLimiteInferior(Integer limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public Integer getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(Integer limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }
}
