package com.mycompany.prueba_tecnica_vtv.gui;

import java.time.LocalDate;
import model.CRUD.PropietarioCRUD;
import model.CRUD.TipoPropietarioCRUD;
import model.CRUD.abstractCRUD.ReadEntityException;
import model.CRUD.abstractCRUD.UpdateEntityException;
import model.personas.Propietario;
import model.personas.TipoPropietario;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class ModificacionPropietarioGUI implements IGUIAdapter {
    
    private PropietarioCRUD crud;
    private GUI gui;
    
    public ModificacionPropietarioGUI ( GUI gui ) {
        this.gui = gui;
        this.crud = new PropietarioCRUD();
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
        Long tipoId;
        
        
        System.out.println("=================================================");
        try {
            CUIL = Long.valueOf(gui.leerString("Ingrese el CUIL del propietario"));
            TipoPropietario tipo;
            TipoPropietarioCRUD tpCRUD = new TipoPropietarioCRUD();
            
            propietario = this.crud.readOne(CUIL);
            
            if ( propietario == null ) {
                System.out.println("NO SE ENCONTRÓ EL INSPECTOR CON EL CUIL ESPECIFICADO. FIN DEL PROCESO.");
                return;
            }
            
            nombre = gui.leerString("Ingrese el NUEVO Nombre del propietario");
            apellido = gui.leerString("Ingrese el NUEVO Apellido del propietario");
            email = gui.leerString("Ingrese el NUEVO email del propietario");
            fecha = gui.leerString("Ingrese la NUEVA fecha del propietario con el formato 'yyyy-MM-dd'");
            nroTelefono = gui.leerString("Ingrese el NUEVO número de teléfono del propietario");
            tipoId = Long.valueOf(gui.leerString("Ingrese el Id del tipo de propietario (exento - no exento)"));
            
            if ( (tipo = tpCRUD.readOne(tipoId)) == null ) {
                System.out.println("NO SE ENCONTRÓ EL TIPO DE PROPIETARIO ESPECIFICADO. FIN DEL PROCESO.");
                return;
            }
            
            propietario.setNombre(nombre)
                    .setApellido(apellido)
                    .setEmail(email)
                    .setNroTelefono(nroTelefono)
                    .setTipo(tipo)
                    .setFechaNac(LocalDate.parse(fecha).atStartOfDay());
                    
            
            if ( this.crud.update(propietario) == null ) {
                System.out.println("NO SE MODIFICÓ EL PROPIETARIO. FIN DEL PROCESO.");
                return;
            }
            System.out.println ( "SE CREÓ CON EXITO!" );
            System.out.println(propietario);
        
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
