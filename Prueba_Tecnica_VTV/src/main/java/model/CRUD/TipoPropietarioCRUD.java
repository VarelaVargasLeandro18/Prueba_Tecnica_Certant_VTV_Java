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
    
    public TipoPropietario buscarPorTipo (String tipo) {
        return this.getEntityManager().createQuery( "SELECT tp FROM TipoPropietario tp WHERE tp.tipo = :tipo", TipoPropietario.class )
                .setParameter( "tipo" , tipo)
                .getSingleResult();
    }
    
}
