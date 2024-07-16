import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import relations.WizardDeposits;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        LocalDate depositStartDate = LocalDate.of(1998, 7, 31);
        LocalDate depositExpirationDate = LocalDate.of(1999, 7, 31);

        WizardDeposits wizardDeposits = new WizardDeposits(
                "Adrian",
                "Lefter",
                "dasdad",
                23,
                "Dalo",
                12,
                "dadadadadadadaad",
                depositStartDate,
                234.67,
                14,
                12.4,
                depositExpirationDate,
                false
        );
        em.persist(wizardDeposits);

        em.getTransaction().commit();
    }
}