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

/* Takeaways from Problem 2239: Find Closest Number to Zero
1. Core Concept
Closest to zero = minimum absolute value

Distance formula: Math.abs(num - 0) = Math.abs(num)

2. Tie-Breaking Rule
When distances are equal (e.g., -1 and 1), return the larger value (positive)

This is why we check: num > closest when currentDist == closestDist

3. Approach Comparison
Aspect	Brute Force	Optimal
Logic	Compare absolute values directly	Same logic
Optimization	None	Early exit if 0 found
Time	O(n)	O(n) - same complexity
Space	O(1)	O(1)
Readability	Simple and clear	Slightly cleaner
4. Two Different Strategies
Strategy 1: Absolute Value Tracking

java
// Track closest distance directly
if (Math.abs(num) < Math.abs(closest)) {
    closest = num;
}
Strategy 2: Separate Positive/Negative

java
// Track closest positive and closest negative separately
// Then compare both at the end
if (minPos > Math.abs(maxNeg)) {
    return maxNeg;  // Negative is closer
}
return minPos;      // Positive wins ties
5. Key Pattern Recognition
This is a linear search with state tracking problem:

Initialize result with first element

Update when a better candidate is found

Handle tie-breaking conditions

6. Common Pitfalls to Avoid
❌ Forgetting the tie-break (return larger value)

❌ Not handling all-negative arrays

❌ Starting closest = Integer.MAX_VALUE without checking first element

❌ Returning maxNeg when no negative exists (maxNeg == Integer.MIN_VALUE)

7. Optimization Insights
Early exit: If 0 exists, it's always the answer (distance = 0)

Memory: O(1) space is optimal - no need for extra arrays

Time: O(n) is the lower bound - you MUST check every element


7. Real-World Applications
Finding nearest value in search algorithms

Recommendation systems (closest match)

Data normalization and scaling

Nearest neighbor searches

8. Final Verdict
Brute force = Optimal for this problem (both O(n))

The "optimal" version is just a cleaner implementation with early exit

Both solutions are accepted with the same time complexity*/