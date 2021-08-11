package model.personas;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.Column;
import org.json.JSONObject;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
@MappedSuperclass
public abstract class Persona {
    
    @Id
    private Long CUIL;
    
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
    
    public Persona() {}

    public Persona(Long CUIL, String nombre, String apellido, LocalDateTime fechaNac, String email, String NroTelefono) {
        this.CUIL = CUIL;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.email = email;
        this.NroTelefono = NroTelefono;
    }

    // <editor-fold desc="Getters" defaultstate="collapsed">
    public Long getCUIL() {
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
    
    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        
        json.put( "CUIL" , this.CUIL );
        json.put( "Nombre" , this.nombre );
        json.put( "Apellido" , this.nombre );
        json.put( "Fecha_Nacimiento" , this.nombre );
        json.put( "Email" , this.nombre );
        json.put( "Nro_Telefono" , this.nombre );
        
        return json.toString(4);
    }
    
}
