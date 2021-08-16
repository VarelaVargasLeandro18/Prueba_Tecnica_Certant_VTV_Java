package com.mycompany.prueba_tecnica_vtv.gui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.CRUD.InspectorCRUD;
import model.CRUD.abstractCRUD.ReadEntityException;
import model.CRUD.abstractCRUD.UpdateEntityException;
import model.personas.Inspector;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class ModificacionInspectorGUI implements IGUIAdapter {
    
    private InspectorCRUD crud;
    private GUI gui;
    
    public ModificacionInspectorGUI (GUI gui) {
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
            
            inspector = this.crud.readOne(CUIL);
            
            if ( inspector == null ) {
                System.out.println("NO SE ENCONTRÓ EL INSPECTOR CON EL CUIL ESPECIFICADO. FIN DEL PROCESO.");
                return;
            }
            
            nombre = gui.leerString("Ingrese el NUEVO Nombre del inspector");
            apellido = gui.leerString("Ingrese el NUEVO Apellido del inspector");
            email = gui.leerString("Ingrese el NUEVO email del inspector");
            fecha = gui.leerString("Ingrese la NUEVA fecha del inspector con el formato 'yyyy-MM-dd'");
            nroTelefono = gui.leerString("Ingrese el NUEVO número de teléfono del inspector");
            usuario = gui.leerString("Ingrese el NUEVO nombre de Usuario del inspector");
            contrasenia = gui.leerString("Ingrese la NUEVA contrasenia del inspector");
        
            inspector.setNombre(nombre)
                    .setApellido(apellido)
                    .setEmail(email)
                    .setNroTelefono(nroTelefono)
                    .setUsuario(usuario)
                    .setContrasenia(contrasenia);
            
            if ( this.crud.update(inspector) == null ) {
                System.out.println("NO SE CREÓ EL INSPECTOR. FIN DEL PROCESO.");
                return;
            }
            System.out.println ( "SE CREÓ CON EXITO!" );
            System.out.println(inspector);
        
        } catch ( NumberFormatException ex ) {
            System.out.println("NO HA INGRESADO UN CUIL VÁLIDO! FIN DE LA OPERACIÓN.");
        } catch ( UpdateEntityException ex ) {
            System.out.println( "SE HA PRODUCIDO UN ERROR AL CREAR AL AUTO. FIN DE LA OPERACIÓN." );
        } catch ( ReadEntityException ex ) {
            System.out.println("SE HA PRODUCIDO UN ERROR AL LEER AL INSPECTOR");
        }
        System.out.println("=================================================");
    }
    
}
