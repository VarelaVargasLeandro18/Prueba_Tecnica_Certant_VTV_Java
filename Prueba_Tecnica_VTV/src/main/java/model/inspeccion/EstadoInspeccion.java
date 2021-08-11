package model.inspeccion;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.json.JSONObject;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
@Entity
@Table(name="ESTADOS_INSPECCION")
public class EstadoInspeccion implements Serializable {

    @Id
    private Long Id;
    
    @Column(name="estado", nullable=false)
    private String estado;
    
    public EstadoInspeccion () {}

    public EstadoInspeccion(Long Id, String estado) {
        this.Id = Id;
        this.estado = estado;
    }

    //<editor-fold desc="Getters" defaultstate="collapsed">
    public Long getId() {
        return Id;
    }

    public String getEstado() {
        return estado;
    }
    //</editor-fold>

    //<editor-fold desc="Setters" defaultstate="collapsed">
    public EstadoInspeccion setId(Long Id) {
        this.Id = Id;
        return this;
    }

    public EstadoInspeccion setEstado(String estado) {
        this.estado = estado;
        return this;
    }
    //</editor-fold>
    
    @Override 
    public String toString() {
        JSONObject json = new JSONObject();
        
        json.put( "Id", this.Id );
        json.put( "estado", this.estado );
        
        return json.toString(4);        
    }
    
}
