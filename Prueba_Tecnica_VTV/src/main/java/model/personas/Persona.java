package model.personas;

import java.time.LocalDateTime;
import java.util.Objects;

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

    //<editor-fold desc="Setters" defaultstate="collapsed">
    public Persona setCUIL(Long CUIL) {
        this.CUIL = CUIL;
        return this;
    }

    public Persona setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Persona setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public Persona setFechaNac(LocalDateTime fechaNac) {
        this.fechaNac = fechaNac;
        return this;
    }

    public Persona setEmail(String email) {
        this.email = email;
        return this;
    }

    public Persona setNroTelefono(String NroTelefono) {
        this.NroTelefono = NroTelefono;
        return this;
    }
    //</editor-fold>
    
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.CUIL);
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.apellido);
        hash = 37 * hash + Objects.hashCode(this.fechaNac);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.NroTelefono);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.NroTelefono, other.NroTelefono)) {
            return false;
        }
        if (!Objects.equals(this.CUIL, other.CUIL)) {
            return false;
        }
        if (!Objects.equals(this.fechaNac, other.fechaNac)) {
            return false;
        }
        return true;
    }
    
}
