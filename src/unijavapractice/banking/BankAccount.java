package unijavapractice.banking;

public class BankAccount {
    private Person customer;
    private int balance;

    public BankAccount(Person customer) {
        this.customer = customer;
        balance = 0;
    }

    
    //-/ Gets
    public int getBalance() { return balance; }
    
    public Person getCustomer() { return customer; }


    //-/ Methods
    public void withdraw(int amount) {
        if (amount <= 0)
            return;
        if ((balance - amount) >= 0)
            balance -= amount;
    }

    public void deposit(int amount) {
        if (amount > 0)
            balance += amount;
    }

    public void transfer(BankAccount account, int amount) {
        // Check for sufficient funds
        if ((balance - amount) < 0)
            return; // Insufficient funds
        
        // Transfer amount
        withdraw(amount);
        account.deposit(amount);
    }

    public String toString() {
        return customer.toString() + "\n"
             + "Balance = " + balance;
    }
}
