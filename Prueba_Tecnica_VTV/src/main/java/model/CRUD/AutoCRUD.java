package model.CRUD;

import model.Auto;
import model.CRUD.abstractCRUD.AbstractCRUD;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public final class AutoCRUD extends AbstractCRUD<Auto, Long> {

    public AutoCRUD() {
        super(Auto.class);
    }
    
}
