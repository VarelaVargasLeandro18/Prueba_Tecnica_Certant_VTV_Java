package model.inspeccion;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.json.JSONObject;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
@Entity
@Table(name="OBSERVACIONES")
public class Observacion implements Serializable {

    @Id
    private Long Id;
    
    @ManyToOne
    @JoinColumn(name="luces", referencedColumnName="Id")
    private EstadoInspeccion luces;
    
    @ManyToOne
    @JoinColumn(name="patente", referencedColumnName="Id")
    private EstadoInspeccion patente;
    
    @ManyToOne
    @JoinColumn(name="espejos", referencedColumnName="Id")
    private EstadoInspeccion espejos;
    
    @ManyToOne
    @JoinColumn(name="chasis", referencedColumnName="Id")
    private EstadoInspeccion chasis;
    
    @ManyToOne
    @JoinColumn(name="vidrios", referencedColumnName="Id")
    private EstadoInspeccion vidrios;
    
    @ManyToOne
    @JoinColumn(name="seguridad", referencedColumnName="Id")
    private EstadoInspeccion seguridad;
    
    @ManyToOne
    @JoinColumn(name="emergencia", referencedColumnName="Id")
    private EstadoInspeccion emergencia;

    public Observacion() {
    }

    public Observacion(Long Id, EstadoInspeccion luces, EstadoInspeccion patente, EstadoInspeccion espejos, EstadoInspeccion chasis, EstadoInspeccion vidrios, EstadoInspeccion seguridad, EstadoInspeccion emergencia) {
        this.Id = Id;
        this.luces = luces;
        this.patente = patente;
        this.espejos = espejos;
        this.chasis = chasis;
        this.vidrios = vidrios;
        this.seguridad = seguridad;
        this.emergencia = emergencia;
    }

    //<editor-fold desc="Getters" defaultstate="collapsed">
    public Long getId() {
        return Id;
    }

    public String getLuces() {
        return luces.getEstado();
    }

    public String getPatente() {
        return patente.getEstado();
    }

    public String getEspejos() {
        return espejos.getEstado();
    }

    public String getChasis() {
        return chasis.getEstado();
    }

    public String getVidrios() {
        return vidrios.getEstado();
    }

    public String getSeguridad() {
        return seguridad.getEstado();
    }

    public String getEmergencia() {
        return emergencia.getEstado();
    }
    //</editor-fold>
    
    //<editor-fold desc="Setters" defaultstate="collapsed">
    public Observacion setId(Long Id) {
        this.Id = Id;
        return this;
    }

    public Observacion setLuces(EstadoInspeccion luces) {
        this.luces = luces;
        return this;
    }

    public Observacion setPatente(EstadoInspeccion patente) {
        this.patente = patente;
        return this;
    }

    public Observacion setEspejos(EstadoInspeccion espejos) {
        this.espejos = espejos;
        return this;
    }

    public Observacion setChasis(EstadoInspeccion chasis) {
        this.chasis = chasis;
        return this;
    }

    public Observacion setVidrios(EstadoInspeccion vidrios) {
        this.vidrios = vidrios;
        return this;
    }

    public Observacion setSeguridad(EstadoInspeccion seguridad) {
        this.seguridad = seguridad;
        return this;
    }

    public Observacion setEmergencia(EstadoInspeccion emergencia) {
        this.emergencia = emergencia;
        return this;
    }
    //</editor-fold>
    
    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        
        json.put( "Id", this.Id );
        json.put( "luces", this.luces );
        json.put( "patente", this.patente );
        json.put( "espejos", this.espejos );
        json.put( "chasis", this.chasis );
        json.put( "vidrios", this.vidrios );
        json.put( "seguridad", this.seguridad );
        json.put( "emergencia", this.emergencia );
        
        return json.toString(4);
    }
    
}