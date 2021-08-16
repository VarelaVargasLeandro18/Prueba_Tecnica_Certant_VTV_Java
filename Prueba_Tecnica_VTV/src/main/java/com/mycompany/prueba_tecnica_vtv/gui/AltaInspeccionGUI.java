package com.mycompany.prueba_tecnica_vtv.gui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Auto;
import model.CRUD.AutoCRUD;
import model.CRUD.EstadoInspeccionCRUD;
import model.CRUD.InspeccionCRUD;
import model.CRUD.InspectorCRUD;
import model.CRUD.MedicionCRUD;
import model.CRUD.ObservacionCRUD;
import model.CRUD.TipoPropietarioCRUD;
import model.CRUD.abstractCRUD.CreateEntityException;
import model.CRUD.abstractCRUD.ReadEntityException;
import model.inspeccion.EstadoInspeccion;
import model.inspeccion.Inspeccion;
import model.inspeccion.Medicion;
import model.inspeccion.Observacion;
import model.personas.Inspector;
import model.personas.TipoPropietario;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class AltaInspeccionGUI implements IGUIAdapter {

    private InspeccionCRUD crud;
    private GUI gui;
    
    public AltaInspeccionGUI ( GUI gui ) {
        this.crud = new InspeccionCRUD();
        this.gui = gui;
    }
    
    @Override
    public void realizar() {
        
        System.out.println("=================================================");
        try {
            Inspeccion inspeccion;
            String fecha;
            LocalDateTime fechaReal;
            Long estadoId;
            EstadoInspeccion estado;
            Long inspectorCUIL;
            Inspector inspector;
            String autoDominio;
            Auto auto;
            String observacionId;
            Observacion obs = null;
            String medicionId;
            Medicion med = null;
            Long tipoPropId;
            TipoPropietario tp;
            TipoPropietarioCRUD TPCRUD = new TipoPropietarioCRUD();
            EstadoInspeccionCRUD EIcrud = new EstadoInspeccionCRUD();
            
            System.out.println( "Tipos de Inspección:" );
            System.out.println( TPCRUD.readAll().toString() );
            System.out.println( EIcrud.readAll().toString() );
            
            System.console().flush();
            
            fecha = this.gui.leerString("Ingrese la fecha de la inspeccion (ingreses 'n' para usar momento actual), utilizando el formato 'yyyy-MM-dd'");
            
            if ( "n".equals(fecha) || "'n'".equals(fecha) )
                fechaReal = LocalDateTime.now();
            else
                fechaReal = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd") ).atStartOfDay();
            
            InspectorCRUD ICRUD = new InspectorCRUD();
            AutoCRUD ACRUD = new AutoCRUD();
            ObservacionCRUD OCRUD = new ObservacionCRUD();
            MedicionCRUD MCRUD = new MedicionCRUD();
            
            estadoId = Long.valueOf( this.gui.leerString("Ingrese el ID del estado de la inspección que corresponda") );
            inspectorCUIL = Long.valueOf( this.gui.leerString("Ingrese el CUIL del Inspector que realizó la operación") );
            autoDominio = this.gui.leerString("Ingrese el Dominio del auto inspeccionado");
            observacionId = this.gui.leerString("Ingrese el ID del estado de Observación de la Inspección ('-' para nada)");
            medicionId = this.gui.leerString("Ingrese el ID de la medicion de Observación de la Inspección ('-' para nada)");
            tipoPropId = Long.valueOf( this.gui.leerString("Ingrese el ID del tipo de Inspeccion (exenta o no extenta)") );
            
            
            auto = ACRUD.readOne(autoDominio);
            estado = EIcrud.readOne(estadoId);
            inspector = ICRUD.readOne(inspectorCUIL);
            tp = TPCRUD.readOne(tipoPropId);
            
            if ( !observacionId.equals("-") )
                obs = OCRUD.readOne( Long.valueOf(observacionId) );
            
            if ( !medicionId.equals("-") )
                med = MCRUD.readOne( Long.valueOf(medicionId) );
            
            if ( auto == null ){
                System.out.println("EL AUTO NO SE ENCONTRÓ. FIN DEL PROCESO");
                return;
            }
            
            if ( inspector == null ){
                System.out.println("EL TIPO DE PROPIETARIO NO SE ENCONTRÓ. FIN DEL PROCESO");
                return;
            }
            
            if ( tp == null ){
                System.out.println("EL TIPO DE PROPIETARIO NO SE ENCONTRÓ. FIN DEL PROCESO");
                return;
            }
            
            if ( estado == null ){
                System.out.println ( "EL ESTADO DE LA INSPECCIÓN NO SE ENCONTRÓ. FIN DEL PROCESO" );
                return;
            }
            
            inspeccion = new Inspeccion(
                    fechaReal,
                    tp,
                    inspector,
                    auto,
                    obs,
                    med                    
            ).setEstado(estado);
            
            this.crud.create(inspeccion);
            
            System.out.println ( "SE CREÓ CON EXITO!" );
            System.out.println(inspeccion);
        
        } catch ( NumberFormatException ex ) {
            System.out.println("NO HA INGRESADO UN NÚMERO VÁLIDO! FIN DE LA OPERACIÓN.");
        } catch ( CreateEntityException ex ) {
            System.out.println( "SE HA PRODUCIDO UN ERROR AL CREAR LA INSPECCIÓN. FIN DE LA OPERACIÓN." );
        } catch ( ReadEntityException ex ) {
            System.out.println( "ERROR AL LEER UNA ENTIDAD! FIN DE LA OPERACIÓN" );
        }
        System.out.println("=================================================");
    }
    
}
