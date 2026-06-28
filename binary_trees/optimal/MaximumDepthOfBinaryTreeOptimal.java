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

/*Takeaways for Maximum Depth of Binary Tree
1. Core Concept

Maximum depth = number of nodes along longest path from root to leaf

Depth of empty tree = 0

Depth of single node = 1

2. Two Approaches

Approach	Time	Space	Method
DFS (Optimal)	O(n)	O(h)	Recurse: 1 + max(left, right)
BFS (Brute)	O(n)	O(n)	Level-order traversal, count levels
3. Key Insight

DFS is cleaner: 1 + max(depth(left), depth(right))

BFS is intuitive: Count levels in level-order traversal

Both are O(n) time, but DFS uses less space (O(h) vs O(n))

4. DFS Pattern

text
maxDepth(node):
    if node == null: return 0
    left = maxDepth(node.left)
    right = maxDepth(node.right)
    return 1 + max(left, right)
5. Why DFS is Better

O(h) space vs BFS O(n) space

No queue needed

Cleaner recursive solution

6. BFS Walkthrough

text
Tree:    3
        / \
       9   20
          /  \
         15   7

Level 1: [3] → depth=1
Level 2: [9, 20] → depth=2
Level 3: [15, 7] → depth=3

Return: 3 ✅
7. DFS Walkthrough

text
maxDepth(3):
    left = maxDepth(9) = 1
    right = maxDepth(20):
        left = maxDepth(15) = 1
        right = maxDepth(7) = 1
        return 1 + max(1,1) = 2
    return 1 + max(1,2) = 3 ✅
8. Edge Cases

Empty tree → 0

Single node → 1

Skewed tree → n (depth = number of nodes)

9. Problem Pattern

DFS with post-order traversal

Combine results from children, return to parent

Classic recursion pattern for tree problems*/