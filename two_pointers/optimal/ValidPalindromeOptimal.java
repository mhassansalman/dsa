package dsa.two_pointers.optimal;

public class ValidPalindromeOptimal {

    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(arr[i])) { i++; continue; }
            if (!Character.isLetterOrDigit(arr[j])) { j--; continue; }
            if (Character.toLowerCase(arr[i]) != Character.toLowerCase(arr[j])) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeOptimal sol = new ValidPalindromeOptimal();
        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(sol.isPalindrome("race a car")); // false
        System.out.println(sol.isPalindrome(" ")); // true
    }

}

//## Takeaways for Valid Palindrome
//
//**1. Core Concept**
//- Check if string reads same forward and backward
//- Ignore non-alphanumeric characters
//- Case insensitive
//
//**2. Two Approaches**
//
//| Approach | Time | Space | Method |
//|----------|------|-------|--------|
//| **Brute Force** | O(n) | O(n) | Clean string, compare with reverse |
//| **Two Pointers** | O(n) | O(1) | Skip invalid chars, compare in-place |
//
//**3. Two Pointer Pattern**
//```
//i = 0, j = n-1
//while i < j:
//    skip non-alphanumeric on left
//    skip non-alphanumeric on right
//    if lowercase(s[i]) != lowercase(s[j]) → false
//    i++, j--
//return true
//```
//
//**4. Key Insights**
//- Skip invalid characters with `continue`
//- Compare only alphanumeric characters
//- Convert to lowercase for case-insensitive check
//
//**5. Helper Methods Used**
//- `Character.isLetterOrDigit()` - check valid char
//- `Character.toLowerCase()` - ignore case
//
//**6. Edge Cases**
//- Empty string → true
//- String with only spaces → true
//- Mixed case → "Aa" → true
//- Special characters ignored → "a@b!a" → true
//
//**7. Why Two Pointers is Optimal**
//- O(1) space - no extra array/StringBuilder
//- O(n) time - must check each character
//- Clean and memory efficient