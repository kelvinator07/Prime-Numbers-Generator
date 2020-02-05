package com.geekykel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PrimeNumbersGenerator {

    public static void main(String[] args) {
        // write your code here
        System.out.println("This Program Generates Prime Numbers Based on User Values.\n");
        int startValue = 0, stopValue = 0;
        boolean numberFormat = true;

        while (numberFormat) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the start value: ");
            if (scanner.hasNextInt()) {
                startValue = scanner.nextInt();
                while (startValue < 1) {
                    System.out.println("Start Value must be greater than Zero");
                    System.out.print("Enter the start value: ");
                    startValue = scanner.nextInt();
                }
                numberFormat = false;
            } else {
                System.out.print("Only digits 0-9 are allowed\n");
                numberFormat = true;
            }
        }

        boolean numberFormat2 = true;

        while (numberFormat2) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the stop value: ");
            if (scanner.hasNextInt()) {
                stopValue = scanner.nextInt();
                while (stopValue < 1 || stopValue <= startValue) {
                    System.out.println("Stop Value must be greater than Zero or Start Value");
                    System.out.print("Enter the stop value: ");
                    stopValue = scanner.nextInt();
                }
                numberFormat2 = false;
//                scanner.close();
            } else {
                System.out.print("Only digits 0-9 are allowed\n");
                numberFormat2 = true;
            }
        }

        System.out.println("\n=============================");


        int selection = 1;
        boolean valid = false;


        Scanner scanner2 = new Scanner(System.in);

        while (!valid) {

            System.out.print("Select 1 for BruteForce or 2 for Sieve Algorithm:  ");
            try {
                selection = scanner2.nextInt();
                if (selection == 1 || selection == 2) {
                    valid = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Not a valid number.");
                scanner2.next();
            }
        }

        switch (selection) {
            case 1:
                bruteForce();
                break;
            case 2:
                seivePrime();
                break;
        }


        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = startValue; i <= stopValue; i++) {
            if (numberIsAPrime(i)) {
                primeNumbers.add(i);
            }
        }

        System.out.printf("\nThe Prime Numbers Between %d and %d are:  ", startValue, stopValue);
        for (Integer number : primeNumbers) {
            System.out.format("%s\t", number);
        }

        System.out.println();
        System.out.println("Total Prime Numbers is: " + primeNumbers.size());
    }


    private static boolean numberIsAPrime(int number) {
        // skip number 1
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean numberIsValid(String number) {
        String regex = "\\d";
        boolean flag;

        flag = number.matches(regex);

        if (!flag && Integer.parseInt(number) < 1) {
            return false;
        } else {
            return true;
        }

    }

    private static boolean seivePrime() {
        System.out.println("Seive Algorithm ");
        return true;
    }

    private static boolean bruteForce() {
        System.out.println("BruteForce Approach");
        return true;
    }
}
