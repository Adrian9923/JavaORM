package org.example.per_class;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Vehicle bike = new Bike();
        Vehicle car = new Car();

        em.persist(bike);
        em.persist(car);
        em.getTransaction().commit();
    }
}
