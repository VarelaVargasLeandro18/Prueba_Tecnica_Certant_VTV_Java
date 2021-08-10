package model.CRUD;

import com.mycompany.prueba_tecnica_vtv.JPAEntityManagerFactory;
import javax.persistence.EntityManager;
import model.Inspector;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class InspectorCRUD extends AbstractCRUD<Inspector, Long>{

    public InspectorCRUD() {
        super(Inspector.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return JPAEntityManagerFactory.getEntityManager();
    }
        
}
