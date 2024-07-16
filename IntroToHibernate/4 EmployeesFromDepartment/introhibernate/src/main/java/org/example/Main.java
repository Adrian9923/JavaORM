package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Employee;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        em.createQuery("SELECT e FROM Employee AS e WHERE e.department.name = 'Research and Development' ORDER BY e.salary, e.id", Employee.class)
                .getResultList()
                .forEach(employee -> System.out.printf("%s %s from %s - $%.2f\n",
                        employee.getFirstName(), employee.getLastName(),
                        employee.getDepartment().getName(), employee.getSalary()));

        em.close();
        emf.close();
    }
}
