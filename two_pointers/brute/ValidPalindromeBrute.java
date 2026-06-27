package dsa.two_pointers.brute;

// Valid Palindrome - Brute Force
// Brute: Clean string, compare to its reverse — O(n) time, O(n) space
// Optimal (my thinking): Two pointers i and j, skip non-alphanumeric
//                        if s[i] != s[j] return false, else i++ j--

public class ValidPalindromeBrute {

    public boolean isPalindrome(String s) {
        // clean: keep only alphanumeric, lowercase
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }

        String forward = cleaned.toString();
        String backward = cleaned.reverse().toString();
        return forward.equals(backward);
    }

    public static void main(String[] args) {
        ValidPalindromeBrute sol = new ValidPalindromeBrute();
        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(sol.isPalindrome("race a car")); // false
        System.out.println(sol.isPalindrome(" ")); // true
    }
}