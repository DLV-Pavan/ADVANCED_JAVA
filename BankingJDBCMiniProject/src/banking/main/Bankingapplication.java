package banking.main;

import java.util.List;
import java.util.Scanner;

import banking.model.Account;
import banking.service.AccountService;

public class Bankingapplication {
	public static void main(String[] args) {
        AccountService service = new AccountService();
        //Account account = new Account();

        //account.setAccountHolder("Suresh");
        //account.setPhone("9876543212");
        //account.setAccountType("Savings");
        //account.setBalance(8000);

        //service.createAccount(account);
        
       // Account account = service.findAccount(1);

        //if (account != null) {
        //    System.out.println(account);
        //} else {
         //   System.out.println("Account not found");
        //}
        
       // List<Account> accounts = service.viewAllAccounts();

       // for (Account account : accounts) {

         //   System.out.println(account);
        
       // service.deposit(1, 2000);
        
        // service.withdraw(1, 1000);
        
       // service.deleteAccount(3);
        
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Find Account");
            System.out.println("4. View All Accounts");
            System.out.println("5. Deposit Money");
            System.out.println("6. Withdraw Money");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            
            if (choice == 1) {

                System.out.print("Enter account holder name: ");
                String name = sc.next();

                System.out.print("Enter phone: ");
                String phone = sc.next();

                System.out.print("Enter account type: ");
                String type = sc.next();

                System.out.print("Enter initial balance: ");
                double balance = sc.nextDouble();

                Account account = new Account();

                account.setAccountHolder(name);
                account.setPhone(phone);
                account.setAccountType(type);
                account.setBalance(balance);

                service.createAccount(account);
            }

            if (choice == 7) {
                System.out.println("Thank you for using Banking System");
                break;
            }
        }
    }
}

       

