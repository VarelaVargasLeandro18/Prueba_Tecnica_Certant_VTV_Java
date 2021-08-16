package com.mycompany.prueba_tecnica_vtv.gui;

import model.Auto;
import model.CRUD.AutoCRUD;
import model.CRUD.PropietarioCRUD;
import model.CRUD.abstractCRUD.ReadEntityException;
import model.CRUD.abstractCRUD.UpdateEntityException;
import model.personas.Propietario;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class ModificacionAutoGUI implements IGUIAdapter {
    
    private AutoCRUD crud;
    private GUI gui;
    
    public ModificacionAutoGUI (GUI gui) {
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
        
        try {
            auto = this.crud.readOne(dominio);
            
            if ( auto == null ) {
                System.out.println("NO SE ENCONTRÓ EL AUTO ESPECIFICADO. FIN DE LA OPERACIÓN.");
                return;
            }
            
        } catch ( ReadEntityException ex ) {
            System.out.println ( "ERROR AL LEER LA ENTIDAD. FIN DE LA OPERACIÓN." );
            return;
        }
        
        marca = gui.leerString("Ingrese la nueva marca del auto");
        modelo = gui.leerString("Ingrese el nuevo modelo del auto");
        
        try {
            propietarioId = Long.valueOf(gui.leerString("Ingrese el CUIL del nuevo propietario"));
            propietario = propietariocrud.readOne(propietarioId);
            
            if ( propietario == null ) {
                System.out.println("NO SE ENCONTRÓ AL PROPIETARIO. FIN DE LA OPERACIÓN.");
                return;
            }
            auto.setMarca(marca);
            auto.setModelo(modelo);
            auto.setPropietario(propietario);
            this.crud.update(auto);
            System.out.println ( "SE MODIFICÓ CON EXITO!" );
            System.out.println(auto);
        } catch ( NumberFormatException ex ) {
            System.out.println("NO HA INGRESADO UN CUIL VÁLIDO! FIN DE LA OPERACIÓN.");
        } catch ( ReadEntityException ex ) {
            System.out.println ( "SE HA PRODUCIDO UN ERROR AL BUSCAR EL PROPIETARIO. FIN DE LA OPERACIÓN." );
        }
        catch ( UpdateEntityException ex ) {
            System.out.println("SE HA PRODUCIDO UN ERROR AL ACTUALIZAR LA ENTIDAD. FIN DE LA OPERACIÓN.");
        }
        System.out.println("=================================================");
    }
    
}
