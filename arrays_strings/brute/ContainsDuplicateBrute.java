package dsa.arrays_strings.brute;

import java.util.Arrays;

public class ContainsDuplicateBrute {

    // Initial Thinking:
    // Brute 1: Nested loop - check each element against every other element
    // Brute 2: Sort first, then duplicates will be adjacent, check i and i+1

    // Brute 1: Nested Loop O(n^2)
    public static boolean containsDuplicateNestedLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    // Brute 2: Sort + Adjacent Check O(n log n)
    public static boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 1};
        int[] test2 = {1, 2, 3, 4};

        System.out.println("Nested Loop:");
        System.out.println(containsDuplicateNestedLoop(test1)); // true
        System.out.println(containsDuplicateNestedLoop(test2)); // false

        System.out.println("Sort:");
        System.out.println(containsDuplicateSort(test1)); // true
        System.out.println(containsDuplicateSort(test2)); // false
    }
}