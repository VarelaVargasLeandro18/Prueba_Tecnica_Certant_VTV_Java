package model.CRUD;

import model.CRUD.abstractCRUD.AbstractCRUD;
import model.inspeccion.EstadoInspeccion;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public final class EstadoInspeccionCRUD extends AbstractCRUD<EstadoInspeccion, Long> {

    public EstadoInspeccionCRUD() {
        super(EstadoInspeccion.class);
    }
    
}
