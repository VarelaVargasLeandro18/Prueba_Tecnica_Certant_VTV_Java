package com.mycompany.prueba_tecnica_vtv.gui;

import model.CRUD.AutoCRUD;
import model.CRUD.abstractCRUD.ReadEntityException;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class InformeUno implements IGUIAdapter{

    public AutoCRUD crud;
    
    public InformeUno () {
        this.crud = new AutoCRUD();
    }
    
    @Override
    public void realizar() {
        
        System.out.println("=================================================");
        System.out.println ( "AUTOS INSPECCIONADOS:" );
        try {
            System.out.println( this.crud.inspeccionadosSemana().toString() );
        } catch ( ReadEntityException ex ) {
            System.out.println ( "ERROR AL LEER LAS ENTIDADES." );
        }
        System.out.println("=================================================");
    }
    
}
