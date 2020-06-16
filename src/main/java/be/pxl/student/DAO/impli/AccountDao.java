package be.pxl.student.DAO.impli;

import be.pxl.student.DAO.IAccountDao;
import be.pxl.student.entity.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class AccountDao implements IAccountDao {
    private EntityManager entityManager;

    public AccountDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void removeAccount(Account account) {
        var emptyTranaction = entityManager.getTransaction();
        emptyTranaction.begin();
        entityManager.remove(account);
        emptyTranaction.commit();
    }

    @Override
    public Account findAccountByID(long id) {
        return entityManager.find(Account.class, id);
    }

    @Override
    public List<Account> getAll() {
        return entityManager.createNamedQuery("getAll", Account.class).getResultList();
    }

    @Override
    public Account saveAccount(Account account) {
        var emptyTranaction = entityManager.getTransaction();
        emptyTranaction.begin();
        entityManager.persist(account);
        emptyTranaction.commit();
        return account;
    }

    @Override
    public Account findByName(String name) {
        TypedQuery<Account> accountQuerry = entityManager.createNamedQuery("findByName", Account.class);
        accountQuerry.setParameter("name", name);
        return accountQuerry.getSingleResult();
    }

    @Override
    public Account getByIban(String iban) {
        Account account;
        EntityTransaction transaction = entityManager.getTransaction();
        Logger logger = LogManager.getLogger();
        transaction.begin();

        TypedQuery<Account> query = entityManager.createNamedQuery("account.getByIban", Account.class);
        query.setParameter("iban", iban);
        try {
            account = query.getSingleResult();
        } catch (NoResultException e) {
            account = null;
        }
        transaction.commit();
        return account;
    }

    @Override
    public Account addAccount(Account account) {
        Logger logger = LogManager.getLogger();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        logger.debug(account);

        entityManager.persist(account);

        transaction.commit();

        return account;
    }

    @Override
    public boolean updateAccount(Account account) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.merge(account);

        transaction.commit();

        return true;
    }

    @Override
    public boolean deleteAccount(Account account) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.remove(account);

        transaction.commit();

        return true;
    }
}
