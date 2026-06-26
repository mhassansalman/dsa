package dsa.arrays_strings.optimal;

import java.util.HashSet;

public class ContainsDuplicateOptimal {

    // Optimal: HashSet O(n) time, O(n) space
    // Add elements to set, if already present -> duplicate found
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true; // add() returns false if already present
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 1};
        int[] test2 = {1, 2, 3, 4};

        System.out.println(containsDuplicate(test1)); // true
        System.out.println(containsDuplicate(test2)); // false
    }
}

/*Takeaways for Contains Duplicate
1. Core Problem

Check if any value appears at least twice in array

2. Three Approaches

Approach	Time	Space	Method
Nested Loop	O(n²)	O(1)	Compare every pair
Sorting	O(n log n)	O(1)	Sort, check adjacent
HashSet	O(n)	O(n)	Add to set, detect collision
3. Key Insight

Hashset add() returns false if element already exists → immediate duplicate detection

4. Trade-offs

HashSet: Fastest but uses extra memory

Sorting: Memory efficient but slower

Nested Loop: Slowest, avoid for large arrays

5. Edge Cases

Empty array → false

Single element → false

All unique → false

All same → true

6. Best Choice

Use HashSet for most cases (time > space priority)*/