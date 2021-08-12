package com.mycompany.prueba_tecnica_vtv;

import model.CRUD.abstractCRUD.AbstractCRUD;
import model.personas.Inspector;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception { 
        JPAEntityManagerFactory.getEntityManager();
        AbstractCRUD<Inspector,Long> i = new AbstractCRUD(Inspector.class);
    }
    
}