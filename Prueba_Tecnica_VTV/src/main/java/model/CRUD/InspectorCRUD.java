package model.CRUD;

import model.CRUD.abstractCRUD.AbstractCRUD;
import model.personas.Inspector;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public final class InspectorCRUD extends AbstractCRUD<Inspector, Long> {

    public InspectorCRUD() {
        super(Inspector.class);
    }
    
}
