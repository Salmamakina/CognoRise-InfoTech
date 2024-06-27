import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
                try {
                    System.out.printf("Enter the first number: ");
                    double num1 = scanner.nextDouble();
                    System.out.printf("Enter the second number: ");
                    double num2 = scanner.nextDouble();
                    System.out.printf("Enter the operator: ");
                    char operator = scanner.next().charAt(0);
                    double result;

                    switch (operator) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case '*':
                            result = num1 * num2;
                            break;
                        case '/':
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                throw new ArithmeticException("Division by zero !");
                            }
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid operator !");

                    }
                    System.out.printf("The result is :" + result);
                    validInput = true;
                } catch (ArithmeticException e) {
                    System.out.printf("Error: ", e.getMessage());
                    scanner.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.printf("Error: ", e.getMessage());
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.printf("Error: An unexpected error occurred.");
                    scanner.nextLine();
                }
        }

    }
}
