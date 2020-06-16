package be.pxl.student.DAO;

import be.pxl.student.entity.Account;

import java.util.List;

public interface IAccountDao {
    void removeAccount(Account account);
    Account findAccountByID(long id);
    List<Account> getAll();
    Account saveAccount(Account account);
    Account getByIban(String iban);
    Account findByName(String name);
    Account addAccount(Account account);
    boolean updateAccount(Account account);
    boolean deleteAccount(Account account);
}
