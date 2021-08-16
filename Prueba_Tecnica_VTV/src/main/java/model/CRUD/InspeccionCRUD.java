package model.CRUD;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.TemporalType;
import model.CRUD.abstractCRUD.AbstractCRUD;
import model.CRUD.abstractCRUD.ReadEntityException;
import model.inspeccion.Inspeccion;
import model.personas.Propietario;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public final class InspeccionCRUD extends AbstractCRUD<Inspeccion, Long> {
    
    public InspeccionCRUD() {
        super(Inspeccion.class);
    }
    
    /**
     * Primer Informe - Obtención de Lista de las Inspecciones en la última semana,
     * es decir, desde hace siete días del día de la fecha hasta hoy.
     * @return List inspecciones en la semana.
     * @throws model.CRUD.abstractCRUD.ReadEntityException
     */
    public List<Inspeccion> obtenerInspeccionesDeLaSemana() throws ReadEntityException {
        try {            
            String query = "SELECT I FROM Inspeccion I "
                    + "WHERE I.fecha "
                    + "BETWEEN :sietediasatras "
                    + "AND :ahora";
            return this.getEntityManager().createQuery(query, Inspeccion.class)
                    .setParameter("ahora", LocalDateTime.now())
                    .setParameter("sietediasatras", LocalDateTime.now().minusDays(7l))
                    .getResultList();
        } catch ( Throwable ex ) {
            throw new ReadEntityException(ex);
        }
    }
    
    /**
     * Segundo Informe Pt2 - Obtención de Lista de Inspecciones en los últimos tres días.
     * @return List inspecciones en los últimos tres días.
     * @throws model.CRUD.abstractCRUD.ReadEntityException
     */
    public List<Inspeccion> obtenerInspeccionesUltimosTresDias() throws ReadEntityException {
        try {
            String query = "SELECT I FROM Inspeccion I WHERE I.fecha >= :tresdiasantes";
            return this.getEntityManager()
                    .createQuery(query, Inspeccion.class)
                    .setParameter("tresdiasantes", LocalDateTime.now().minusDays(3l).withHour(0).withMinute(0).withSecond(0))
                    .getResultList();
        } catch ( Throwable ex ) {
            throw new ReadEntityException(ex);
        }
    }
    
    /**
     * Tercer Informe Pt2 - Obtención de Inspecciones realizadas a los autos de una persona en particular con más de un auto.
     * @param p Propietario cuyas inspecciones se quieren conocer
     * @return List inspecciones de un dueño si tiene más de tres autos. Empty si solo tiene uno.
     */
    public List<Inspeccion> obtenerInspeccionesDePersonaSiTieneMasDeUnAuto( Propietario p ) throws ReadEntityException {
        try {
            String query = "FROM Inspeccion I WHERE I.inspeccionado IN "
                    + "(SELECT A FROM Auto A WHERE A.propietario IN "
                    + "(SELECT A.propietario FROM Auto A GROUP BY A.propietario HAVING COUNT(A.propietario) > 1 AND A.propietario = :propietario) )";
            return this.getEntityManager()
                    .createQuery(query, Inspeccion.class)
                    .setParameter("propietario", p)
                    .getResultList();
        } catch ( Throwable ex ) {
            throw new ReadEntityException(ex);
        }     
    }
    
}
