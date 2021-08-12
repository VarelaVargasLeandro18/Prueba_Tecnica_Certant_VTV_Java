 package tests;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
 
import model.Auto;
import model.CRUD.AutoCRUD;
import model.CRUD.InspeccionCRUD;
import model.CRUD.InspectorCRUD;
import model.CRUD.MedicionCRUD;
import model.CRUD.ObservacionCRUD;
import model.CRUD.PropietarioCRUD;
import model.CRUD.TipoPropietarioCRUD;
import model.inspeccion.Inspeccion;
import model.inspeccion.Medicion;
import model.inspeccion.Observacion;
import model.personas.Inspector;
import model.personas.Propietario;
import model.personas.TipoPropietario;
 
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

/**
 * Test de funcionamiento 
 * @author Varela Vargas Leandro Gastón
 */
public class TestFuncionamiento {
    
    private InspectorCRUD inspectorCRUD;
    private TipoPropietarioCRUD tipoPropietarioCRUD;
    private PropietarioCRUD propietarioCRUD;
    private AutoCRUD autoCRUD;
    private InspeccionCRUD inspeccionCRUD;
    private MedicionCRUD medicionCRUD;
    private ObservacionCRUD observacionCRUD;
    
    private Inspector inspector;
    private Propietario propietario;
    private Auto autoUno;
    private Auto autoDos;
    private TipoPropietario tipoPropietario;
    private Inspeccion inspeccion;
    private Medicion medicion;
    private Observacion observacion;
    
    //<editor-fold desc="BeforeAll - Creación de Entidades Necesarias" defaultstate="collapsed">
    @BeforeAll
    public void creacionDeInspector() {
        this.inspectorCRUD = new InspectorCRUD();
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
    }
    
    @BeforeAll
    public void creacionDePropietario() {
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
        
    }
    
    @BeforeAll
    public void creacionDeAutomoviles() {
       this.autoCRUD = new AutoCRUD();
       this.autoUno = new Auto(
               "AAA 542",
               "marca",
               "modelo",
               this.propietario
       );
       this.autoCRUD.create(this.autoUno);
       this.autoDos = new Auto(
               "BBB 932",
               "marca",
               "modelo",
               this.propietario
       );
       this.autoCRUD.create(this.autoDos);
    }
    //</editor-fold>
    
    // <editor-fold desc="Tests">
    
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
