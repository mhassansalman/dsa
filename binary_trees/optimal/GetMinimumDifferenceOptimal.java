package dsa.binary_trees.optimal;


// Minimum Absolute Difference in BST - Optimal
// My Thinking: inorder traversal gives sorted order
//              min diff always between adjacent nodes
//              track prev pointer, compute curr-prev at each node
// Time: O(n), Space: O(h) call stack

public class getMinimumDifferenceOptimal {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
    }

    int min = Integer.MAX_VALUE;
    TreeNode prev = null;

    // Recursive inorder — prev tracks last visited node
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);                                      // go left first
        if (prev != null) min = Math.min(min, node.val - prev.val); // adjacent diff
        prev = node;                                             // update prev
        inorder(node.right);                                     // go right
    }

    public static void main(String[] args) {
        getMinimumDifferenceOptimal sol = new getMinimumDifferenceOptimal();
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(6)
        );
        System.out.println(sol.getMinimumDifference(root)); // 1
    }
}

/*Takeaways for Minimum Absolute Difference in BST
1. Core Concept

Find minimum absolute difference between any two nodes in BST

BST property: left < root < right

2. Key Insight

Inorder traversal of BST gives sorted order

Minimum difference is always between adjacent nodes in sorted order

No need to compare all pairs

3. Two Approaches

Approach	Time	Space	Method
Brute Force	O(n²)	O(n)	Collect all values, compare every pair
Optimal (Inorder)	O(n)	O(h)	Inorder traversal with prev pointer
4. Why Inorder Works

text
BST:      4
         / \
        2   6
       / \
      1   3

Inorder: [1, 2, 3, 4, 6]
Adjacent diffs: 1, 1, 1, 2 → min = 1
5. Inorder Pattern

text
prev = null
min = INF

inorder(node):
    inorder(node.left)
    if prev != null:
        min = min(min, node.val - prev.val)
    prev = node
    inorder(node.right)
6. Why Adjacent Comparison is Enough

In sorted array, smallest difference is always between neighbors

Non-adjacent pairs have larger or equal difference

BST inorder = sorted array

7. Edge Cases

Two nodes only → difference between them

Negative values → works fine (subtraction)

Large values → use long if needed

Empty tree → handle with check

8. Problem Pattern

BST + min difference → inorder traversal with prev pointer

BST + kth smallest → inorder with counter

BST + validation → inorder with prev check*/