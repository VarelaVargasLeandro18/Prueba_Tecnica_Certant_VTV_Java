package model.CRUD;

import model.CRUD.abstractCRUD.AbstractCRUD;
import model.inspeccion.Inspeccion;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public final class InspeccionCRUD extends AbstractCRUD<Inspeccion, Long> {
    
    public InspeccionCRUD() {
        super(Inspeccion.class);
    }
    
}
