package dsa.binary_trees.brute;

import java.util.LinkedList;
import java.util.Queue;

// Invert Binary Tree - Brute Force
// Brute: BFS queue, swap left and right at each node — O(n) time, O(n) space
// Optimal (my thinking): recursive DFS, swap left and right at each call — O(n) time, O(h) space

public class InvertBinaryTreeBrute {

    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // swap left and right
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTreeBrute sol = new InvertBinaryTreeBrute();
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );
        TreeNode result = sol.invertTree(root);
        System.out.println(result.val);       // 4
        System.out.println(result.left.val);  // 7
        System.out.println(result.right.val); // 2
    }
}

