package dsa.binary_trees.brute;

import java.util.ArrayList;
import java.util.List;

// Validate BST - Brute Force
// Brute: inorder traversal gives sorted order, check if strictly increasing
// Optimal: DFS with min/max bounds passed down — O(n)

public class ValidateBSTBrute {

    static class TreeNode {
        int val; TreeNode left, right;
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

    // inorder of valid BST must be strictly increasing
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for (int i = 1; i < vals.size(); i++) {
            if (vals.get(i) <= vals.get(i - 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidateBSTBrute sol = new ValidateBSTBrute();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(sol.isValidBST(root)); // true

        ValidateBSTBrute sol2 = new ValidateBSTBrute();
        TreeNode root2 = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6))
        );
        System.out.println(sol2.isValidBST(root2)); // false
    }
}