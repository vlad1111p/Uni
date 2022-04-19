package services;

import dao.GenericDao;
import model.Account;

public class AccountService {
    GenericDao<Account> accountGenericDao = new GenericDao<>();

    public void addAccount(Account account)
    {
        accountGenericDao.add(account);
    }
}
