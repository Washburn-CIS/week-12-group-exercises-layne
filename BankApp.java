import java.util.*;
import java.io.*;


public class BankApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // create account
        Scanner fin = null;
        try {
            fin = new Scanner(new File("bank.txt"));
        } catch(FileNotFoundException e) {
            System.out.println("bank data not here!");
        }
        int numAccounts = Integer.parseInt(fin.nextLine());  // determine number of records
        BankAccount[] accounts = new BankAccount[numAccounts];
        for(int i=0; i<numAccounts; i++) {
            String[] tokens = fin.nextLine().split(",");
            accounts[i] = new BankAccount();
            accounts[i].setId(Integer.parseInt(tokens[0]));
            accounts[i].setName(tokens[1]);
            accounts[i].deposit(Double.parseDouble(tokens[2]));
        }

        System.out.println("Welcome to the CM111 Bank Teller App!");
        while(true) {
            System.out.println("Options: ");
            System.out.println(" 1) get balance");
            System.out.println(" 2) make deposit");
            System.out.println(" 3) make withdraw");
            System.out.println(" 9) quit");

            System.out.print("Choose an option: ");
            int choice = -1;  // default to invalid selection
            try {
                choice = input.nextInt();
            } catch(InputMismatchException e) {
                input.nextLine();    // burn bad input
                // defer to default case in switch
            }
            switch(choice) {
                case 1:{
                    System.out.print("Enter account number: ");
                    int id = input.nextInt();
                    System.out.printf("Account #%d has balance: %f%n", 
                           id-1, accounts[id-1].getBalance());
                    break;
                }
                case 2: {
                    System.out.print("Enter account number: ");
                    int id = input.nextInt();
                    System.out.print("Enter amount: ");
                    double amount = input.nextDouble();
                    accounts[id-1].deposit(amount);
                    System.out.println("done");
                    break;
                }
                case 3:{
                    System.out.print("Enter account number: ");
                    int id = input.nextInt();
                    System.out.print("Enter amount: ");
                    double amount = input.nextDouble();
                    accounts[id-1].withdraw(amount);
                    System.out.println("done");
                    break;
                }
                case 9:
                    System.out.println("Bye!");
                    try {
                        PrintWriter fout = new PrintWriter(new File("bank.txt"));
                        fout.println(accounts.length);  // store number of accounts on line 1
                        for(BankAccount account : accounts) {
                            fout.println(account.toString());
                        }
                        
                        fout.close();
                    } catch(FileNotFoundException e) {
                        System.out.println("Error writing to file");
                    }
                    System.exit(1);
                    break;
                default:
                    System.out.println("Unrecognized command");
            }
        }
    }
}
