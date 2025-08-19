import java.util.Scanner;

public class EmployeePayCalculator {
    // Program to determine gross pay for employee based on marital status, hours worked, and the number of children
    public static void main(String[] args) {
        Scanner keyb = new Scanner(System.in);

        // Determine marital status
        System.out.println("Enter 0 for single or 1 for married: ");
        int status = keyb.nextInt();

        // Establish base pay
        double basePay = 0.00;
        if (status == 0)
            basePay = 10.0;
        else if (status == 1)
            basePay = 15.0;
        else
            System.out.println("Invalid input!! Please enter 0 for single or 1 for married!");

        // Determine number of children
        System.out.println("Enter the number of children you have: ");
        int children = keyb.nextInt();
        if (children < 0)
            System.out.println("Invalid Input!! Please enter a valid number!");

        // Determine the amount of extra pay
        int extraPay;
        if (children > 4)
            extraPay = 4;
        else
            extraPay = children;

        double hourRate = basePay + extraPay;

        // Ask user for number of hours worked
        System.out.println("Enter the number of hours you worked: ");
        int hours = keyb.nextInt();
        if (hours == 0)
            System.out.println("Invalid Input!! Please enter a valid number!");

        // Calculate total gross pay and print it
        double grossPay;
        if (hours > 40)
            grossPay = (40 * hourRate) + ((hours - 40) * hourRate * 1.5);
        else
            grossPay = hours * hourRate;

        // Calculate income tax
        double taxRate;
        if (grossPay < 300)
            taxRate = 0.0;
        else if (grossPay < 400)
            taxRate = 0.05;
        else if (grossPay < 600)
            taxRate = 0.08;
        else
            taxRate = 0.10;

        double incomeTax = grossPay * taxRate;
        double netPay = grossPay - incomeTax;

        System.out.printf("Your gross pay is: $%.2f\n", grossPay);
        System.out.printf("Your income tax is: $%.2f\n", incomeTax);
        System.out.printf("Your net pay is: $%.2f\n", netPay);

        keyb.close();
    }
}