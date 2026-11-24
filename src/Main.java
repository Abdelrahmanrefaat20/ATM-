
import java.util.Scanner;

void main() {

    Scanner input = new Scanner(System.in);

    int attempts = 0;

    System.out.println("========= ATM =========");

    while (attempts < 3) {

        System.out.print("Please enter a 4-digit PIN:");
        int pin = input.nextInt();

        if (pin == 1234) {
            System.out.println("Login successful!");
            break;
        } else {
            attempts++;
            System.out.println("Your PIN is incorrect.");
        }
        if (attempts == 3) {
            System.out.println("Your account has been locked.");
            return;
        }

    }
    int option;
    int transactions = 0;

    double balance = 2500.75;
    double amount;


    do {
        System.out.println();
        System.out.println("========= ATM =========");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Show Account Status");
        System.out.println("5. Exit");
        System.out.println("=======================");
        System.out.print("Choose an option: ");

        option = input.nextInt();
        switch (option) {
            case 1:
                System.out.println("Current balance: " + balance);
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                amount = input.nextDouble();
                if (amount > 0) {
                    balance += amount;
                    transactions++;

                    System.out.println("Deposit successful.");
                    System.out.println("New balance: " + balance);

                } else {
                    System.out.println("Invalid amount.");
                }
                break;
            case 3:
                System.out.print("Enter withdrawal amount: ");
                amount = input.nextDouble();
                if (amount == 0) {
                    System.out.println("Transaction cancelled.");
                } else if (amount < 0) {
                    System.out.println("Invalid amount.");
                } else if (amount > balance) {
                    System.out.println("Insufficient balance.");
                } else {
                    balance -= amount;
                    transactions++;

                    System.out.println("Withdrawal successful.");
                    System.out.println("New balance: " + balance);

                    if (balance == 0) {
                        System.out.println("Warning: Your account is empty.");
                    }
                }
                break;
                case 4:
                    if (balance >=5000) {
                        System.out.println("VIP Customer");
                    } else if (balance>=1000) {
                        System.out.println("Regular Customer");
                    }else{
                        System.out.println("Low Balance");
                    }
                    break;
                    case 5:
                        System.out.println("Thank you for using our ATM.");
                        System.out.println("Total successful transactions: " + transactions);
                        break;

            default:
                System.out.println("'Invalid option.'");
        }
    } while (option != 5);


    input.close();
}
