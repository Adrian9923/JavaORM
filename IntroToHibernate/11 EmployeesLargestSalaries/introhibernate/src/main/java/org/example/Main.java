package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        List<Object[]> results = em.createQuery("SELECT d.name, MAX(e.salary) " +
                        "FROM Employee AS e " +
                        "JOIN e.department AS d " +
                        "WHERE e.salary NOT BETWEEN 30000 AND 70000 " +
                        "GROUP BY d.name", Object[].class)
                .getResultList();

        em.close();
        emf.close();

        // Print the departments with their maximum salaries
        StringBuilder sb = new StringBuilder();
        for (Object[] result : results) {
            String departmentName = (String) result[0];
            BigDecimal maxSalary = (BigDecimal) result[1];
            sb.append(String.format("%s - %.2f\n", departmentName, maxSalary));
        }

        System.out.println(sb.toString().trim());
    }

}
