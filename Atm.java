package atmInterface;
import java.util.*;

public class Atm 
{
    private int balance;
    private int pin;

    public Atm(int balance, int pin) 
    {
        this.balance = balance;
        this.pin = pin;
    }

    public boolean pinValidate(int pin) 
    {
        return this.pin == pin;
    }

    public void displayMenu() 
    {
        System.out.println("Select an option:");
        System.out.println("1 - Check Balance");
        System.out.println("2 - Deposit Funds");
        System.out.println("3 - Withdraw Funds");
        System.out.println("4 - Exit");
    }

    public void checkBalance() 
    {
        System.out.println("Your available balance is: " + this.balance);
    }

    public void depositBalance(int amount) 
    {
        if (amount > 0) 
        {
            this.balance += amount;
            System.out.println("Deposit successful! Your new balance is: " + this.balance);
        } 
        else 
        {
            System.err.println("Invalid amount. Please enter a positive value.");
        }
    }

    public void withdrawBalance(int amount) 
    {
        if (amount > 0) 
        {
            if (amount <= this.balance) 
            {
                this.balance -= amount;
                System.out.println("Withdrawal successful! Your new balance is: " + this.balance);
            } 
            else 
            {
                System.err.println("Insufficient funds. Please enter an amount within your balance.");
            }
        } 
        else 
        {
            System.err.println("Invalid amount. Please enter a positive value.");
        }
    }

    public void startAtm() 
    {
        Scanner sc = new Scanner(System.in);
        int attempts = 0;
        final int maxAttempts = 3;
        System.out.println("Welcome to the ATM.");

        while (attempts < maxAttempts) 
        {
            System.out.print("Enter your 4-digit UPI PIN: ");
            int inputPin = sc.nextInt();

            if (pinValidate(inputPin)) 
            {
                System.out.println("Welcome to the ATM!");
                while (true) 
                {
                    displayMenu();
                    System.out.print("Your choice: ");
                    int choice = sc.nextInt();

                    switch (choice) 
                    {
                        case 1:
                            checkBalance();
                            break;

                        case 2:
                            System.out.print("Enter the amount to deposit: ");
                            int depositAmount = sc.nextInt();
                            depositBalance(depositAmount);
                            break;

                        case 3:
                            System.out.print("Enter the amount to withdraw: ");
                            int withdrawAmount = sc.nextInt();
                            withdrawBalance(withdrawAmount);
                            break;

                        case 4:
                            System.out.println("Thank you for using the ATM. Have a great day.");
                            sc.close();
                            System.exit(0);

                        default:
                            System.err.println("Invalid choice. Please select a valid option.");
                    }
                }
            } 
            else 
            {
                attempts++;
                System.err.println("Incorrect PIN. You have " + (maxAttempts - attempts) + " attempts remaining.");
            }
        }

        System.err.println("Too many incorrect attempts. Your account has been locked.");
        sc.close();
    }

    public static void main(String[] args) 
    {
        Atm user = new Atm(5000, 2299); 
        user.startAtm();
    }
}
