package model.personas;

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
@Table(name="TIPOS_PROPIETARIO")
public class TipoPropietario implements Serializable {
    
    @Id
    private Long Id;
    
    @Column(name="tipo", nullable=false)
    private String tipo;

    public TipoPropietario() {}
    
    public TipoPropietario(Long Id, String tipo) {
        this.Id = Id;
        this.tipo = tipo;
    }
    
    //<editor-fold desc="Getters" defaultstate="collapsed">
    public Long getId() {
        return Id;
    }

    public String getTipo() {
        return tipo;
    }
    //</editor-fold>

    //<editor-fold desc="Setters" defaultstate="collapsed">
    public TipoPropietario setId(Long Id) {
        this.Id = Id;
        return this;
    }

    public TipoPropietario setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }
    //</editor-fold>    
    
    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        
        json.put( "Id", this.Id );
        json.put( "Tipo", this.tipo );
        
        return json.toString(4);        
    }
    
}
