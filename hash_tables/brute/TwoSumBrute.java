package dsa.arrays_strings.brute;

public class TwoSumBrute {

    // Initial Thinking:
    // Check every pair of elements, if they sum to target return their indices
    // Nested loop: fix i, check all j ahead of it

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result[0] + ", " + result[1]); // 0, 1
    }
}