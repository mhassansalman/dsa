package dsa.binary_trees.optimal;

import java.util.Stack;

// Kth Smallest in BST - Optimal
// My Thinking: iterative inorder using stack, stop exactly at kth element
// No need to collect all — stop early saves time when k is small
// Time: O(k), Space: O(h) stack

public class kthSmallestElementBSTOptimal {

    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // go as far left as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // process node
            curr = stack.pop();
            k--;
            if (k == 0) return curr.val; // found kth smallest — stop early
            // move to right subtree
            curr = curr.right;
        }

        return -1;
    }
    // Recursive Optimal — O(k) time, O(h) space
// same idea: inorder but stop at kth element using counter

    int count = 0;
    int result = -1;

    public int kthSmallestRecursive(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    void inorder(TreeNode node, int k) {
        if (node == null || count >= k) return; // stop early if found
        inorder(node.left, k);
        count++;
        if (count == k) { result = node.val; return; } // found kth
        inorder(node.right, k);
    }

    public static void main(String[] args) {
        kthSmallestElementBSTOptimal sol = new kthSmallestElementBSTOptimal();
        TreeNode root = new TreeNode(3,
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(4)
        );
        System.out.println(sol.kthSmallest(root, 1)); // 1
        System.out.println(sol.kthSmallest(root, 3)); // 3
    }
}