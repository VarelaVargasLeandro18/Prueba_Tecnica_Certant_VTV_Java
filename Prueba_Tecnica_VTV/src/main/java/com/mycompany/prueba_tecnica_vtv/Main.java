package com.mycompany.prueba_tecnica_vtv;

import java.time.LocalDateTime;
import java.time.Month;
import javax.persistence.EntityManager;
import model.CRUD.AbstractCRUD;
import model.CRUD.InspectorCRUD;
import model.personas.Inspector;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        JPAEntityManagerFactory.getEntityManager();
    }
    
}