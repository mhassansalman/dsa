package dsa.arrays_strings.brute;
//392
//my initial thinking: Compare characters of s with t in order. Use two pointers - one for each string.
// Move pointer in s only when matching char found in t.If we match all chars in s, it's a subsequence.


import dsa.arrays_strings.optimal.IsSubsequenceOptimal;

public class IsSubsequenceBrute {

    public boolean isSubsequence(String s, String t) {
        int i = 0; // pointer for s
        int j = 0; // pointer for t

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // found match, move s pointer
            }
            j++; // always move t pointer
        }

        return i == s.length(); // matched all characters of s
    }
    public static void main(String[] args) {
        IsSubsequenceBrute solution = new IsSubsequenceBrute();

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
