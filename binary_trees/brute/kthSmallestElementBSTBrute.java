package dsa.binary_trees.brute;

import java.util.ArrayList;
import java.util.List;

// Kth Smallest in BST - Brute Force
// Brute: collect all inorder values, return index k-1 — O(n) time, O(n) space
// Optimal (my thinking): iterative inorder, stop at kth element — O(k) time, O(h) space

public class kthSmallestElementBSTBrute {

    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        return vals.get(k - 1); // kth smallest = index k-1
    }

    void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }


    public static void main(String[] args) {
        kthSmallestElementBSTBrute sol = new kthSmallestElementBSTBrute();
        TreeNode root = new TreeNode(3,
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(4)
        );
        System.out.println(sol.kthSmallest(root, 1)); // 1
        System.out.println(sol.kthSmallest(root, 3)); // 3
    }
}

/*Takeaways for Kth Smallest in BST
1. Core Concept

BST inorder traversal gives sorted order

Kth smallest = kth element in inorder traversal

Stop early when kth element found

2. Two Approaches

Approach	Time	Space	Method
Brute Force	O(n)	O(n)	Full inorder → store all → get k-1
Optimal (Iterative)	O(k)	O(h)	Inorder with stack, stop at kth
Optimal (Recursive)	O(k)	O(h)	Inorder with counter, stop early
3. Why Optimal is Better

Brute: Always traverses entire tree O(n) even if k=1

Optimal: Stops at kth → O(k) time, O(h) space


Aspect	Iterative	Recursive
Stack	Explicit (O(h))	Implicit call stack (O(h))
Control	Full control	Simpler code
Early Stop	Easy	Easy with counter

8. Edge Cases

k = 1 → leftmost node

k = n → rightmost node (if n = tree size)

Tree with only right child → kth smallest = kth node

 Problem Pattern

Inorder traversal is key for BST order-based problems

Use stack for iterative traversal without full array

Early stopping optimizes when k is small

*/