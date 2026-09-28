import java.util.Scanner;
 
class DivideByZeroException extends Exception {
    DivideByZeroException(String message) {
        super(message);
    }
}
 
public class calculator {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        try {
            System.out.print("Enter first number: ");
            double a = Double.parseDouble(sc.nextLine());

            System.out.print("Enter second number: ");
            double b = Double.parseDouble(sc.nextLine());

            System.out.print("Enter operator (+, -, *, /): ");
            char op = sc.nextLine().charAt(0);
            if (op == '/' && b == 0 )
                throw new DivideByZeroException("Cannot divide by zero");
            double result;
            if (op == '+')
                result = a + b;
            else if (op == '-')
                result = a - b;
            else if (op == '*')
                result = a * b;
            else if (op == '/')
                result = a / b;
            else
                throw new Exception("Invalid operator");
            System.out.println("Result = " + result);
        } 
        catch (NumberFormatException e) {
            System.out.println("Invalid number. Try again.");
        } 
        catch (DivideByZeroException e) {
            System.out.println(e.getMessage());
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
 