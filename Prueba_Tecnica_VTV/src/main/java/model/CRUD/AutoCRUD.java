package model.CRUD;

import java.time.LocalDateTime;
import java.util.List;
import model.Auto;
import model.CRUD.abstractCRUD.AbstractCRUD;
import model.CRUD.abstractCRUD.ReadEntityException;
import model.inspeccion.EstadoInspeccion;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public final class AutoCRUD extends AbstractCRUD<Auto, String> {

    public AutoCRUD() {
        super(Auto.class);
    }
    
    /**
     * Cuarto Informe - Chequeo de fechas de vencimiento dentro del año de haberse
     * ejecutado una Inspeccion o que no esté aprobada.
     * @param aprobado Valor de String de un estado aprobado.
     * @return 
     * @throws model.CRUD.abstractCRUD.ReadEntityException 
     */
    public List<Auto> chequeoVencimiento (EstadoInspeccion aprobado) throws ReadEntityException {
        
        try {
            String query = "SELECT i.inspeccionado FROM Inspeccion i "
                    + "WHERE i.estado = :aprobado AND i.fecha >= :unanioatras";
            return this.getEntityManager()
                    .createQuery(query, Auto.class)
                    .setParameter("aprobado", aprobado)
                    .setParameter("unanioatras", LocalDateTime.now().minusYears(1l))
                    .getResultList();
        } catch(Throwable ex) {
            throw new ReadEntityException(ex);
        }
        
    }
    
}
