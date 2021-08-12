package model;

import model.personas.Propietario;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.json.JSONObject;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
@Entity
@Table(name="AUTOMOVILES")
public class Auto implements Serializable {
    
    @Id
    @Column(name="dominio")
    private String dominio;
    
    @Column(name="marca", nullable=false)
    private String marca;
    
    @Column(name="modelo", nullable=false)
    private String modelo;
    
    @ManyToOne(optional=false, targetEntity=Propietario.class)
    @JoinColumn(name="propietario_CUIL", referencedColumnName="CUIL", foreignKey=@ForeignKey(name="FK_Propietario"))
    private Propietario propietario;
    
    public Auto() {}

    public Auto(String dominio, String marca, String modelo, Propietario propietario) {
        this.dominio = dominio;
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    //<editor-fold desc="Getters" defaultstate="collapsed">
    public String getDominio() {
        return dominio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Propietario getPropietario() {
        return propietario;
    }
    //</editor-fold>
    
    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        
        json.put( "Dominio" , this.dominio );
        json.put( "Marca", this.marca );
        json.put( "Modelo", this.modelo );
        json.put( "Propietario", this.propietario.toString() );
        
        return json.toString(4);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.dominio);
        hash = 67 * hash + Objects.hashCode(this.marca);
        hash = 67 * hash + Objects.hashCode(this.modelo);
        hash = 67 * hash + Objects.hashCode(this.propietario);
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
        final Auto other = (Auto) obj;
        if (!Objects.equals(this.dominio, other.dominio)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.propietario, other.propietario)) {
            return false;
        }
        return true;
    }
    
}
