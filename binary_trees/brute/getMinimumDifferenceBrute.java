package dsa.binary_trees.brute;

import java.util.ArrayList;
import java.util.List;

// Minimum Absolute Difference in BST - Brute Force
// Brute: Collect all values, compare every pair — O(n^2)
// Optimal (my thinking): inorder gives sorted order, prev pointer
//                        min diff is always between adjacent nodes → O(n)

public class getMinimumDifferenceBrute {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
    }

    List<Integer> vals = new ArrayList<>();

    void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        vals.add(root.val);
        inorder(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        inorder(root);

        // compare every pair
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < vals.size(); i++) {
            for (int j = i + 1; j < vals.size(); j++) {
                min = Math.min(min, Math.abs(vals.get(i) - vals.get(j)));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        getMinimumDifferenceBrute sol = new getMinimumDifferenceBrute();
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(6)
        );
        System.out.println(sol.getMinimumDifference(root)); // 1
    }
}