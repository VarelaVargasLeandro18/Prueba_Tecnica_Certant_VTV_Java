package model.CRUD;

import model.CRUD.abstractCRUD.AbstractCRUD;
import model.inspeccion.Medicion;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public final class MedicionCRUD extends AbstractCRUD<Medicion, Long> {
    
    public MedicionCRUD() {
        super(Medicion.class);
    }
    
}
