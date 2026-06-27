package dsa.heaps.brute;

import java.util.Arrays;

// Kth Largest - Brute Force
// Brute: Sort descending, return element at index k-1 — O(n log n)
// Optimal (my thinking): push all into MaxHeap, poll k times → kth largest

public class KthLargestElementBrute {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k]; // kth from end = kth largest
    }

    public static void main(String[] args) {
        KthLargestElementBrute sol = new KthLargestElementBrute();
        System.out.println(sol.findKthLargest(new int[]{3,2,1,5,6,4}, 2)); // 5
        System.out.println(sol.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4)); // 4
    }
}