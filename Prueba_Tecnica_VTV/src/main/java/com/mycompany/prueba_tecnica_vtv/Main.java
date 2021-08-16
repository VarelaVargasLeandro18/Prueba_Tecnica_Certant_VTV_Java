package com.mycompany.prueba_tecnica_vtv;

import java.util.List;
import model.Auto;
import model.CRUD.AutoCRUD;
import model.CRUD.EstadoInspeccionCRUD;
import model.CRUD.InspeccionCRUD;
import model.CRUD.PropietarioCRUD;
import model.CRUD.abstractCRUD.ReadEntityException;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ReadEntityException { 
        // Informe Uno 
        PropietarioCRUD propietarioCRUD = new PropietarioCRUD();
        InspeccionCRUD inspeccionCRUD = new InspeccionCRUD();
        AutoCRUD autoCRUD = new AutoCRUD();
        EstadoInspeccionCRUD estadoInspeccionCRUD = new EstadoInspeccionCRUD();
//        List<Inspeccion> inspecciones = inspeccionCRUD.obtenerInspeccionesDePersonaSiTieneMasDeUnAuto( propietarioCRUD.readOne(8458293459l) );
//        
//        System.out.println( inspecciones.isEmpty() );
//        
//        for ( var i : inspecciones )
//            System.out.printf("%s,\n", i);
        List<Auto> inspecciones = autoCRUD.chequeoVencimiento( estadoInspeccionCRUD.leerPorEstado("Apto") );
//        
        System.out.println( inspecciones.isEmpty() );
        
        for ( var i : inspecciones )
            System.out.printf("%s,\n", i);
    }
    
}