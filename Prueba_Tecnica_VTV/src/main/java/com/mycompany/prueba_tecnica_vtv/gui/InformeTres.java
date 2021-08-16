package com.mycompany.prueba_tecnica_vtv.gui;

import model.CRUD.InspeccionCRUD;
import model.CRUD.PropietarioCRUD;
import model.CRUD.abstractCRUD.ReadEntityException;
import model.personas.Propietario;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class InformeTres implements IGUIAdapter {

    private InspeccionCRUD crud;
    private GUI gui;
    
    public InformeTres ( GUI gui ) {
        this.crud = new InspeccionCRUD();
        this.gui = gui;
    }

    @Override
    public void realizar() {
        
        try {
            System.out.println("=================================================");
            PropietarioCRUD propCRUD = new PropietarioCRUD();
            Long CUIL = Long.valueOf(gui.leerString("Introduzca el CUIL de la persona cuya información desea obtener"));
            Propietario prop = propCRUD.readOne(CUIL);
            
            if ( prop == null ) {
                System.out.println("NO EXISTE EL PROPIETARIO. FIN DEL PROCESO");
                return;
            }
            
            System.out.println("PROPIETARIO: ");
            System.out.println(prop.toString());
            
            System.out.println("INSPECCIONES (SOLO SI TIENE MAS DE UN AUTO)");            
            System.out.println(this.crud.obtenerInspeccionesDePersonaSiTieneMasDeUnAuto(prop).toString());
            
            System.out.println("=================================================");
            
        } catch ( NumberFormatException ex ) {
            System.out.println ( "NO INGRESÓ UN NÚMERO VÁLIDO. FIN DEL PROCESO" );
        } catch ( ReadEntityException ex ) {
            System.out.println( "HUBO UN ERROR AL HACER LECTURA DE ENTIDADES." );
        }
        
    }
    
    
    
}
