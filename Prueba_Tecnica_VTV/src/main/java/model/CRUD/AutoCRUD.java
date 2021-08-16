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
     * Primer Informe - Obtención de Autos Inspeccionados en la última semana,
     * es decir, desde hace siete días del día de la fecha hasta hoy.
     * @return List autos inspeccionados en la semana.
     * @throws model.CRUD.abstractCRUD.ReadEntityException
     */
    public List<Auto> inspeccionadosSemana() throws ReadEntityException {
        
        try {
            String query = "SELECT I.inspeccionado FROM Inspeccion I WHERE I.fecha >= :ultimaSemana";
            
            return this.getEntityManager()
                    .createQuery(query, Auto.class)
                    .setParameter("ultimaSemana", LocalDateTime.now().minusWeeks(1l))
                    .getResultList();
        } catch ( Throwable ex ) {
            throw new ReadEntityException(ex);
        }
        
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
                    + "WHERE i.estado = :aprobado AND i.fecha <= :unanioatras";
            return this.getEntityManager()
                    .createQuery(query, Auto.class)
                    .setParameter("aprobado", aprobado)
                    .setParameter("unanioatras", LocalDateTime.now().minusYears(1l))
                    .getResultList();
        } catch(Throwable ex) {
            throw new ReadEntityException(ex);
        }
        
    }
    
    /**
     * Quinto Informe - Buscar por condicion
     */
    public List<Auto> buscarPorCondicion ( EstadoInspeccion condicion ) throws ReadEntityException {
        
        try {
            String query = "SELECT i.inspeccionado FROM Inspeccion i "
                    + "WHERE i.estado = :condicion";
            return this.getEntityManager()
                    .createQuery(query, Auto.class)
                    .setParameter("condicion", condicion)
                    .getResultList();
        } catch(Throwable ex) {
            throw new ReadEntityException(ex);
        }
        
    }
    
}
