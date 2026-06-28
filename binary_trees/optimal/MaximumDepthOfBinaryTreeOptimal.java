package dsa.binary_trees.optimal;

// Maximum Depth of Binary Tree - Optimal
// My Thinking: max depth = 1 + max(left depth, right depth)
//              recurse down, answer builds on the way back up
// Time: O(n), Space: O(h) call stack

public class MaximumDepthOfBinaryTreeOptimal {

    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTreeOptimal sol = new MaximumDepthOfBinaryTreeOptimal();
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        System.out.println(sol.maxDepth(root)); // 3
    }
}