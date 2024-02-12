package arithmetic;

import java.util.Scanner;

public class Arithmetic {

    public enum Operation {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        
        for (Operation op : Operation.values()) {
            double result = performOperation(num1, num2, op);
            System.out.println("Result of " + op + ": " + result);
        }
    }

    public static double performOperation(int num1, int num2, Operation operation) {
        switch (operation) {
            case ADDITION:
                return num1 + num2;
            case SUBTRACTION:
                return num1 - num2;
            case MULTIPLICATION:
                return num1 * num2;
            case DIVISION:
                if (num2 == 0) {
                    System.out.println("Error: Division by zero");
                    return Double.NaN;
                } else {
                    return (double) num1 / num2;
                }
            default:
                System.out.println("Invalid operation");
                return Double.NaN;
        }
    }
}
