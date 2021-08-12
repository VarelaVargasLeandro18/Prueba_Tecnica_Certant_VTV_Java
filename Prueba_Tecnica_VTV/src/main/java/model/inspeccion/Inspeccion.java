package model.inspeccion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import model.Auto;
import model.personas.Inspector;
import model.personas.TipoPropietario;
import org.json.JSONObject;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
@Entity
@Table(name="INSPECCIONES")
public class Inspeccion implements Serializable {
    
    @Id
    @Column(name="numero")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long numero = null;
    
    @Column(name="fecha", nullable=false)
    private LocalDateTime fecha;
    
    @ManyToOne
    @JoinColumn(name="estado", referencedColumnName="Id", foreignKey=@ForeignKey(name="FK_Estado"))
    private EstadoInspeccion estado;
    
    @ManyToOne
    @JoinColumn(name="exento", referencedColumnName="tipo", foreignKey=@ForeignKey(name="FK_Tipo"))
    private TipoPropietario tipo;
    
    @ManyToOne
    @JoinColumn(name="inspector", referencedColumnName="CUIL", foreignKey=@ForeignKey(name="FK_Inspector"))
    private Inspector inspector;
    
    @ManyToOne
    @JoinColumn(name="auto_inspeccionado", referencedColumnName="dominio", foreignKey=@ForeignKey(name="FK_Auto"))
    private Auto inspeccionado;
    
    @ManyToOne
    @JoinColumn(name="observacion", referencedColumnName="Id", foreignKey=@ForeignKey(name="FK_Observacion"))
    private Observacion observacion;
    
    @ManyToOne
    @JoinColumn(name="medicion", referencedColumnName="Id", foreignKey=@ForeignKey(name="FK_Medicion"))
    private Medicion medicion;

    public Inspeccion() {}

    public Inspeccion(LocalDateTime fecha, EstadoInspeccion estado, TipoPropietario tipo, Inspector inspector, Auto inspeccionado, Observacion observacion, Medicion medicion) {
        this.fecha = fecha;
        this.estado = estado;
        this.tipo = tipo;
        this.inspector = inspector;
        this.inspeccionado = inspeccionado;
        this.observacion = observacion;
        this.medicion = medicion;
    }
    
    //<editor-fold desc="Getters" defaultstate="collapsed">
    public Long getNumero() {
        return numero;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado.getEstado();
    }

    public String getTipo() {
        return tipo.getTipo();
    }

    public Inspector getInspector() {
        return inspector;
    }

    public Auto getInspeccionado() {
        return inspeccionado;
    }

    public Observacion getObservacion() {
        return observacion;
    }

    public Medicion getMedicion() {
        return medicion;
    }
    //</editor-fold>
    
    //<editor-fold desc="Setters" defaultstate="collapsed">
    public Inspeccion setNumero(Long numero) {
        this.numero = numero;
        return this;
    }

    public Inspeccion setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }

    public Inspeccion setEstado(EstadoInspeccion estado) {
        this.estado = estado;
        return this;
    }

    public Inspeccion setTipo(TipoPropietario tipo) {
        this.tipo = tipo;
        return this;
    }

    public Inspeccion setInspector(Inspector inspector) {
        this.inspector = inspector;
        return this;
    }

    public Inspeccion setInspeccionado(Auto inspeccionado) {
        this.inspeccionado = inspeccionado;
        return this;
    }

    public Inspeccion setObservacion(Observacion observacion) {
        this.observacion = observacion;
        return this;
    }

    public Inspeccion setMedicion(Medicion medicion) {
        this.medicion = medicion;
        return this;
    }
    //</editor-fold>
    
    public String toString() {
        JSONObject json = new JSONObject();
        
        json.put( "Numero" , this.numero);
        json.put( "Fecha", this.fecha );
        json.put( "Tipo", this.tipo );
        json.put( "Inspector", this.inspector );
        json.put( "Inspeccionado", this.inspeccionado );
        json.put( "Oservacion", this.observacion );
        json.put( "Medicion", this.medicion );
        
        return json.toString(4);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.numero);
        hash = 83 * hash + Objects.hashCode(this.fecha);
        hash = 83 * hash + Objects.hashCode(this.estado);
        hash = 83 * hash + Objects.hashCode(this.tipo);
        hash = 83 * hash + Objects.hashCode(this.inspector);
        hash = 83 * hash + Objects.hashCode(this.inspeccionado);
        hash = 83 * hash + Objects.hashCode(this.observacion);
        hash = 83 * hash + Objects.hashCode(this.medicion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inspeccion other = (Inspeccion) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.inspector, other.inspector)) {
            return false;
        }
        if (!Objects.equals(this.inspeccionado, other.inspeccionado)) {
            return false;
        }
        if (!Objects.equals(this.observacion, other.observacion)) {
            return false;
        }
        if (!Objects.equals(this.medicion, other.medicion)) {
            return false;
        }
        return true;
    }
    
}
