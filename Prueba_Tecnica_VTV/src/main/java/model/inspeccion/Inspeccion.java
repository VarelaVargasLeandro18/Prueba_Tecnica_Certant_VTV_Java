package model.inspeccion;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    private Long numero;
    
    @Column(name="fecha", nullable=false)
    private LocalDateTime fecha;
    
    @ManyToOne
    @JoinColumn(name="estado", referencedColumnName="Id")
    private EstadoInspeccion estado;
    
    @ManyToOne
    @JoinColumn(name="exento", referencedColumnName="tipo")
    private TipoPropietario tipo;
    
    @ManyToOne
    @JoinColumn(name="inspector", referencedColumnName="CUIL")
    private Inspector inspector;
    
    @ManyToOne
    @JoinColumn(name="auto_inspeccionado", referencedColumnName="dominio")
    private Auto inspeccionado;
    
    @ManyToOne
    @JoinColumn(name="observacion", referencedColumnName="Id")
    private Observacion observacion;
    
    @ManyToOne
    @JoinColumn(name="medicion", referencedColumnName="Id")
    private Medicion medicion;

    public Inspeccion() {
    }

    public Inspeccion(Long numero, LocalDateTime fecha, EstadoInspeccion estado, TipoPropietario tipo, Inspector inspector, Auto inspeccionado, Observacion observacion, Medicion medicion) {
        this.numero = numero;
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
    
}
