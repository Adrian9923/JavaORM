package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Address;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();


        StringBuilder addresses = new StringBuilder();

        em
                .createQuery("SELECT a FROM  Address AS a ORDER BY SIZE(a.employees) DESC, a.town.id", Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(address -> addresses.append(String.format("%s, %s - %d employees%n",
                        address.getText(), address.getTown().getName(), address.getEmployees().size())));

        em.close();
        emf.close();

        System.out.println(addresses.toString().trim());
    }
}
