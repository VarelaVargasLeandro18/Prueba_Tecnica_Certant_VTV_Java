package com.mycompany.prueba_tecnica_vtv.gui;

import model.Auto;
import model.CRUD.AutoCRUD;
import model.CRUD.PropietarioCRUD;
import model.CRUD.abstractCRUD.CreateEntityException;
import model.CRUD.abstractCRUD.ReadEntityException;
import model.personas.Propietario;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class AltaAutoGUI implements IGUIAdapter {
    
    private AutoCRUD crud;
    private GUI gui;
    
    public AltaAutoGUI (GUI gui) {
        this.crud = new AutoCRUD();
        this.gui = gui;
    }

    @Override
    public void realizar() {
        String dominio;
        String marca;
        String modelo;
        Long propietarioId;
        Propietario propietario = null;
        PropietarioCRUD propietariocrud = new PropietarioCRUD();
        Auto auto;
        System.out.println("=================================================");
        dominio = gui.leerString("Ingrese el dominio del auto");
        marca = gui.leerString("Ingrese la marca del auto");
        modelo = gui.leerString("Ingrese el modelo del auto");
        
        try {
            propietarioId = Long.valueOf(gui.leerString("Ingrese el CUIL del propietario"));
            propietario = propietariocrud.readOne(propietarioId);
            
            if ( propietario == null ) {
                System.out.println("NO SE ENCONTRÓ AL PROPIETARIO. FIN DE LA OPERACIÓN.");
                return;
            }
            
            auto = new Auto( dominio, marca, modelo, propietario );
            this.crud.create(auto);
            System.out.println ( "SE CREÓ CON EXITO!" );
            System.out.println(auto);
        } catch ( NumberFormatException ex ) {
            System.out.println("NO HA INGRESADO UN CUIL VÁLIDO! FIN DE LA OPERACIÓN.");
        } catch ( ReadEntityException ex ) {
            System.out.println ( "SE HA PRODUCIDO UN ERROR AL BUSCAR EL PROPIETARIO. FIN DE LA OPERACIÓN." );
        } catch ( CreateEntityException ex ) {
            System.out.println( "SE HA PRODUCIDO UN ERROR AL CREAR AL AUTO. FIN DE LA OPERACIÓN." );
        }
        System.out.println("=================================================");
    }
    
}
