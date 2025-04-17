import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // create account
        BankAccount[] accounts = {
            new BankAccount(),
            new BankAccount()
        };
        accounts[0].setId(1);
        accounts[0].setName("Bill");
        accounts[1].setId(2);
        accounts[1].setName("Jill");

        System.out.println("Welcome to the CM111 Bank Teller App!");
        while(true) {
            System.out.println("Options: ");
            System.out.println(" 1) get balance");
            System.out.println(" 2) make deposit");
            System.out.println(" 3) make withdraw");
            System.out.println(" 9) quit");

            System.out.print("Choose an option: ");

            int choice = input.nextInt();
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
                    System.exit(1);
                    break;
                default:
                    System.out.println("Unrecognized command");
            }
        }
    }
}