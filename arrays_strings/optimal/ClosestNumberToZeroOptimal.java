package dsa.arrays_strings.optimal;

import dsa.arrays_strings.brute.ClosestNumberToZeroBrute;

public class ClosestNumberToZeroOptimal {

    public int findClosestNumber(int[] nums) {
        // Track the closest number seen so far
        int closest = nums[0];

        for (int num : nums) {
            // Early exit - can't get closer than 0
            if (num == 0) return 0;

            int currentDist = Math.abs(num);
            int closestDist = Math.abs(closest);

            // Update if current is closer, or if tied and current is larger
            if (currentDist < closestDist ||
                    (currentDist == closestDist && num > closest)) {
                closest = num;
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        ClosestNumberToZeroOptimal solution = new ClosestNumberToZeroOptimal();

        int[] nums = {-4, -2, 1, 4, 8};

        System.out.println("Closest number to zero: " + solution.findClosestNumber(nums));
    }


//alternative approach:
class Solution {
    public int findClosestNumber(int[] nums) {
        int minPos = Integer.MAX_VALUE;
        int maxNeg = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i == 0) return 0;
            if (i < 0) {
                maxNeg = Math.max(i, maxNeg);
            } else {
                minPos = Math.min(i, minPos);
            }
        }

        if (minPos > Math.abs(maxNeg) && maxNeg != Integer.MIN_VALUE) {
            return maxNeg;
        }

        return minPos;
    }
}
}
