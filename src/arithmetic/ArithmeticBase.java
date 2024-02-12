package arithmetic;

import java.util.Scanner;

enum Operation {
    PLUS,
    MINUS,
    TIMES,
    DIVIDE
}

public class ArithmeticBase {

    public double calculate(double x, double y, Operation op) {
        switch (op) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                if (y != 0) {
                    return x / y;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new AssertionError("Unknown operation: " + op);
        }
    }

    public static void main(String[] args) {
        ArithmeticBase calculator = new ArithmeticBase();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers:");
        double x = sc.nextDouble();
        double y = sc.nextDouble();

        System.out.println("Enter arithmetic operation to Perform (PLUS, MINUS, TIMES, DIVIDE): ");
        String operationStr = sc.next().toUpperCase();

        try {
            Operation operation = Operation.valueOf(operationStr);
            double result = calculator.calculate(x, y, operation);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid operation");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
