package model.CRUD;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class NotEntityException extends Exception {
    
    public NotEntityException () {
        super( "La clase proporcionada NO es una entidad." );
    }
    
    public NotEntityException ( Throwable ex ) {
        super( "La clase proporcionada NO es una entidad.", ex );
    }
    
    public NotEntityException ( String custom ) {
        super( "La clase proporcionada NO es una entidad." + " " + custom );
    }
    
}
