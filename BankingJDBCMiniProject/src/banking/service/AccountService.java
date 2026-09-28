package banking.service;

import java.util.List;

import banking.dao.AccountDAO;
import banking.model.Account;

public class AccountService {
	AccountDAO accountDAO = new AccountDAO();
	public void createAccount(Account account) {

        if (account.getBalance() < 0) {

            System.out.println("Balance cannot be negative");
            return;
        }

        accountDAO.createAccount(account);
    }

public void deleteAccount(int accountId) {

    Account account = accountDAO.findAccount(accountId);

    if (account == null) {

        System.out.println("Account does not exist");
        return;
    }

    accountDAO.deleteAccount(accountId);
}
public Account findAccount(int accountId) {

    return accountDAO.findAccount(accountId);
}
public List<Account> viewAllAccounts() {

    return accountDAO.viewAllAccounts();
}
public void deposit(int accountId, double amount) {

    if (amount <= 0) {

        System.out.println("Deposit amount must be greater than zero");
        return;
    }

    Account account = accountDAO.findAccount(accountId);

    if (account == null) {

        System.out.println("Account not found");
        return;
    }

    double newBalance = account.getBalance() + amount;

    account.setBalance(newBalance);

    accountDAO.updateBalance(accountId, newBalance);

    System.out.println("Amount deposited successfully");
}
public void withdraw(int accountId, double amount) {

    if (amount <= 0) {

        System.out.println("Withdrawal amount must be greater than zero");
        return;
    }

    Account account = accountDAO.findAccount(accountId);

    if (account == null) {

        System.out.println("Account not found");
        return;
    }

    if (amount > account.getBalance()) {

        System.out.println("Insufficient balance");
        return;
    }

    double newBalance = account.getBalance() - amount;

    account.setBalance(newBalance);

    accountDAO.updateBalance(accountId, newBalance);

    System.out.println("Amount withdrawn successfully");
}
}