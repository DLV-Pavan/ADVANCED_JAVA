package banking.main;

import banking.dao.AccountDAO;
import banking.model.Account;

public class TestAccountDAO {

    public static void main(String[] args) {

        Account account = new Account();

        account.setAccountHolder("Ravi");
        account.setPhone("9876543211");
        account.setAccountType("Savings");
        account.setBalance(10000);

        AccountDAO dao = new AccountDAO();

        dao.createAccount(account);
    }
}