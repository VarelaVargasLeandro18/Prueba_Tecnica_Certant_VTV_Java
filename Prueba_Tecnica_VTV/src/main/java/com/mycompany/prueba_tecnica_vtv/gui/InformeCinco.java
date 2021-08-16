package com.mycompany.prueba_tecnica_vtv.gui;

import model.CRUD.AutoCRUD;
import model.CRUD.EstadoInspeccionCRUD;
import model.CRUD.abstractCRUD.ReadEntityException;
import model.inspeccion.EstadoInspeccion;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class InformeCinco implements IGUIAdapter {

    private AutoCRUD crud;
    
    public InformeCinco() {
        this.crud = new AutoCRUD();
    }

    @Override
    public void realizar() {
        try {
            System.out.println("=================================================");
            EstadoInspeccionCRUD eiCRUD = new EstadoInspeccionCRUD();
            EstadoInspeccion apto = eiCRUD.leerPorEstado("Apto");
            EstadoInspeccion condicional = eiCRUD.leerPorEstado("Condicional");
            EstadoInspeccion rechazado = eiCRUD.leerPorEstado("Rechazado");
            System.out.println("AUTOS APTOS:");
            System.out.println( this.crud.buscarPorCondicion( apto ) );
            System.out.println("AUTOS CONDICIONALES:");
            System.out.println( this.crud.buscarPorCondicion( condicional ) );
            System.out.println("AUTOS RECHAZADOS:");
            System.out.println( this.crud.buscarPorCondicion( rechazado ) );
            System.out.println("=================================================");
        } catch ( ReadEntityException ex ) {
            System.out.println ("ERROR AL REALIZAR LA LECTURA DE LAS ENTIDADES");
        }
    }
    
}
