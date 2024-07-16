package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Single.Car;
import org.example.Single.Truck;
import org.example.Single.Vehicle;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Vehicle truck = new Truck(5,2);
        Vehicle car = new Car(5);

        em.persist(truck);
        em.persist(car);

        em.getTransaction().commit();
    }
}