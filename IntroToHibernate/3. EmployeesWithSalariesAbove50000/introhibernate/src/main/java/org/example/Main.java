package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Employee;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        em.createQuery("SELECT e FROM Employee AS e WHERE e.salary > 50000", Employee.class)
                .getResultList()
                .forEach(employee -> System.out.println(employee.getFirstName()));

        em.close();
        emf.close();
    }
}
