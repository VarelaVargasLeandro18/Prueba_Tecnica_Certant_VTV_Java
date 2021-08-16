package com.mycompany.prueba_tecnica_vtv;

import com.mycompany.prueba_tecnica_vtv.gui.AltaAutoGUI;
import com.mycompany.prueba_tecnica_vtv.gui.BorradoStringGUI;
import com.mycompany.prueba_tecnica_vtv.gui.GUI;
import com.mycompany.prueba_tecnica_vtv.gui.IGUIAdapter;
import com.mycompany.prueba_tecnica_vtv.gui.LecturaGUI;
import com.mycompany.prueba_tecnica_vtv.gui.ModificacionAutoGUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.CRUD.AutoCRUD;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class Main {
    
    private static void menu ( GUI gui ) {
        gui.imprimirOpcion("1", "Alta");
        subOpcionesABM(gui, "1");
        gui.imprimirOpcion("2", "Baja");
        subOpcionesABM(gui, "2");
        gui.imprimirOpcion("3", "Modificación");
        subOpcionesABM(gui, "3");
        subOpcionesABM(gui, "2");
        gui.imprimirOpcion("4", "Lectura");
        subOpcionesABM(gui, "4");
        gui.imprimirOpcion("5", "Informes");
        subOpcionesInformes(gui, "5");
        gui.imprimirOpcion("6", "Salir");
    }
    
    private static void subOpcionesABM ( GUI gui, String opcion ) {
        System.out.print("\t");
        gui.imprimirOpcion(opcion + ".1", "Auto");
        System.out.print("\t");
        gui.imprimirOpcion(opcion + ".2", "Inspector");
        System.out.print("\t");
        gui.imprimirOpcion(opcion + ".3", "Inspección");
        System.out.print("\t");
        gui.imprimirOpcion(opcion + ".4", "Propietario");
    }
    
    private static void subOpcionesInformes ( GUI gui, String opcion ) {
        System.out.print("\t");
        gui.imprimirOpcion(opcion + ".1", 
                "Autos Inspeccionados durante la semana");
        System.out.print("\t");
        gui.imprimirOpcion(opcion + ".2", 
                "Inspectores que trabajan en planta más inspecciones de las que"
                        + " fueron responsables en los últimos 3 días");
        System.out.print("\t");
        gui.imprimirOpcion(opcion + ".3", "Ingresar CUIL de una persona para obtener "
                + "sus datos y si tiene más de un auto mostrar los datos de las "
                + "inspecciones realizadas en planta");
        System.out.print("\t");
        gui.imprimirOpcion(opcion + ".4", "Consultar inspecciones vencidas");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        GUI gui = new GUI(System.in);
        //Inspector inspector = gui.pedirUsuarioYContrasenia();
        String ingresado = "";
        ArrayList<String> salir = new ArrayList<>(1);
        salir.add("6");
        ArrayList<String> opcionesValidas = new ArrayList(21);
        opcionesValidas.add("1.1");
        opcionesValidas.add("1.2");
        opcionesValidas.add("1.3");
        opcionesValidas.add("1.4");
        opcionesValidas.add("2.1");
        opcionesValidas.add("2.2");
        opcionesValidas.add("2.3");
        opcionesValidas.add("2.4");
        opcionesValidas.add("3.1");
        opcionesValidas.add("3.2");
        opcionesValidas.add("3.3");
        opcionesValidas.add("3.4");
        opcionesValidas.add("4.1");
        opcionesValidas.add("4.2");
        opcionesValidas.add("4.3");
        opcionesValidas.add("4.4");
        opcionesValidas.add("5.1");
        opcionesValidas.add("5.2");
        opcionesValidas.add("5.3");
        opcionesValidas.add("5.4");
        opcionesValidas.add("6");
        
        Map<String, IGUIAdapter> adapters = new HashMap();
        
        adapters.put("1.1", new AltaAutoGUI(gui));
        adapters.put("2.1", new BorradoStringGUI( new AutoCRUD(), gui ));
        adapters.put("3.1", new ModificacionAutoGUI(gui));
        adapters.put("4.1", new LecturaGUI( new AutoCRUD(), gui ));
        
        
        IGUIAdapter opcion;
        
        
        while ( !gui.chequearOpcion(ingresado, salir) ) {
            menu(gui);
            
            ingresado = gui.leerString("Ingrese su opción");
            opcion = adapters.get(ingresado);
            
            if ( opcion == null && ingresado != "6" )
                System.out.println("NO INGRESÓ UNA OPCIÓN CORRECTA");
            
            if ( opcion != null )
                opcion.realizar();
            
            gui.leerString("Ingrese cualquier tecla y Enter para continuar");
        }
        
    }
    
}