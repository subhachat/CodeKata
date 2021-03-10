package algorithms.euclidgcd;

import java.util.Scanner;

public class FindGCDOfTwoPositiveNumber {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number (positive) ->");
        long firstNumber = scanner.nextLong(); // storing as Long to be safe
        System.out.println("Enter second number (positive) ->");
        long secondNumber = scanner.nextLong(); // storing as Long to be safe

        if (firstNumber < 0 || secondNumber < 0) {
            throw new NumberFormatException("Only Positive numbers are allowed!!!");
        }

        long gcdValue = findGCD(firstNumber, secondNumber);
        System.out.println("The GCD of {" + firstNumber + ", " + secondNumber + "} is " + gcdValue);
    }

    private static long findGCD(long number1, long number2) {
        long remainder;
        if (number1 == number2) {
            return number1;
        } else if (number1 > number2) {
            remainder = (long) number1 % number2;
            if (remainder == 0) {
                return number2;
            } else {
                return findGCD(number2, remainder);
            }
        } else { // number2 is the larger
            remainder = (long) number2 % number1;
            if (remainder == 0) {
                return number1;
            } else {
                return findGCD(number1, remainder);
            }
        }
    }
}
