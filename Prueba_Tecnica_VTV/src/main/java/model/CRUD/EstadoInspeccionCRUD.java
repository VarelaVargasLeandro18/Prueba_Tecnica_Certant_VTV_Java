package model.CRUD;

import model.CRUD.abstractCRUD.AbstractCRUD;
import model.CRUD.abstractCRUD.ReadEntityException;
import model.inspeccion.EstadoInspeccion;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public final class EstadoInspeccionCRUD extends AbstractCRUD<EstadoInspeccion, Long> {

    public EstadoInspeccionCRUD() {
        super(EstadoInspeccion.class);
    }
    
    public EstadoInspeccion leerPorEstado(String estado) throws ReadEntityException {
        try {
            String query = "SELECT ei FROM EstadoInspeccion ei WHERE ei.estado = :estado";

            return this.getEntityManager().createQuery(query, EstadoInspeccion.class)
                    .setParameter("estado", estado)
                    .getSingleResult();
        } catch ( Throwable ex ) {
            throw new ReadEntityException(ex);
        }
    }
    
}
