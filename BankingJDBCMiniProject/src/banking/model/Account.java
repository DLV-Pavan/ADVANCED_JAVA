package banking.model;

public class Account {

    private int accountId;
    private String accountHolder;
    private String phone;
    private String accountType;
    private double balance;

    public Account() {
    }

    public Account(int accountId, String accountHolder, String phone,
                   String accountType, double balance) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.phone = phone;
        this.accountType = accountType;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account ID: " + accountId
                + ", Holder: " + accountHolder
                + ", Phone: " + phone
                + ", Type: " + accountType
                + ", Balance: " + balance;
    }
}
