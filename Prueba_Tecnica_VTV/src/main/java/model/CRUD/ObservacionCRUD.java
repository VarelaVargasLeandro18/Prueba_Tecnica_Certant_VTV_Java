package model.CRUD;

import model.CRUD.abstractCRUD.AbstractCRUD;
import model.inspeccion.Observacion;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public final class ObservacionCRUD extends AbstractCRUD<Observacion, Long> {
    
    public ObservacionCRUD() {
        super(Observacion.class);
    }
    
}
