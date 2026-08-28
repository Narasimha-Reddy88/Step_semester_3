package main.java.string.assignment_problems;

import java.util.Scanner;

public class PrintNumbers {

    static void printNumbersUpToN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        printNumbersUpToN(n);

        sc.close();
    }
}