package model.CRUD;

import com.mycompany.prueba_tecnica_vtv.JPAEntityManagerFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public abstract class AbstractCRUD<T,K> implements ICRUD<T,K> {
    
    private final Class<T> entityClass;

    public AbstractCRUD(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected EntityManager getEntityManager() {
        return JPAEntityManagerFactory.getEntityManager();
    }

    @Override
    public T readOne(K id) {
        
        T findedEntity = null;
        
        try {
            findedEntity = this.getEntityManager().find( this.entityClass , id );
        }
        catch ( Throwable ex ) {
            System.err.println( ex.getStackTrace().toString() );
        }
        
        return findedEntity;
        
    }

    @Override
    public List<T> readAll() {
        
        List<T> findedEntities = null;
        EntityManager em = this.getEntityManager();
        
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root <T> rootEntity = cq.from(this.entityClass);
            
            cq.select(rootEntity);
            
            findedEntities = em.createQuery(cq).getResultList();
        }
        catch ( Throwable ex ) {
            System.err.println( ex.getStackTrace().toString() );
        }
        
        return findedEntities;
    }

    @Override
    public void delete(T entity) {
        this.getEntityManager().getTransaction().begin();
        entity = this.getEntityManager().merge(entity);
        this.getEntityManager().remove(entity);
        this.getEntityManager().getTransaction().commit();
    }

    @Override
    public T update(T updated) {
        return this.getEntityManager().merge(updated);
    }
    
    @Override
    public void create( T created ) {
        this.getEntityManager().getTransaction().begin();
        this.getEntityManager().persist(created);
        this.getEntityManager().getTransaction().commit();
    }
    
}
