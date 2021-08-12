package tests;

import com.mycompany.prueba_tecnica_vtv.JPAEntityManagerFactory;

import javax.persistence.EntityManager;

import model.CRUD.AbstractCRUD;
import model.CRUD.NotEntityException;
import model.personas.TipoPropietario;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
@TestInstance(Lifecycle.PER_CLASS)
public class TestCRUD {
    
    private AbstractCRUD<TipoPropietario, Long> tipoCRUD;
    private TipoPropietario tipo;
    private final String strTipo = "AAAA";
    private EntityManager em;
    private Long tipoId;
    
    //<editor-fold desc="BeforeAll" defaultstate="collapsed">
    @BeforeAll
    public void initializeCRUDTipoPropietario() {
        try {
            this.tipoCRUD = new AbstractCRUD( TipoPropietario.class );
        } catch ( Throwable ex ) {
            fail( ex );
        }
        
    }
    
    @BeforeAll
    public void initializeTipoPropietario() {
        this.tipo = new TipoPropietario ( 
                this.strTipo
        );
    }
    
    
    @BeforeAll
    public void initializeEntityManager() {
        try {
            this.em = JPAEntityManagerFactory.getEntityManager();
        } catch ( Throwable ex ) {
            fail(ex);
        }
    }
    //</editor-fold>
    
    // <editor-fold desc="Tests">
    @Test
    @DisplayName("Excepción cuando se pasa una Clase que NO es Entity")
    /**
     * Creamos una instancia de AbstractCRUD de forma errónea pasándole una clase que no es una entidad
     * y esperamos que nos dé una NotEntityException.
     */
    public void noEntityExcepcion() {
        Exception exception = assertThrows( NotEntityException.class , () -> {
           new AbstractCRUD( NotEntityException.class ); 
        });
        
        assertTrue( exception instanceof NotEntityException );
    }
    
    @Test
    @DisplayName("Creación de TipoPropietario en BBDD")
    /**
     * Creamos un Tipo Propietario y chequeamos que se haya subido a la BBDD.
     */
    public void creacionTipoPropietario() {
       this.tipoCRUD.create( this.tipo );
       this.tipoId = this.tipo.getId();
              
       assertNotNull( this.tipo.getId() );        
    }
    
    @Test
    @DisplayName("Actualización de TipoPropietario en BBDD")
    /**
     * Actualizamos un TipoPropietario en la BBDD.
     */
    public void actualizacionTipoPropietario() {
        String otroTipo = "Otro Tipo";
        
        this.tipo.setTipo(otroTipo);
        this.tipoCRUD.update(this.tipo);
        
        assertEquals( this.tipo.getTipo(), otroTipo );
    }
    
    @Test
    @DisplayName("Borrado de TipoPropietario en BBDD")
    /**
     * Borramos un TipoPropietario en la BBDD.
     */
    public void borradoTipoPropietario() {
        this.tipoCRUD.delete(this.tipo);
        
        assertNull(this.tipoCRUD.readOne(this.tipoId));
    }
    //</editor-fold>
    
}
