package model.CRUD;

import model.CRUD.abstractCRUD.AbstractCRUD;
import model.personas.TipoPropietario;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public final class TipoPropietarioCRUD extends AbstractCRUD<TipoPropietario, Long> {
    
    public TipoPropietarioCRUD() {
        super(TipoPropietario.class);
    }
    
}
