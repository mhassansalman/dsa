package dsa.heaps.optimal;

import java.util.Collections;
import java.util.PriorityQueue;

// Kth Largest - Optimal
// My Thinking: push all into MaxHeap, poll k times → kth largest
// Time: O(n log k) MinHeap | O(n + k log n) MaxHeap | O(n) avg QuickSelect
// Space: O(k) MinHeap | O(n) MaxHeap | O(1) QuickSelect

public class KthLargestElementOptimal {

    // ─── 1. MaxHeap — my thinking: push all, poll k times ────────────────────
    // Time: O(n + k log n), Space: O(n)

    public int findKthLargestMaxHeap(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : nums) maxHeap.offer(n);
        int result = 0;
        while (k-- > 0) result = maxHeap.poll();
        return result;
    }

    // ─── 2. MinHeap of size k — root is always kth largest ───────────────────
    // Time: O(n log k), Space: O(k)

    public int findKthLargestMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.offer(n);
            if (minHeap.size() > k) minHeap.poll(); // remove smallest, keep k largest
        }
        return minHeap.peek(); // root = kth largest
    }

    // ─── 3. QuickSelect — partition around pivot, recurse one side ───────────
    // Time: O(n) avg, O(n^2) worst, Space: O(1)

    public int findKthLargestQuickSelect(int[] nums, int k) {
        int target = nums.length - k; // kth largest = target-th smallest
        return quickSelect(nums, 0, nums.length - 1, target);
    }

    private int quickSelect(int[] nums, int left, int right, int target) {
        int pivot = nums[right];
        int p = left;

        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, p++);
            }
        }
        swap(nums, p, right); // place pivot in correct position

        if (p == target) return nums[p];
        else if (p < target) return quickSelect(nums, p + 1, right, target);
        else return quickSelect(nums, left, p - 1, target);
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a]; nums[a] = nums[b]; nums[b] = tmp;
    }

    // ─── Main ─────────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        KthLargestElementOptimal sol = new KthLargestElementOptimal();
        int[] test1 = {3,2,1,5,6,4};
        int[] test2 = {3,2,3,1,2,4,5,5,6};

        System.out.println("MaxHeap:");
        System.out.println(sol.findKthLargestMaxHeap(test1, 2)); // 5
        System.out.println(sol.findKthLargestMaxHeap(test2, 4)); // 4

        System.out.println("MinHeap:");
        System.out.println(sol.findKthLargestMinHeap(new int[]{3,2,1,5,6,4}, 2)); // 5
        System.out.println(sol.findKthLargestMinHeap(new int[]{3,2,3,1,2,4,5,5,6}, 4)); // 4

        System.out.println("QuickSelect:");
        System.out.println(sol.findKthLargestQuickSelect(new int[]{3,2,1,5,6,4}, 2)); // 5
        System.out.println(sol.findKthLargestQuickSelect(new int[]{3,2,3,1,2,4,5,5,6}, 4)); // 4
    }
}