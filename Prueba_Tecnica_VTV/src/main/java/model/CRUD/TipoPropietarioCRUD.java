package model.CRUD;

import model.CRUD.abstractCRUD.AbstractCRUD;
import model.CRUD.abstractCRUD.ReadEntityException;
import model.personas.TipoPropietario;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public final class TipoPropietarioCRUD extends AbstractCRUD<TipoPropietario, Long> {
    
    public TipoPropietarioCRUD() {
        super(TipoPropietario.class);
    }
    
    public TipoPropietario buscarPorTipo (String tipo) throws ReadEntityException {
        try {
            return this.getEntityManager().createQuery( "SELECT tp FROM TipoPropietario tp WHERE tp.tipo = :tipo", TipoPropietario.class )
                .setParameter( "tipo" , tipo)
                .getSingleResult();
        } catch ( Throwable ex ) {
            throw new ReadEntityException(ex);
        }
    }
    
}
