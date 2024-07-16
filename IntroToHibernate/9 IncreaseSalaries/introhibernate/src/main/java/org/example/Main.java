package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Employee;

import java.math.BigDecimal;
import java.text.DecimalFormat;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        StringBuilder sb = new StringBuilder();

        em.getTransaction().begin();

        em.createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.department.name IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services') "
                        , Employee.class)
                .getResultList()
                .forEach(employee -> {
                    employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));
                    DecimalFormat df = new DecimalFormat("#,##0.00");
                    df.setGroupingUsed(false);
                    sb.append(employee.getFirstName()).append(" ")
                            .append(employee.getLastName()).append(" ($")
                            .append(df.format(employee.getSalary())).append(")")
                            .append(System.lineSeparator());
                });

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.print(sb.toString().trim());

    }
}
