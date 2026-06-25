package dsa.arrays_strings.optimal;
//14
import dsa.arrays_strings.brute.LongestCommonPrefixBrute;

import java.util.Arrays;

public class LongestCommonPrefixOptimal {


    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0], last = strs[strs.length - 1];
        int i = 0;
        while (i < first.length() && first.charAt(i) == last.charAt(i)) i++;
        return first.substring(0, i);
    }
    public static void main(String[] args) {
        LongestCommonPrefixOptimal solution = new LongestCommonPrefixOptimal();

        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + solution.longestCommonPrefix(strs));
        // Output: Longest Common Prefix: fl
    }
}

// Takeaway:
// Sort strings lexicographically — first and last become most different
// If first and last share a prefix, everything in between shares it too
// Only compare first and last → O(n log n) vs brute O(n*m)
/*Takeaways for Longest Common Prefix
1. Core Pattern

Compare characters across all strings at same index

Stop when mismatch found or string ends

2. Two Approaches

Brute Force: Compare all strings character by character → O(n×m)

Sorting: Sort strings, compare only first & last → O(n log n)

3. Sorting Trick

In sorted order, first & last are most different

If they share prefix, all strings in between share it too

4. Trade-offs

Brute Force: Better for few strings with long lengths

Sorting: Better for many strings with short lengths

5. Edge Cases

Empty/null array → return ""

Single string → return that string

No common prefix → return ""

6. Key Insight

Prefix checking = compare characters in order until mismatch

*/