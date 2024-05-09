/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructure.driven_adapters.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author edwar
 */
public class ConexionJPA {
    private static EntityManagerFactory entityManagerFactory = null;
    
    public static EntityManager createEntityManager() {
        try {
            if(entityManagerFactory == null){
                entityManagerFactory = Persistence.createEntityManagerFactory("softtekPU");
            }
        } catch (Exception e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }
        return entityManagerFactory.createEntityManager();
    }
    
    public static void disconnection(EntityManager entityManager){
        if(entityManager != null){
            entityManager.close();
            entityManagerFactory.close();
        }
    }
    
}
