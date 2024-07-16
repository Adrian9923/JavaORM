package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Address;
import org.example.entities.Employee;
import org.example.entities.Town;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().trim();

        try {
            Employee employee = em
                    .createQuery("SELECT e FROM Employee AS e WHERE e.lastName = :lastName", Employee.class)
                    .setParameter("lastName", lastName)
                    .getSingleResult();

            Town detroit = em
                    .createQuery("SELECT t FROM Town AS t WHERE t.name = 'Detroit'", Town.class)
                    .getSingleResult();

            Address address = new Address();
            address.setText("Oxford Str 15");
            address.setTown(detroit);

            em.getTransaction().begin();
            em.persist(address);
            employee.setAddress(address);
            em.getTransaction().commit();

            System.out.printf("%s %s changed address to %s, %s\n",
                    employee.getFirstName(), employee.getLastName(),
                    employee.getAddress().getText(), employee.getAddress().getTown().getName());

        }catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally {
            em.close();
            emf.close();
        }

    }
}
