package model.CRUD;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
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
            String query = "SELECT I FROM Inspeccion I WHERE I.fecha < :ahora AND I.fecha > :sietediasatras;";
            return this.getEntityManager().createQuery(query, Inspeccion.class)
                    .setParameter("ahora", LocalDate.now())
                    .setParameter("sevendaysago", LocalDateTime.now().minusDays(7l))
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
                    .setParameter("tresdiasantes", LocalDateTime.now().minusDays(3l))
                    .getResultList();
        } catch ( Throwable ex ) {
            throw new ReadEntityException(ex);
        }
    }
    
    /**
     * Tercer Informe Pt2 - Obtención de Inspecciones realizadas a los autos de una persona con más de un auto.
     * @param p Propietario cuyas inspecciones se quieren conocer
     * @return List inspecciones de un dueño si tiene más de tres autos. Empty si solo tiene uno.
     */
    public List<Inspeccion> obtenerInspeccionesDePersonaSiTieneMasDeUnAuto( Propietario p ) throws ReadEntityException {
        try {
            String query = "SELECT i FROM Inspeccion i"
                    + " WHERE i.auto.propietario = :persona "
                    + "AND "
                    + "1 < (SELECT COUNT(a.propietario.CUIL) "
                    + "FROM Auto a "
                    + "GROUP BY a.propietario.CUIL)";
            return this.getEntityManager()
                    .createQuery(query, Inspeccion.class)
                    .setParameter(":persona", p)
                    .getResultList();
        } catch ( Throwable ex ) {
            throw new ReadEntityException(ex);
        }     
    }
    
}
