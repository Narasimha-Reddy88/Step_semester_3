package main.java.string.s_4_assignment_problems;
import java.util.Scanner;

public class MaximumSubarray {

    static int maxSubArray(int[] nums) {
        int current = nums[0];
        int maximum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (current + nums[i] > nums[i])
                current = current + nums[i];
            else
                current = nums[i];

            if (current > maximum)
                maximum = current;
        }

        return maximum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Maximum Subarray Sum = "
                + maxSubArray(nums));

        sc.close();
    }
}
