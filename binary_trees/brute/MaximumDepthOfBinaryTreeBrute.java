package dsa.binary_trees.brute;

import java.util.LinkedList;
import java.util.Queue;

// Maximum Depth of Binary Tree - Brute Force
// Brute: BFS level by level, count levels — O(n) time, O(n) space
// Optimal (my thinking): DFS — 1 + max(left depth, right depth) — O(n) time, O(h) space

public class MaximumDepthOfBinaryTreeBrute {

    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();         // nodes at current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;                         // finished one level
        }
        return depth;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTreeBrute sol = new MaximumDepthOfBinaryTreeBrute();
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        System.out.println(sol.maxDepth(root)); // 3
    }
}