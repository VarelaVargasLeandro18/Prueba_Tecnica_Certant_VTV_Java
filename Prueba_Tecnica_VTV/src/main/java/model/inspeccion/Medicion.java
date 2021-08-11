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
@Table(name="MEDICIONES")
public class Medicion implements Serializable {
    
    @Id
    private Long Id;
    
    @ManyToOne
    @JoinColumn(name="sist_de_frenos", referencedColumnName="Id")
    private EstadoInspeccion sistemaDeFrenos;
    
    @ManyToOne
    @JoinColumn(name="suspension", referencedColumnName="Id")
    private EstadoInspeccion suspension;
    
    @ManyToOne
    @JoinColumn(name="direccion", referencedColumnName="Id")
    private EstadoInspeccion direccion;
    
    @ManyToOne
    @JoinColumn(name="tren_delantero", referencedColumnName="Id")
    private EstadoInspeccion trenDelantero;

    public Medicion() {
    }

    public Medicion(Long Id, EstadoInspeccion sistemaDeFrenos, EstadoInspeccion suspension, EstadoInspeccion direccion, EstadoInspeccion trenDelantero) {
        this.Id = Id;
        this.sistemaDeFrenos = sistemaDeFrenos;
        this.suspension = suspension;
        this.direccion = direccion;
        this.trenDelantero = trenDelantero;
    }
    
    //<editor-fold desc="Getters" defaultstate="collapsed">
    public Long getId() {
        return Id;
    }

    public String getSistemaDeFrenos() {
        return sistemaDeFrenos.getEstado();
    }

    public String getSuspension() {
        return suspension.getEstado();
    }

    public String getDireccion() {
        return direccion.getEstado();
    }

    public String getTrenDelantero() {
        return trenDelantero.getEstado();
    }
    //</editor-fold>

    //<editor-fold desc="Setters" defaultstate="collapsed">
    public Medicion setId(Long Id) {
        this.Id = Id;
        return this;
    }

    public Medicion setSistemaDeFrenos(EstadoInspeccion sistemaDeFrenos) {
        this.sistemaDeFrenos = sistemaDeFrenos;
        return this;
    }

    public Medicion setSuspension(EstadoInspeccion suspension) {
        this.suspension = suspension;
        return this;
    }

    public Medicion setDireccion(EstadoInspeccion direccion) {
        this.direccion = direccion;
        return this;
    }

    public Medicion setTrenDelantero(EstadoInspeccion trenDelantero) {
        this.trenDelantero = trenDelantero;
        return this;
    }
    //</editor-fold>
    
    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        
        json.put( "Id", this.Id );
        json.put( "sistemaDeFrenos", this.sistemaDeFrenos );
        json.put( "suspension", this.suspension );
        json.put( "direccion", this.direccion );
        json.put( "trenDelantero", this.trenDelantero );
        
        return json.toString(4);
    }
    
}
