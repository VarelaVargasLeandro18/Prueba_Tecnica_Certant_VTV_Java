package model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
@Entity
@Table(name="INSPECTORES")
public class Inspector extends Persona {
    
    @Column(name="usuario", nullable=false)
    private String Usuario;
    
    @Column(name="contrasenia", nullable=false)
    private String Contrasenia;

    public Inspector(String Usuario, String Contrasenia, int CUIL, String nombre, String apellido, LocalDateTime fechaNac, String email, String NroTelefono) {
        super(CUIL, nombre, apellido, fechaNac, email, NroTelefono);
        this.Usuario = Usuario;
        this.Contrasenia = Contrasenia;
    }

    // <editor-fold desc="Getters">
    public String getUsuario() {
        return Usuario;
    }

    public String getContrasenia() {
        return Contrasenia;
    }
    // </editor-fold>
     
}
