package dsa.two_pointers.brute;

// Reverse String - Brute Force
// Brute: Extra array, fill in reverse order — O(n) time, O(n) space
// Optimal (my thinking): Two pointers i from start, j from end
//                        swap s[i] and s[j], move i++ j-- until they meet

public class ReverseStringBrute {

    public void reverseString(char[] s) {
        char[] temp = new char[s.length];
        for (int i = 0; i < s.length; i++) {
            temp[i] = s[s.length - 1 - i];  // fill reverse into temp
        }
        for (int i = 0; i < s.length; i++) {
            s[i] = temp[i];                  // copy back
        }
    }

    public static void main(String[] args) {
        ReverseStringBrute sol = new ReverseStringBrute();
        char[] s = {'h','e','l','l','o'};
        sol.reverseString(s);
        System.out.println(new String(s)); // olleh
    }
}