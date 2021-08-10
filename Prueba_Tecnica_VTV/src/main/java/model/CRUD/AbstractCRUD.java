package model.CRUD;

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
    
    protected abstract EntityManager getEntityManager();

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
        this.getEntityManager().merge(entity);
        this.getEntityManager().remove(entity);
    }

    @Override
    public T updateOne(T updated) {
        return this.getEntityManager().merge(updated);
    }
    
}
