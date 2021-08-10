package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
@Entity
@Table(name="PROPIETARIOS")
public class Propietario extends Persona implements Serializable {

}
