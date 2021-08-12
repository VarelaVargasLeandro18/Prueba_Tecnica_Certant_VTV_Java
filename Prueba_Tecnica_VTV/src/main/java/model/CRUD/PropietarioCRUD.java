package model.CRUD;

import model.CRUD.abstractCRUD.AbstractCRUD;
import model.personas.Propietario;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public final class PropietarioCRUD extends AbstractCRUD<Propietario, Long> {
    
    public PropietarioCRUD() {
        super(Propietario.class);
    }
    
}
