package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Project;

import java.util.Comparator;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        StringBuilder projects = new StringBuilder();

        em.createQuery("SELECT p FROM Project AS p ORDER BY p.startDate DESC", Project.class)
                        .setMaxResults(10).getResultList()
                        .stream()
                        .sorted(Comparator.comparing(Project::getName))
                .forEach(project -> projects
                        .append("Project name: ").append(project.getName()).append(System.lineSeparator())
                        .append("\tProject Description: ").append(project.getDescription()).append(System.lineSeparator())
                        .append("\tProject Start Date: ").append(project.getStartDate()).append(System.lineSeparator())
                        .append("\tProject End Date: ").append(project.getEndDate()).append(System.lineSeparator()));

        em.close();
        emf.close();

        System.out.println(projects.toString().trim());
    }
}
