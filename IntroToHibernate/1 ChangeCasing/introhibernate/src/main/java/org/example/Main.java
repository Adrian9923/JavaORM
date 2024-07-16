package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Town;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();
        try {
            List<Town> towns = em
                    .createQuery("SELECT t FROM Town t", Town.class)
                    .getResultList();

            for (Town town : towns) {
                if (town.getName().length() > 5) {
                    em.detach(town);
                }
            }

            em.getTransaction().begin();

            for (Town town : towns) {
                if (em.contains(town)) {
                    System.out.println(town.getName() + " -> ");
                    town.setName(town.getName().toLowerCase());
                    System.out.println(town.getName());
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }finally {
            em.close();
            emf.close();
        }


    }
}
