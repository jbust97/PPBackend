package py.com.progweb.prueba.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name="persona")
public class Persona {

    @Id
    @Column(name="id_persona")
    @Basic(optional = false)
    @GeneratedValue(generator = "personaSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="personaSec",sequenceName = "persona_sec",allocationSize = 0)
    private Integer idPersona;

    @Column(name="nombre",length = 50)
    @Basic(optional = false)
    private String nombre;

    @Column(name="apellido",length = 50)
    @Basic(optional = false)
    private String apellido;

    @Column(name="numero_ci",length = 25)
    @Basic(optional = false)
    private String numeroCI;

    @Column(name="tipo_ci",length = 25)
    @Basic(optional = false)
    private String tipoCI;

    @Column(name="nacionalidad",length = 25)
    @Basic(optional = false)
    private String nacionalidad;

    @Column(name="email",length = 25)
    @Basic(optional = false)
    private String email;

    @Column(name="telefono",length = 25)
    @Basic(optional = false)
    private String telefono;

    @Temporal(DATE)
    @Column(name="fecha_de_nacimiento",columnDefinition = "DATE")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="America/Asuncion")
    @Basic(optional = false)
    private Date fechaDeNacimiento;

    @OneToMany(mappedBy = "persona", fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonManagedReference
    private List<BolsaPuntos> listaBolsas;

    public Persona(){

    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroCI() {
        return numeroCI;
    }

    public void setNumeroCI(String numeroCI) {
        this.numeroCI = numeroCI;
    }

    public String getTipoCI() {
        return tipoCI;
    }

    public void setTipoCI(String tipoCI) {
        this.tipoCI = tipoCI;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public List<BolsaPuntos> getListaBolsas() {
        return listaBolsas;
    }

    public void setListaBolsas(List<BolsaPuntos> listaBolsas) {
        this.listaBolsas = listaBolsas;
    }
}
