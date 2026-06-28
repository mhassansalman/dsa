package dsa.binary_trees.brute;

// Diameter of Binary Tree - Brute Force
// Brute: For each node, compute left height + right height separately — O(n^2)
//        height() is called repeatedly for every node
// Optimal (my thinking): at each node, left height + right height = diameter through it
//                        update global max, return height up — single DFS O(n)

public class DiameterOfBinaryTreeBrute {

    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
    }

    // compute height of a node — called repeatedly → O(n) per node → O(n^2) total
    int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    int maxDiameter = 0;

    void dfs(TreeNode node) {
        if (node == null) return;
        // diameter through this node = left height + right height
        int left = height(node.left);
        int right = height(node.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        dfs(node.left);
        dfs(node.right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTreeBrute sol = new DiameterOfBinaryTreeBrute();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3)
        );
        System.out.println(sol.diameterOfBinaryTree(root)); // 3
    }
}