package dsa.arrays_strings.brute;
//14
public class LongestCommonPrefixBrute {
    // Initial Thinking:
    // Check charAt(0) for each element - if all same, add to result
    // Then check charAt(1) for each element, and so on
    // Stop when mismatch found or any string runs out of characters

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return result.toString();
                }
            }
            result.append(c);
        }

        return result.toString();
    }
    public static void main(String[] args) {
        LongestCommonPrefixBrute solution = new LongestCommonPrefixBrute();

        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + solution.longestCommonPrefix(strs));
        // Output: Longest Common Prefix: fl
    }
}