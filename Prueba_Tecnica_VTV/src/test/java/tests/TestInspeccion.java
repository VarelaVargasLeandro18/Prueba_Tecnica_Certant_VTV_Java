 package tests;

import java.time.LocalDateTime;
import java.time.Month;
 
import model.Auto;
import model.CRUD.AutoCRUD;
import model.CRUD.EstadoInspeccionCRUD;
import model.CRUD.InspeccionCRUD;
import model.CRUD.InspectorCRUD;
import model.CRUD.MedicionCRUD;
import model.CRUD.ObservacionCRUD;
import model.CRUD.PropietarioCRUD;
import model.CRUD.TipoPropietarioCRUD;
import model.CRUD.abstractCRUD.CreateEntityException;
import model.CRUD.abstractCRUD.ReadEntityException;
import model.inspeccion.EstadoInspeccion;
import model.inspeccion.Inspeccion;
import model.inspeccion.Medicion;
import model.inspeccion.Observacion;
import model.personas.Inspector;
import model.personas.Propietario;
import model.personas.TipoPropietario;
 
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test de funcionamiento de CRUD de Inspecciones. 
 * @author Varela Vargas Leandro Gastón
 */
public class TestInspeccion {
    
    private InspectorCRUD inspectorCRUD;
    private TipoPropietarioCRUD tipoPropietarioCRUD;
    private PropietarioCRUD propietarioCRUD;
    private AutoCRUD autoCRUD;
    private InspeccionCRUD inspeccionCRUD;
    private MedicionCRUD medicionCRUD;
    private ObservacionCRUD observacionCRUD;
    private EstadoInspeccionCRUD estadoInspeccionCRUD;
    
    private Inspector inspector;
    private Propietario propietario;
    private Auto autoUno;
    private Auto autoDos;
    private TipoPropietario tipoPropietario;
    private Inspeccion inspeccion;
    private Medicion medicion;
    private Observacion observacion;
    private EstadoInspeccion apto;
    private EstadoInspeccion condicional;
    private EstadoInspeccion rechazado;
    private EstadoInspeccion enProceso;
    
    //<editor-fold desc="BeforeAll creación previa de entidades necesarias." defaultstate="collapsed">
    @BeforeAll
    public void creacionDeInspector() {
        try {            
            this.inspectorCRUD = new InspectorCRUD();
            
            if ( this.inspectorCRUD.readOne(11111111111l) != null ) return;
            
            this.inspector = new Inspector( 
                    "pedlop", 
                    "pedlop123", 
                    11111111111l, 
                    "Pedro", 
                    "Lopez", 
                    LocalDateTime.of(1989, Month.MARCH, 15, 0, 0),
                    "pedlop@mail.com",
                    "+54 1111111111"
            );
            this.inspectorCRUD.create(this.inspector);
        } catch ( CreateEntityException | ReadEntityException ex ) {
            fail(ex);
        }
    }
    
    @BeforeAll
    public void creacionDePropietario() {
        try {
            this.tipoPropietarioCRUD = new TipoPropietarioCRUD();
            this.tipoPropietario = new TipoPropietario(
                "Exento"
            );
            this.tipoPropietarioCRUD.create(this.tipoPropietario);
            
            this.propietarioCRUD = new PropietarioCRUD();
            this.propietario = new Propietario(
                    this.tipoPropietario,
                    22222222222l,
                    "Juan",
                    "Perez",
                    LocalDateTime.of(1976, Month.DECEMBER, 11, 0, 0),
                    "juanp@mail.com",
                    "+54 1111111111"
            );
            this.propietarioCRUD.create(this.propietario);
        } catch ( CreateEntityException ex ) {
            fail(ex);
        }
    }
    
    @BeforeAll
    public void creacionDeAutomoviles() {
       try {
           this.autoCRUD = new AutoCRUD();
           
           if ( this.autoCRUD.readOne("Imposible1") == null ) {
                this.autoUno = new Auto(
                        "Imposible1",
                        "marca",
                        "modelo",
                        this.propietario
                );
                this.autoCRUD.create(this.autoUno);
            }
           
           if ( this.autoCRUD.readOne("Imposible2") != null ) return;
           
           this.autoDos = new Auto(
                   "Imposible2",
                   "marca",
                   "modelo",
                   this.propietario
           );
           this.autoCRUD.create(this.autoDos);
       } catch (CreateEntityException | ReadEntityException ex) {
           fail(ex);
       }
    }
    
    @BeforeAll
    public void creacionEstadosInspeccion () {
        try {
            this.estadoInspeccionCRUD = new EstadoInspeccionCRUD();
            
            if ( ( this.apto = this.estadoInspeccionCRUD.leerPorEstado("Apto") ) == null ) {
                this.apto = new EstadoInspeccion("Apto");
                this.estadoInspeccionCRUD.create(this.apto);
            }
            
            if ( ( this.condicional = this.estadoInspeccionCRUD.leerPorEstado("Condicional") ) == null ) {
                this.condicional = new EstadoInspeccion("Condicional");
                this.estadoInspeccionCRUD.create(this.condicional);
            }
            
            if ( ( this.rechazado = this.estadoInspeccionCRUD.leerPorEstado("Rechazado") ) == null ) {
                this.rechazado = new EstadoInspeccion("Rechazado");
                this.estadoInspeccionCRUD.create(this.rechazado);
            }
            
            if ( ( this.enProceso = this.estadoInspeccionCRUD.leerPorEstado("En Proceso") ) == null ) {
                this.enProceso = new EstadoInspeccion("En Proceso");
                this.estadoInspeccionCRUD.create(this.enProceso);
            }
            
        } catch ( CreateEntityException ex ) {
            fail(ex);
        }      
    }
    // </editor-fold>
    
    // <editor-fold desc="Tests">
    @Test
    @DisplayName("Comienzo de una inspección.")
    public void empezarInspeccion() {
        
        try {
            this.inspeccionCRUD = new InspeccionCRUD();
            this.inspeccion = new Inspeccion(
                    LocalDateTime.now(),
                    this.enProceso,
                    this.tipoPropietario,
                    this.inspector,
                    this.autoUno,
                    null,
                    null
            );
            
            this.inspeccionCRUD.create( this.inspeccion );
            
            assertNotNull( this.inspeccion.getNumero() );
        } catch ( CreateEntityException ex ) {
            fail(ex);
        }
        
    }
    
    @Test
    @DisplayName("Creacion de Observacion y Medicion")
    public void crearObservacionYMedicion() {
        
        
        
    }
    //</editor-fold>
    
    //<editor-fold desc="AfterAll - Eliminado de Entidades Utilizadas" defaultstate="collapsed">
    @AfterAll
    public void eliminarInspector() {
        
    }
    
    @AfterAll
    public void eliminarPropietario() {
        
    }
    
    @AfterAll
    public void eliminarAutomovilUno() {
        
    }
    
    @AfterAll
    public void eliminarAutomovilDos() {
        
    }
    //</editor-fold>
    
}
