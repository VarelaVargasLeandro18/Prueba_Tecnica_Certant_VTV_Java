package com.mycompany.prueba_tecnica_vtv.gui;

import model.CRUD.abstractCRUD.AbstractCRUD;
import model.CRUD.abstractCRUD.DeleteEntityException;
import model.CRUD.abstractCRUD.ReadEntityException;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class BorradoLongGUI<T> implements IGUIAdapter {
    
    private AbstractCRUD<T,Long> crud;
    private GUI gui;
    
    public BorradoLongGUI ( AbstractCRUD<T, Long> crud, GUI gui ) {
         this.crud = crud;
         this.gui = gui;
    }

    @Override
    public void realizar() {
        System.out.println("=================================================");
        Long Id = Long.valueOf(gui.leerString("INGRESE ID NUMÉRICO DE LA ENTIDAD"));
        
        try {
            T entidad = this.crud.readOne(Id);
            
            if ( entidad == null ) {
                System.out.println("NO SE ENCONTRÓ LA ENTIDAD. FIN DEL PROCESO.");
                return;
            }
            
            this.crud.delete(entidad);
            System.out.println( "BORRADO CON EXITO." );            
        } catch ( ReadEntityException ex ) {
            System.out.println("ERROR AL BUSCAR LA ENTIDAD. FIN DEL PROCESO.");
            return;
        } catch ( DeleteEntityException ex ) {
            System.out.println ( "ERROR AL BORRAR ENTIDAD. ES MUY FACTIBLE QUE SE HAYA PRODUCIDO UN ERROR POR CLAVE FORÁNEA." );
        }
        System.out.println("=================================================");        
    }
    
}
