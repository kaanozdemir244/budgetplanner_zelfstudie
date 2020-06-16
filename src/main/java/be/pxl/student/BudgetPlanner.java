package be.pxl.student;

import be.pxl.student.DAO.impli.AccountDao;
import be.pxl.student.DAO.impli.LabelDao;
import be.pxl.student.DAO.impli.PaymentDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BudgetPlanner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("budgetplanner_ZelfStudie_pu");
            entityManager = entityManagerFactory.createEntityManager();

            AccountDao accountDao = new AccountDao(entityManager);
            PaymentDao paymentDao = new PaymentDao(entityManager);
            LabelDao labelDao = new LabelDao(entityManager);


            //implement code here

        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
