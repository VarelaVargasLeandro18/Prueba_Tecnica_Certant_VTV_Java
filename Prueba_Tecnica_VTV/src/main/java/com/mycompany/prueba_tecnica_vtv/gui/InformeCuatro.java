package com.mycompany.prueba_tecnica_vtv.gui;

import model.CRUD.AutoCRUD;
import model.CRUD.EstadoInspeccionCRUD;
import model.CRUD.abstractCRUD.ReadEntityException;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class InformeCuatro implements IGUIAdapter {
    
    private AutoCRUD crud;
    
    public InformeCuatro() {
        this.crud = new AutoCRUD();
    }

    @Override
    public void realizar() {
        
        try {
            System.out.println("=================================================");
            System.out.println ( this.crud.chequeoVencimiento( new EstadoInspeccionCRUD().leerPorEstado("Apto") ).toString() );
            System.out.println("=================================================");
        } catch ( ReadEntityException ex ) {
            System.out.println ("ERROR AL REALIZAR LA LECTURA DE LAS ENTIDADES");
        }
        
    }
    
}
