package unijavapractice.banking;

public class BankAccount {
    private Person customer;
    private int balance;

    public BankAccount(Person customer) {
        this.customer = customer;
        balance = 0;
    }

    
    //-/ Gets
    // Retrieves the current account balance.
    public int getBalance() { return balance; }
    
    // Retrieves the account holder for this bank account.
    public Person getCustomer() { return customer; }


    //-/ Methods
    // Withdraw {amount} from bank account.
    //     {amount} cannot be negative.
    //     The withdrawal is aborted if the current account has insufficient funds.
    public void withdraw(int amount) {
        if (amount <= 0)
            return; // Cannot withdraw a negative amount
        
        // Check for sufficient funds
        if ((balance - amount) >= 0)
            balance -= amount;
    }

    // Deposits {amount} into bank account.
    //     {amount} cannot be negative.
    public void deposit(int amount) {
        if (amount > 0)
            balance += amount;
    }

    // Transfer {amount} from current account to {account}.
    //     {amount} cannot be negative.
    //     The transfer is aborted if the current account has insufficient funds.
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
