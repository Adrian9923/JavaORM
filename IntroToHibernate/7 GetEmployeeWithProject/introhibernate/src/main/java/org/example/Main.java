package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Employee;
import org.example.entities.Project;

import java.util.Comparator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        Integer id = Integer.parseInt(scanner.nextLine());

        try {
            Employee employee = em
                    .createQuery("SELECT e FROM Employee AS e WHERE e.id = :id", Employee.class)
                    .setParameter("id", id)
                    .getSingleResult();

            StringBuilder sb = new StringBuilder();
            sb.append(employee.getFirstName()).append(" ").append(employee.getLastName())
                    .append(" - ").append(employee.getJobTitle()).append(System.lineSeparator());

            employee.getProjects().stream()
                //    .sorted((a,b) -> a.getName().compareTo(b.getName()))
                    .sorted(Comparator.comparing(Project::getName))
                    .forEach(project -> sb.append("\t").append(project.getName()).append(System.lineSeparator()));

            System.out.println(sb.toString().trim());


        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();
        }
    }
}
