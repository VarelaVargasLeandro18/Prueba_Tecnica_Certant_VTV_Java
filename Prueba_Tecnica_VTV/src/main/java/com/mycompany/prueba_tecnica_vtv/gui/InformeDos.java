package com.mycompany.prueba_tecnica_vtv.gui;

import model.CRUD.InspeccionCRUD;
import model.CRUD.InspectorCRUD;
import model.CRUD.abstractCRUD.ReadEntityException;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class InformeDos implements IGUIAdapter {

    private InspeccionCRUD Icrud;
    private InspectorCRUD Inscrud;
    
    public InformeDos () {
        this.Icrud = new InspeccionCRUD();
        this.Inscrud = new InspectorCRUD();
    }

    @Override
    public void realizar() {
       try {
            System.out.println("=================================================");
            System.out.println("Inspectores en planta: ");
            System.out.println(this.Inscrud.readAll().toString());
            System.out.println("=================================================");
            System.out.println("=================================================");
            System.out.println("Inspecciones de las que fueron responsables en los últimos tres días");
            System.out.println(this.Icrud.obtenerInspeccionesUltimosTresDias());
            System.out.println("=================================================");
            
        } catch ( ReadEntityException ex ) {
            System.out.println( "ERROR AL LEER LAS ENTIDADES DE LA BASE DE DATOS." );
        }
       
    }
    
    
    
}
