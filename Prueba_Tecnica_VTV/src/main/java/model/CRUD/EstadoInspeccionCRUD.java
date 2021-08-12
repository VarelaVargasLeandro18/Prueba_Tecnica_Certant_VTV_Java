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
    
    public EstadoInspeccion leerPorEstado(String estado) {
        try {
            String query = "SELECT * FROM EstadoInspeccion ei WHERE ei.estado = :estado";

            return this.getEntityManager().createQuery(query, EstadoInspeccion.class)
                    .setParameter(":estado", estado)
                    .getSingleResult();
        } catch ( Throwable ex ) {
            return null;
        }
    }
    
}
