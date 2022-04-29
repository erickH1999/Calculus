// Author: Erick Huerta


/*
 * Your assignment is to write some code that provides the derivative of a polynomial in the
 * standard form of f(x) = ax^2 + bx + c
 **/
import java.util.Scanner;


class Process {

  public Process() {

  }

  // This method is supposed to return f(x)
  public double quadratic(double a, double b, double c, double x) {

    // Use Math.pow() method for any powers in the method.
    // quadTotal is the value that will be returned to the main method!!
    double quadTotal = a * Math.pow(x, 2);
    quadTotal += b * x;
    quadTotal += c;

    return quadTotal;
  }



  // This method is supposed to return the derivative of f(x)
  public double derivative(double a, double b, double c, double x, double deltaX) {

    // derivTotal will act the same as quadTotal!!
    double derivTotal = quadratic(a, b, c, x + deltaX);
    derivTotal -= quadratic(a, b, c, x);
    derivTotal /= deltaX;

    return derivTotal;
  }


}


public class Calculus {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner scan = new Scanner(System.in);

    Process output = new Process();

    // System.out.println("Enter first number to add: ");
    // int numberEntered = Integer.parseInt(scan.nextLine());
    // code.add(numberEntered);

    // System.out.println("Make sure the numbers are seperated by a space!!");
    System.out.println("Enter the values for a, b, c, and x: ");
    double a = Double.parseDouble(scan.nextLine());
    double b = Double.parseDouble(scan.nextLine());
    double c = Double.parseDouble(scan.nextLine());
    double x = Double.parseDouble(scan.nextLine());
    output.quadratic(a, b, c, x);
    System.out.println(
        "The quadratic formula for the numbers you have entered: " + output.quadratic(a, b, c, x));

    // Pass the collected values off the the derivative method as well:
    // Delta x is what "h" is in the limit formula.
    // System.out.println("Enter the value for delta X: ");
    // double deltaX = Double.parseDouble(scan.nextLine());
    // instead just hard code delta x to a value like 1 for simplicity

    double deltaX = 1;
    output.derivative(a, b, c, x, deltaX);

    System.out.println("For tolerance, specify the amount of decimals needed for the final answer");
    System.out.println("enter the total tolerance: ");
    double tolerance = Double.parseDouble(scan.nextLine());

    while (output.derivative(a, b, c, x, deltaX)
        - output.derivative(a, b, c, x, deltaX * 0.9) >= tolerance) {
      deltaX *= 0.9;
    }
    double result = Math.round(output.derivative(a, b, c, x, deltaX) / tolerance) * tolerance;
    System.out.println("The derivative of the formula you have entered is: " + result);



    // take notes on how buggy code sends its user inputs off to be processed in their respective
    // methods. (parsing each double off the the method to be processed.


    // Create a test harness for both methods quadratic and derivative
    /*
     * Two test cases for quadratic, using different values for a,b,c,x to compare to the correct
     * value of f(x)
     * Two test cases for derivative (deltaX)
     * NOTE: you’ll need to write your own equals method for doubles, which verifies they
     * match within 6 decimal places
     **/

    // Test Harness for quadratic and derivative
    double quadTest1 = output.quadratic(12, 15, 16, 17);
    double quadTest2 = output.quadratic(12, 45, 67, 34);
    System.out.println("To test quadratic : " + quadTest1 + " " + quadTest2);

    // Just hardcode the values in the declaration of testResult as .0001
    // double ToleranceTest = .0001;

    double quadDeriv1 = output.derivative(12, 15, 16, 87, 1);
    double quadDeriv2 = output.derivative(12, 45, 77, 54, 1);

    System.out.println("To test derivative: " + quadDeriv1 + " " + quadDeriv2);

    // Loop to test the derivative method with hardcoded values:

    /**
     * while (output.derivative(12, 15, 16, 87, 1)
     * - output.derivative(12, 15, 16, 87, 1 * 0.9) >= .0001) {
     * deltaX *= 0.9;
     * }
     * double testResult = Math.round(output.derivative(a, b, c, x, deltaX) / .0001) * .0001;
     * System.out.println("To test derivative: " + testResult);
     **/
  }

}
