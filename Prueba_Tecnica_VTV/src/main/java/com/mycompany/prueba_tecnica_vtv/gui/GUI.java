package com.mycompany.prueba_tecnica_vtv.gui;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import model.CRUD.InspectorCRUD;
import model.CRUD.abstractCRUD.ReadEntityException;
import model.personas.Inspector;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class GUI {
    
    private Scanner sc;
    private InspectorCRUD inspectorCRUD;
    
    public GUI ( InputStream source ) {
        this.sc = new Scanner(source);
        this.inspectorCRUD = new InspectorCRUD();        
    }
    
    public Inspector pedirUsuarioYContrasenia() {
        String usuario;
        String contrasenia;
        usuario = this.leerString("Usuario");
        contrasenia = this.leerString("Contrasenia");
        
        try {
            return this.inspectorCRUD.ingresar(usuario, contrasenia);
        } catch (ReadEntityException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
    public void imprimirOpcion ( String indice, String mensaje ) {
        System.out.println ( indice + " - " + mensaje + '.' );
    }
    
    private void imprimirMensajeLectura ( String mensaje ) {
        if ( mensaje.length() > 0 )
            System.out.print(mensaje + ": ");
    }
    
    public String leerString ( String mensaje ) {
        this.imprimirMensajeLectura(mensaje);
        return this.sc.nextLine();
    }
    
    public boolean chequearOpcion ( String introducido, List<String> validos ) {
        return validos.contains(introducido);
    }
    
}
