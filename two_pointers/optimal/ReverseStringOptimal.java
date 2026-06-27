package dsa.two_pointers.optimal;

// Reverse String - Optimal
// Time: O(n), Space: O(1) — in-place two pointer swap

public class ReverseStringOptimal {

    // Iterative
    // My Thinking: i from start, j from end
    //              swap s[i] and s[j], then i++ j--
    //              stop when i meets j
    // Time: O(n), Space: O(1)
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    // Recursive
    // Time: O(n), Space: O(n) call stack
    public void reverseStringRecursive(char[] s, int i, int j) {
        if (i >= j) return;
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        reverseStringRecursive(s, i + 1, j - 1);
    }

    public static void main(String[] args) {
        ReverseStringOptimal sol = new ReverseStringOptimal();

        char[] s1 = {'h','e','l','l','o'};
        sol.reverseString(s1);
        System.out.println(new String(s1)); // olleh

        char[] s2 = {'h','e','l','l','o'};
        sol.reverseStringRecursive(s2, 0, s2.length - 1);
        System.out.println(new String(s2)); // olleh
    }
}