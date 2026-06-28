package dsa.binary_trees.optimal;

// Diameter of Binary Tree - Optimal
// My Thinking: at each node, left height + right height = diameter through it
//              update global max during height calculation — single DFS O(n)
// Time: O(n), Space: O(h) call stack

public class DiameterOfBinaryTreeOptimal {

    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
    }

    int maxDiameter = 0;

    // returns height AND updates maxDiameter at each node — one pass
    int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);                           // left subtree height
        int right = dfs(node.right);                         // right subtree height
        maxDiameter = Math.max(maxDiameter, left + right);  // diameter through this node
        return 1 + Math.max(left, right);                    // return height to parent
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTreeOptimal sol = new DiameterOfBinaryTreeOptimal();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3)
        );
        System.out.println(sol.diameterOfBinaryTree(root)); // 3
    }
}

/*Takeaways for Diameter of Binary Tree
1. Core Concept

Diameter = longest path between any two nodes

Path length = number of edges (not nodes)

Path may or may not pass through root

2. Key Insight

At each node: diameter through node = left height + right height

Max diameter = maximum of all such sums

Height = 1 + max(leftHeight, rightHeight)

3. Two Approaches

Approach	Time	Space	Method
Brute Force	O(n²)	O(h)	Height called repeatedly per node
Optimal	O(n)	O(h)	Single DFS, compute height and diameter together
4. Why Brute is O(n²)

For each node, call height() on its left and right subtrees

height() traverses entire subtree each time

Repeated work → each node visited many times

5. Optimal Pattern

text
dfs(node):
    if node == null → return 0
    left = dfs(node.left)    // height of left
    right = dfs(node.right)  // height of right
    maxDiameter = max(maxDiameter, left + right)  // update answer
    return 1 + max(left, right)  // return height to parent
6. Important Details

left + right = number of edges through this node

Height returns edges (not nodes)

Global variable tracks max diameter seen

Single post-order traversal

7. Edge Cases

Empty tree → diameter = 0

Single node → diameter = 0

Skewed tree → diameter = n-1

8. Problem Pattern

Post-order traversal with global state

Combine results from children (height) → compute answer at node → return to parent

Common for tree problems requiring information from children*/