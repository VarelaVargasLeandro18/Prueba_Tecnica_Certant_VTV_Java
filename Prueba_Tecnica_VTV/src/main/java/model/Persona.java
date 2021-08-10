package model;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.Column;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
@MappedSuperclass
public abstract class Persona {
    
    @Id
    private int CUIL;
    
    @Column(name="nombre", nullable=false)
    private String nombre;
    
    @Column(name="apellido", nullable=false)
    private String apellido;
    
    @Column(name="fecha_nacimiento", nullable=false)
    private LocalDateTime fechaNac;
    
    @Column(name="email", nullable=false)
    private String email;
    
    @Column(name="nro_telefono", nullable=false)
    private String NroTelefono;

    public Persona(int CUIL, String nombre, String apellido, LocalDateTime fechaNac, String email, String NroTelefono) {
        this.CUIL = CUIL;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.email = email;
        this.NroTelefono = NroTelefono;
    }

    // <editor-fold desc="Getters" defaultstate="collapsed">
    public int getCUIL() {
        return CUIL;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDateTime getFechaNac() {
        return fechaNac;
    }

    public String getEmail() {
        return email;
    }

    public String getNroTelefono() {
        return NroTelefono;
    }
    // </editor-fold>
    
}
