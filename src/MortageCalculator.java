import java.text.NumberFormat;
import java.util.Scanner;

public class MortageCalculator {
    public static void main(String[] args){
        // Principal - how much does the user need to loan
        // same scanner can read multiple inputs
        // System.in what user tupes into terminal
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        // Annual interest rate
        System.out.print("Annual Interest Rate: ");
        float interestRate = scanner.nextFloat();

        // divide by 100 and then 12 to get monthly interest rate
        // converting percent to decimal first

        float monthlyInterest = (interestRate/100) / 12;

        // Period (years)
        System.out.print("Period(years): ");
        int period = scanner.nextInt();

        // multiply period by 12 to get total monthly payments
        int monthlyPeriod = (period * 12);

        //display payment as currency to user
        // present as double, floating pt decimals
        double monthlyPayment = principal * (((monthlyInterest * Math.pow(1 + monthlyInterest, monthlyPeriod) / (Math.pow(1 + monthlyInterest, monthlyPeriod) - 1))));

        System.out.println("Each month, you will be paying " + NumberFormat.getCurrencyInstance().format(monthlyPayment));


    }
}
