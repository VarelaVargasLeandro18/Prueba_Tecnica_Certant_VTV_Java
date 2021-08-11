package model.personas;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.json.JSONObject;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
@Entity
@Table(name="PROPIETARIOS")
public class Propietario extends Persona implements Serializable {
    
    @OneToOne
    @JoinColumn(name="tipo", referencedColumnName="Id")
    private TipoPropietario tipo;

    public Propietario() {
    }

    public Propietario(TipoPropietario tipo, Long CUIL, String nombre, String apellido, LocalDateTime fechaNac, String email, String NroTelefono) {
        super(CUIL, nombre, apellido, fechaNac, email, NroTelefono);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo.toString();
    }

    public Propietario setTipo(TipoPropietario tipo) {
        this.tipo = tipo;
        return this;
    }
    
    @Override
    public String toString() {
        JSONObject json = new JSONObject(super.toString());
        
        json.put("tipo", this.tipo.toString());
        
        return json.toString(4);
    }
    
}
