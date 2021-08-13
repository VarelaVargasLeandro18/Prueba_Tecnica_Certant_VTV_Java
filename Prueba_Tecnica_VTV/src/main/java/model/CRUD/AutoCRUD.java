package model.CRUD;

import java.time.LocalDateTime;
import java.util.List;
import model.Auto;
import model.CRUD.abstractCRUD.AbstractCRUD;
import model.CRUD.abstractCRUD.ReadEntityException;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public final class AutoCRUD extends AbstractCRUD<Auto, String> {

    public AutoCRUD() {
        super(Auto.class);
    }
    
    
    /**
     * Cuato Informe - Chequeo de fiestas de vencimiento dentro del año de haberse
     * ejecutado una Inspeccion o que no esté aprobada.
     * @param aprobado Valor de String de un estado aprobado.
     * @return 
     * @throws model.CRUD.abstractCRUD.ReadEntityException 
     */
    public List<Auto> chequeoVencimiento (String aprobado) throws ReadEntityException {
        
        try {
            String query = "SELECT i.auto FROM Inspeccion i "
                    + "WHERE i.Id != (SELECT i.Id "
                    + "FROM Inspeccion i WHERE i.estado.estado = :aprobado "
                    + "GROUP BY i.auto "
                    + "HAVING i.fecha < :unanioatras);";
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
