package banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import banking.util.DBConnection;
import banking.model.Account;

public class AccountDAO {

    public void createAccount(Account account) {

        String sql = "INSERT INTO account "
                   + "(account_holder, phone, account_type, balance) "
                   + "VALUES (?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, account.getAccountHolder());
            ps.setString(2, account.getPhone());
            ps.setString(3, account.getAccountType());
            ps.setDouble(4, account.getBalance());

            ps.executeUpdate();

            System.out.println("Account created successfully");

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }



//Add this method below createAccount()

public void deleteAccount(int accountId) {

    String sql = "DELETE FROM account WHERE account_id = ?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, accountId);

        int result = ps.executeUpdate();

        if (result > 0) {
            System.out.println("Account deleted successfully");
        } else {
            System.out.println("Account not found");
        }

        con.close();

    } catch (Exception e) {

        e.printStackTrace();
    }
}


//Find account() method

public Account findAccount(int accountId) {

    String sql = "SELECT * FROM account WHERE account_id = ?";

    Account account = null;

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, accountId);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            account = new Account();

            account.setAccountId(rs.getInt("account_id"));
            account.setAccountHolder(rs.getString("account_holder"));
            account.setPhone(rs.getString("phone"));
            account.setAccountType(rs.getString("account_type"));
            account.setBalance(rs.getDouble("balance"));
        }

        con.close();

    } catch (Exception e) {

        e.printStackTrace();
    }

    return account;
}


//View all accounts

public List<Account> viewAllAccounts() {

    String sql = "SELECT * FROM account";

    List<Account> accounts = new ArrayList<>();

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Account account = new Account();

            account.setAccountId(rs.getInt("account_id"));
            account.setAccountHolder(rs.getString("account_holder"));
            account.setPhone(rs.getString("phone"));
            account.setAccountType(rs.getString("account_type"));
            account.setBalance(rs.getDouble("balance"));

            accounts.add(account);
        }

        con.close();

    } catch (Exception e) {

        e.printStackTrace();
    }

    return accounts;
}


//Update Balance

public void updateBalance(int accountId, double balance) {

    String sql = "UPDATE account SET balance = ? WHERE account_id = ?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDouble(1, balance);
        ps.setInt(2, accountId);

        ps.executeUpdate();

        con.close();

    } catch (Exception e) {

        e.printStackTrace();
    }
}
}