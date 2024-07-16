package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Employee;
import org.example.entities.Town;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String[] employeeNames = scanner.nextLine().trim().split("\\s+");

      /*  String[] employeeNames2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .toArray(String[]::new);
        int[] n = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

       */

        List<Employee> employees = em
                .createQuery("SELECT e FROM Employee As e WHERE e.firstName = :firstName AND e.lastName = :lastName", Employee.class)
                .setParameter("firstName", employeeNames[0])
                .setParameter("lastName", employeeNames[1])
                .getResultList();

        if (!employees.isEmpty()) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
        em.close();
        emf.close();
    }
}
