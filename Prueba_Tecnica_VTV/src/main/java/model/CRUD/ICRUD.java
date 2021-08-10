package model.CRUD;

import java.util.List;

/**
 * Interface que define la funcionalidad de un CRUD standard.
 * @author bapo
 * @param <T> Clase de la entidad.
 * @param <K> Clase del @Id de la entidad.
 */
public interface ICRUD<T, K> {
    
    /**
     * Lee una entidad por ID.
     * @param id
     * @return entidad buscada o null si no la encuentra.
     */
    public T readOne ( K id );
    
    /**
     * Lee todas las entidades.
     * @return lista de entidades.
     */
    public List<T> readAll ();
    
    /**
     * Borra un entidad.
     * @param entity
     */
    public void delete ( T entity );
    
    /**
     * Actualiza una entidad.
     * @param updated
     * @return entidad actualizada.
     */
    public T updateOne ( T updated );
    
}
