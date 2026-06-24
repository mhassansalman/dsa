//2239
// My initial thinking: minimum absolute value is closest to 0.
// Compare absolute values of each number. Track smallest distance. On tie, pick positive.
package dsa.arrays_strings.brute;
public class ClosestNumberToZeroBrute {

    public int findClosestNumber(int[] nums) {
        int closest = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i]) < Math.abs(closest)) {
                closest = nums[i];
            } else if (Math.abs(nums[i]) == Math.abs(closest) && nums[i] > closest) {
                closest = nums[i];
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        ClosestNumberToZeroBrute solution = new ClosestNumberToZeroBrute();

        int[] nums = {-4, -2, 1, 4, 8};

        System.out.println("Closest number to zero: " + solution.findClosestNumber(nums));
    }
}