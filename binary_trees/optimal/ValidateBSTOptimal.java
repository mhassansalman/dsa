package dsa.binary_trees.optimal;

// Validate BST - Optimal
// My Thinking: each node must satisfy min < node.val < max
//              left child: max becomes root.val
//              right child: min becomes root.val
// Time: O(n), Space: O(h) call stack

public class ValidateBSTOptimal {

    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Long instead of Integer — constraints include Integer.MIN/MAX_VALUE as node values
    boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;                    // empty tree is valid
        if (node.val <= min || node.val >= max) return false; // violates bounds

        return validate(node.left, min, node.val)         // left: max becomes current
                && validate(node.right, node.val, max);       // right: min becomes current
    }

    public static void main(String[] args) {
        ValidateBSTOptimal sol = new ValidateBSTOptimal();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(sol.isValidBST(root)); // true

        TreeNode root2 = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6))
        );
        System.out.println(sol.isValidBST(root2)); // false
    }
}
/*Takeaways for Validate BST
1. Core Concept

BST property: left < root < right for ALL nodes (not just immediate children)

Every node must satisfy: min < node.val < max

2. Two Approaches

Approach	Time	Space	Method
Brute Force	O(n)	O(n)	Inorder → check sorted
Optimal (Bounds)	O(n)	O(h)	Pass min/max bounds down
3. Key Insights

Inorder traversal of valid BST gives strictly increasing order

Bounds approach catches violations early without storing all values

Long instead of int handles Integer.MIN/MAX_VALUE as node values

4. Bounds Pattern

text
validate(node, min, max):
    if node == null → true
    if node.val <= min || node.val >= max → false
    return validate(left, min, node.val) && validate(right, node.val, max)
5. Why Both are O(n)

Brute: visits every node once (inorder), then checks array

Optimal: visits every node once (DFS with bounds)

6. Edge Cases

Empty tree → true

Single node → true

Duplicate values → false (BST requires strict ordering)
Values at Integer boundaries → use Long
7. Common Pitfalls

❌ Only checking immediate children

❌ Using int for bounds (fails at Integer.MIN/MAX_VALUE)

❌ Forgetting strict inequality (no duplicates)
*/