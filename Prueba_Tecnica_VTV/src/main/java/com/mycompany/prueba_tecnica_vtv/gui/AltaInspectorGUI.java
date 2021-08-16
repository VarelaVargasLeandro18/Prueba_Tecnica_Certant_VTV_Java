package com.mycompany.prueba_tecnica_vtv.gui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.CRUD.InspectorCRUD;
import model.CRUD.abstractCRUD.CreateEntityException;
import model.personas.Inspector;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class AltaInspectorGUI implements IGUIAdapter {
    
    private InspectorCRUD crud;
    private GUI gui;
    
    public AltaInspectorGUI (GUI gui) {
        this.crud = new InspectorCRUD();
        this.gui = gui;
    }

    @Override
    public void realizar() {
        Inspector inspector;
        Long CUIL;
        String nombre;
        String apellido;
        String email;
        String fecha;
        String nroTelefono;
        String usuario;
        String contrasenia;
        
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
        
            inspector = new Inspector( usuario, 
                    contrasenia,
                    CUIL,
                    nombre,
                    apellido,
                    LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay(),
                    email,
                    nroTelefono
            );
            this.crud.create(inspector);
            
            System.out.println ( "SE CREÓ CON EXITO!" );
            System.out.println(inspector);
        
        } catch ( NumberFormatException ex ) {
            System.out.println("NO HA INGRESADO UN CUIL VÁLIDO! FIN DE LA OPERACIÓN.");
        } catch ( CreateEntityException ex ) {
            System.out.println( "SE HA PRODUCIDO UN ERROR AL CREAR AL INSPECTOR. FIN DE LA OPERACIÓN." );
        }
        System.out.println("=================================================");
    }
    
}
