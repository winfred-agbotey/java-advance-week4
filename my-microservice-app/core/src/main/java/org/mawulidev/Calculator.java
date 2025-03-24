package org.mawulidev;

public class Calculator {

    // Predefined numbers and operations from data access module
    static double first = SampleDataBase.getFirstNumber();
    static double second = SampleDataBase.getSecondNumber();


    public static void execute() {

        // Perform operations
        double sum = first + second;
        double difference = first - second;
        double product = first * second;
        double quotient = first / second;

        //results
        System.out.println("Simple Calculator Results:");
        System.out.println("Addition: " + first + " + " + second + " = " + sum);
        System.out.println("Subtraction: " + first + " - " + second + " = " + difference);
        System.out.println("Multiplication: " + first + " * " + second + " = " + product);
        System.out.println("Division: " + first + " / " + second + " = " + quotient);
    }
}
