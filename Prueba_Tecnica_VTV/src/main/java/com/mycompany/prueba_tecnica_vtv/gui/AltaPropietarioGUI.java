package com.mycompany.prueba_tecnica_vtv.gui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.CRUD.PropietarioCRUD;
import model.CRUD.TipoPropietarioCRUD;
import model.CRUD.abstractCRUD.CreateEntityException;
import model.CRUD.abstractCRUD.ReadEntityException;
import static model.inspeccion.Inspeccion_.inspector;
import model.personas.Propietario;
import model.personas.TipoPropietario;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class AltaPropietarioGUI implements IGUIAdapter {

    private PropietarioCRUD crud;
    private GUI gui;
    
    public AltaPropietarioGUI (GUI gui) {
        this.crud = new PropietarioCRUD();
        this.gui = gui;
    }

    @Override
    public void realizar() {
        Propietario propietario;
        Long CUIL;
        String nombre;
        String apellido;
        String email;
        String fecha;
        String nroTelefono;
        String usuario;
        String contrasenia;
        Long tipoPropId;
        TipoPropietario tp;
        TipoPropietarioCRUD tpCRUD = new TipoPropietarioCRUD();
        
        System.out.println("=================================================");
        try {
            CUIL = Long.valueOf(gui.leerString("Ingrese el CUIL del inspector"));
            nombre = gui.leerString("Ingrese el Nombre del inspector");
            apellido = gui.leerString("Ingrese el Apellido del inspector");
            email = gui.leerString("Ingrese el email del inspector");
            fecha = gui.leerString("Ingrese la fecha del inspector con el formato 'yyyy-MM-dd'");
            nroTelefono = gui.leerString("Ingrese el número de teléfono del inspector");
            usuario = gui.leerString("Ingrese el nombre de Usuario del inspector");
            contrasenia = gui.leerString("Ingrese la contrasenia del inspector");
            tipoPropId = Long.valueOf( gui.leerString("Ingrese el ID del tipo de Propietario") );
            
            if ( (tp = tpCRUD.readOne(tipoPropId)) == null ) {
                System.out.println("NO SE ENCONTRÓ EL TIPO DE PROPIETARIO. FIN DE LA OPERACIÓN");
                return;
            }
            
            propietario = new Propietario( 
                    tp,
                    CUIL,
                    nombre,
                    apellido,
                    LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay(),
                    email,
                    nroTelefono
            );
            this.crud.create(propietario);
            
            System.out.println ( "SE CREÓ CON EXITO!" );
            System.out.println(inspector);
        
        } catch ( NumberFormatException ex ) {
            System.out.println("NO HA INGRESADO UN CUIL VÁLIDO! FIN DE LA OPERACIÓN.");
        } catch ( CreateEntityException ex ) {
            System.out.println( "SE HA PRODUCIDO UN ERROR AL CREAR AL INSPECTOR. FIN DE LA OPERACIÓN." );
        } catch ( ReadEntityException ex ) {
            System.out.println( "NO SE PUDO LEER UNA ENTIDAD. FIN DEL PROCESO" );
        }
        System.out.println("=================================================");
    }
    
}
