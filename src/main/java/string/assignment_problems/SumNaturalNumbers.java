package main.java.string.assignment_problems;

import java.util.Scanner;

public class SumNaturalNumbers {

    static int sumNaturalNumbers(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int result = sumNaturalNumbers(n);

        System.out.println("Sum of natural numbers = " + result);

        sc.close();
    }
}