package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Employee;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine().trim();

        try {
            em.createQuery("SELECT e FROM Employee AS e WHERE e.firstName LIKE :pattern", Employee.class)
                    .setParameter("pattern", pattern + "%")
                    .getResultList()
                    .forEach(employee -> System.out.printf("%s %s - %s - ($%.2f)\n", employee.getFirstName(),
                            employee.getLastName(), employee.getJobTitle(), employee.getSalary()));

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();
        }

    }
}
