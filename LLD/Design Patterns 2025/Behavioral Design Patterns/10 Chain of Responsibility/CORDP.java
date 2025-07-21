/**
 * 
 * Chain of Responsibility Design Pattern
 * This pattern allows an object to pass a request along a chain of potential handlers until one of them handles the request.
 * In this example, we have different types of accounts that can handle payment requests.
 * Each account checks if it can pay the requested amount, and if not, it passes the request to the next account in the chain.
 * 
 */


abstract class Account
{
    protected Account successor;
    protected double balance;

    public void setNext(Account successor)
    {
        this.successor = successor;
    }

    public void pay(double amount)
    {
        if (canPay(amount))
        {
            balance -= amount;
            System.out.println("Paid " + amount + " from " + this.getClass().getSimpleName());
        }
        else if (successor != null)
        {
            System.out.println("Cannot pay " + amount + " from " + this.getClass().getSimpleName() + ", passing to next account.");
            successor.pay(amount);
        }
        else
        {
            System.out.println("No account can pay " + amount);
        }
    }

    public boolean canPay(double amount)
    {
        return balance >= amount;
    }

}

class BankAccount extends Account
{
    public BankAccount(double initialBalance)
    {
        this.balance = initialBalance;
    }
}

class payPalAccount extends Account
{
    public payPalAccount(double initialBalance)
    {
        this.balance = initialBalance;
    }
}

class CreditCardAccount extends Account
{
    public CreditCardAccount(double initialBalance)
    {
        this.balance = initialBalance;
    }
}

public class CORDP
{
    public static void main(String[] args)
    {
        Account bankAccount = new BankAccount(100);
        Account payPalAccount = new payPalAccount(50);
        Account creditCardAccount = new CreditCardAccount(200);

        bankAccount.setNext(payPalAccount);
        payPalAccount.setNext(creditCardAccount);

        System.out.println("Attempting to pay 120:");
        bankAccount.pay(120);

        System.out.println("\nAttempting to pay 30:");
        bankAccount.pay(30);

        System.out.println("\nAttempting to pay 250:");
        bankAccount.pay(250);
    }
}