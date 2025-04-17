public class BankAccount {
    private double balance;
    private String name;
    private int id;

    public void deposit(double amount) {
        balance += amount; 
    }

    public void withdraw(double amount) {
        balance -= amount; 
    }

    public int getId() {
        return id;
    }

    public void setId(int newId) {
        id = newId;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public double getBalance() {
        return balance;
    }

    public String toString() {
        return id + "," + name + "," + balance;
    }
}
