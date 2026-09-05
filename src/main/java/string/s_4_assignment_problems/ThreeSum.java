package main.java.string.s_4_assignment_problems;
import java.util.Arrays;
import java.util.Scanner;

public class ThreeSum {

    static int[][] threeSum(int[] nums) {

        Arrays.sort(nums);

        int count = 0;

        // First find number of triplets
        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    count++;

                    int lvalue = nums[left];
                    int rvalue = nums[right];

                    while (left < right && nums[left] == lvalue)
                        left++;

                    while (left < right && nums[right] == rvalue)
                        right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }

        // Create result array
        int[][] result = new int[count][3];

        int index = 0;

        // Find triplets again
        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result[index][0] = nums[i];
                    result[index][1] = nums[left];
                    result[index][2] = nums[right];
                    index++;

                    int lvalue = nums[left];
                    int rvalue = nums[right];

                    while (left < right && nums[left] == lvalue)
                        left++;

                    while (left < right && nums[right] == rvalue)
                        right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }

        return result;
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

        int[][] result = threeSum(nums);

        System.out.println("Output:");

        for (int i = 0; i < result.length; i++) {
            System.out.println(
                "[" + result[i][0] + ", "
                + result[i][1] + ", "
                + result[i][2] + "]"
            );
        }

        sc.close();
    }
}