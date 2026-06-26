package dsa.arrays_strings.optimal;

import java.util.HashMap;
import java.util.Map;

public class TwoSumOptimal {

    // Initial Thinking:
    // Take current element x, calculate complement = target - x
    // Put x in map with its index
    // If complement already exists in map -> that's the pair
    // One pass: check first, then store

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result[0] + ", " + result[1]); // 0, 1
    }
}

/*Takeaways for Two Sum
1. Core Problem

Find two indices whose values sum to target

Exactly one solution exists

2. Two Approaches

Approach	Time	Space	Method
Brute Force	O(n²)	O(1)	Check every pair
HashMap	O(n)	O(n)	Store complement in map
3. Key Insight

For each number x, complement = target - x

If complement exists in map → found the pair

Check first, then store (avoid using same element twice)

4. Hashmap Pattern

text
For each num:
    complement = target - num
    if complement in map → return {map.get(complement), i}
    map.put(num, i)
5. Edge Cases

Duplicate values → works because checking before storing

Negative numbers → works fine

No solution → return empty array

6. Trade-offs

HashMap: Fastest O(n), but extra memory

Brute Force: No memory, but slow O(n²)

7. When to Use

HashMap is almost always better for this problem*/