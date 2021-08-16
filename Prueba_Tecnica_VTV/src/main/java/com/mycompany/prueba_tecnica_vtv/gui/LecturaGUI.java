package com.mycompany.prueba_tecnica_vtv.gui;

import model.CRUD.abstractCRUD.AbstractCRUD;
import model.CRUD.abstractCRUD.ReadEntityException;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class LecturaGUI<T, K> implements IGUIAdapter {
    
    private AbstractCRUD<T, K> crud;
    private GUI gui;
    
    public LecturaGUI ( AbstractCRUD<T, K> crud, GUI gui ) {
        this.crud = crud;
        this.gui = gui;
    }

    @Override
    public void realizar() {
        String imprimir;
        
        System.out.println();
        System.out.println("=================================================");
        
        try {
            imprimir = this.crud.readAll().toString();
        } catch ( ReadEntityException ex ) {
            imprimir = "No se pudo ejecutar la lectura pedida.";
        }
        
        System.out.println(imprimir);
        
        System.out.println("=================================================");
    }
    
}
