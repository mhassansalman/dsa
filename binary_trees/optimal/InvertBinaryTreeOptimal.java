package dsa.binary_trees.optimal;

// Invert Binary Tree - Optimal
// My Thinking: swap root.left and root.right, then recurse both sides
// Time: O(n), Space: O(h) call stack

public class InvertBinaryTreeOptimal {

    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
    }

    // Recursive
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // swap left and right
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // recurse both sides
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTreeOptimal sol = new InvertBinaryTreeOptimal();
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
/*Takeaways for Invert Binary Tree
1. Core Concept

Swap left and right children at every node

Mirror the tree across vertical axis

Same structure, swapped children

2. Two Approaches

Approach	Time	Space	Method
DFS (Optimal)	O(n)	O(h)	Recursive: swap, then recurse
BFS (Brute)	O(n)	O(n)	Level-order: swap each node
3. Key Insight

Any traversal works - just swap children at each node

DFS is simpler - recursion handles the swapping naturally

BFS needs queue - more code but same time

4. DFS Pattern

text
invertTree(node):
    if node == null: return null
    swap(node.left, node.right)
    invertTree(node.left)
    invertTree(node.right)
    return node
5. Visual Walkthrough

text
Before:               After:
    4                   4
   / \                 / \
  2   7        →      7   2
 / \ / \             / \ / \
1  3 6 9            9  6 3  1
Step-by-step at each node:

text
Root 4: swap 2 ↔ 7
Left 7: swap 6 ↔ 9
Right 2: swap 1 ↔ 3
6. Why DFS is Better

O(h) space vs BFS O(n) space

No queue needed

Cleaner recursive solution

Simpler to implement

7. Edge Cases

Empty tree → null

Single node → same node

Skewed tree → mirror image

8. Problem Pattern

Tree transformation - modify tree in-place

Post-order/pre-order both work

Swap children at each node regardless of traversal order*/