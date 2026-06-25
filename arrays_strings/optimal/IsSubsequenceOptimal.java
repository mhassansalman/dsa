package dsa.arrays_strings.optimal;

public class IsSubsequenceOptimal {

        public boolean isSubsequence(String s, String t) {
            int n = s.length();
            int m = t.length();

            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();

            int i = 0, j = 0;

            while (i < n && j < m) {
                if (ss[i] == tt[j]) {
                    i++;
                }
                j++;
            }

            return i == n;
        }

    public static void main(String[] args) {
        IsSubsequenceOptimal solution = new IsSubsequenceOptimal();

        // Test Case 1: Should return true
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println("Test 1: " + solution.isSubsequence(s1, t1)); // true

        // Test Case 2: Should return false
        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println("Test 2: " + solution.isSubsequence(s2, t2)); // false


    }
}
/*Takeaways for Is Subsequence
1. Core Pattern

Two-pointer technique for order-based matching

Move s pointer only on match, always move t pointer

2. Time & Space

Time: O(n) - scan t once

Space: O(1) - no extra data structures

3. Edge Cases

Empty s → always true

Empty t with non-empty s → false

4. Key Insight

You must scan all of t in worst case

Can't skip characters because order matters

5. Problem Pattern

Subsequence checking = linear scan with pointer advancement

Same pattern applies to many string matching problems

6. Follow-up Optimization

Preprocess t if checking many s strings

Store positions of each character for binary search*/