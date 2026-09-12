package main.java.string.s_5_practice_problems;

import java.util.*;

public class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;

    // Constructor
    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // CGPA-only eligibility
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // CGPA + coding score eligibility
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    // Composite score
    double getCompositeScore() {
        return cgpa * 10 + codingScore * 0.5;
    }

    // Comparable: descending order
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(),
                              this.getCompositeScore());
    }

    // Shortlist and rank
    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (Candidate c : candidates) {

            if (isEligible(c.cgpa) ||
                isEligible(c.cgpa, c.codingScore)) {

                shortlisted[count] = c;
                count++;
            }
        }

        Candidate[] result = Arrays.copyOf(shortlisted, count);

        Arrays.sort(result);

        String output = "";

        for (int i = 0; i < result.length; i++) {

            output = output + (i + 1) + ". "
                    + result[i].name + " ("
                    + result[i].getCompositeScore() + ")";

            if (i < result.length - 1) {
                output = output + " | ";
            }
        }

        return output;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nCandidate " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.next();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = sc.nextInt();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        System.out.println("\nShortlisted and Ranked:");
        System.out.println(shortlistAndRank(candidates));

        sc.close();
    }
}