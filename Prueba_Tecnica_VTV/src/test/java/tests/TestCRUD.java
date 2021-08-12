package tests;

import com.mycompany.prueba_tecnica_vtv.JPAEntityManagerFactory;

import javax.persistence.EntityManager;

import model.CRUD.TipoPropietarioCRUD;
import model.CRUD.abstractCRUD.CreateEntityException;
import model.CRUD.abstractCRUD.DeleteEntityException;
import model.CRUD.abstractCRUD.ReadEntityException;
import model.CRUD.abstractCRUD.UpdateEntityException;
import model.personas.TipoPropietario;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
@TestInstance(Lifecycle.PER_CLASS)
public class TestCRUD {
    
    private TipoPropietarioCRUD tipoCRUD;
    private TipoPropietario tipo;
    private final String strTipo = "AAAA";
    private EntityManager em;
    private Long tipoId;
    
    //<editor-fold desc="BeforeAll" defaultstate="collapsed">
    @BeforeAll
    public void initializeCRUDTipoPropietario() {
        try {
            this.tipoCRUD = new TipoPropietarioCRUD();
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
    @DisplayName("Forzado de ReadEntityException")
    public void readEntityException() {
        Throwable readEx = assertThrows( ReadEntityException.class, () -> {
            this.tipoCRUD.readOne(null);
        });
        
        assertTrue(readEx instanceof ReadEntityException);
    }
    
    @Test
    @DisplayName("Forzado de DeleteEntityException")
    public void deleteEntityException() {
        Throwable deleteEx = assertThrows( DeleteEntityException.class, () -> {
            this.tipoCRUD.delete(null);
        });
        
        assertTrue(deleteEx instanceof DeleteEntityException);
    }
    
    @Test
    @DisplayName("Forzado de UpdateEntityException")
    public void updateEntityException() {
        Throwable updateEx = assertThrows( UpdateEntityException.class, () -> {
            this.tipoCRUD.update(null);
        });
        
        assertTrue(updateEx instanceof UpdateEntityException);
    }
    
    @Test
    @DisplayName("Forzado de CreateEntityException")
    public void createEntityException() {
        Throwable createEx = assertThrows( CreateEntityException.class, () -> {
            this.tipoCRUD.create(null);
        });
        
        assertTrue(createEx instanceof CreateEntityException);
    }
    
    @Test
    @DisplayName("Creación de TipoPropietario en BBDD")
    /**
     * Creamos un Tipo Propietario y chequeamos que se haya subido a la BBDD.
     */
    public void creacionTipoPropietario() {
        try {
            this.tipoCRUD.create( this.tipo );
            this.tipoId = this.tipo.getId();

            assertNotNull( this.tipo.getId() );   
        }
        catch( CreateEntityException ex ) {
            fail(ex);
        }
    }
    
    @Test
    @DisplayName("Actualización de TipoPropietario en BBDD")
    /**
     * Actualizamos un TipoPropietario en la BBDD.
     */
    public void actualizacionTipoPropietario() {
        try {
            String otroTipo = "Otro Tipo";
        
            this.tipo.setTipo(otroTipo);
            this.tipoCRUD.update(this.tipo);

            assertEquals( this.tipo.getTipo(), otroTipo );
        } catch ( UpdateEntityException ex ) {
            fail(ex);
        }
    }
    
    @Test
    @DisplayName("Borrado de TipoPropietario en BBDD")
    /**
     * Borramos un TipoPropietario en la BBDD.
     */
    public void borradoTipoPropietario() {
        try {
            this.tipoCRUD.delete(this.tipo);
        
            assertNull(this.tipoCRUD.readOne(this.tipoId));
        } catch ( DeleteEntityException | ReadEntityException ex ) {
            fail(ex);
        }
    }
    //</editor-fold>
    
}
