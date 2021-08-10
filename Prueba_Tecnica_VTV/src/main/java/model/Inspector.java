package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.json.JSONObject;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
@Entity
@Table(name="INSPECTORES")
public class Inspector extends Persona implements Serializable {
    
    @Column(name="usuario", nullable=false)
    private String usuario;
    
    @Column(name="contrasenia", nullable=false)
    private String contrasenia;

    public Inspector() {}
    
    public Inspector(String usuario, String contrasenia, Long CUIL, String nombre, String apellido, LocalDateTime fechaNac, String email, String NroTelefono) {
        super(CUIL, nombre, apellido, fechaNac, email, NroTelefono);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    // <editor-fold desc="Getters" defaultstate="collapsed">
    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }
    // </editor-fold>

    @Override
    public String toString() {
        JSONObject json = new JSONObject(super.toString());
        
        json.put( "usuario" , this.usuario );
        json.put( "contrasenia", this.contrasenia );
        
        return json.toString(4);        
    }
     
}
