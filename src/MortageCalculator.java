import java.text.NumberFormat;
import java.util.Scanner;

public class MortageCalculator {
    public static void main(String[] args){
        // Principal - how much does the user need to loan
        // same scanner can read multiple inputs
        // System.in what user tupes into terminal
        Scanner scanner = new Scanner(System.in);
        // Range for Principal $1,000 - $ 1M
        int principal;
        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal > 1000 && principal <= 1000000)
                break;
            System.out.print("Enter a value between $1000 and $1,000,000");
        }
        // Annual interest rate
        float interestRate;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            interestRate = scanner.nextFloat();
            if (interestRate > 0 && interestRate <= 30)
                break;
            System.out.println("Enter an interest rate between 0 and 30");
        }

        // divide by 100 and then 12 to get monthly interest rate
        // converting percent to decimal first

        float monthlyInterest = (interestRate/100) / 12;

        // Period (years)
        int period;
        while (true) {
            System.out.print("Period(years): ");
            period = scanner.nextInt();
            if (period > 0 && period <= 30)
                break;
            System.out.println("Please enter a value between 0 and 30.");
        }


        // multiply period by 12 to get total monthly payments
        int monthlyPeriod = (period * 12);

        //display payment as currency to user
        // present as double, floating pt decimals
        double monthlyPayment = principal * (((monthlyInterest * Math.pow(1 + monthlyInterest, monthlyPeriod) / (Math.pow(1 + monthlyInterest, monthlyPeriod) - 1))));

        System.out.println("Each month, you will be paying " + NumberFormat.getCurrencyInstance().format(monthlyPayment));


    }
}
