package dsa.heaps.optimal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// Top K Frequent Elements - Optimal
// Time: O(n log k) MinHeap | O(n) Bucket Sort | O(n) Optimized Bucket Sort
// Space: O(n)

public class TopKFrequentElementsOptimal {

    // ─── 1. MinHeap of size k ─────────────────────────────────────────────────
    // Keep k most frequent — root is least frequent among top k
    // Time: O(n log k), Space: O(n)

    public int[] topKFrequentMinHeap(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);

        // minHeap ordered by frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> freq.get(a) - freq.get(b)
        );

        for (int n : freq.keySet()) {
            minHeap.offer(n);
            if (minHeap.size() > k) minHeap.poll(); // remove least frequent
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) result[i] = minHeap.poll();
        return result;
    }

    // ─── 2. Bucket Sort ───────────────────────────────────────────────────────
    // Index = frequency, bucket[i] = all numbers with frequency i
    // Time: O(n), Space: O(n)

    public int[] topKFrequentBucketSort(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);

        // bucket index = frequency, max frequency = nums.length
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int n : freq.keySet()) {
            int f = freq.get(n);
            if (bucket[f] == null) bucket[f] = new ArrayList<>();
            bucket[f].add(n);
        }

        // collect top k from highest frequency buckets
        int[] result = new int[k];
        int idx = 0;
        for (int i = bucket.length - 1; i >= 0 && idx < k; i--) {
            if (bucket[i] != null) {
                for (int n : bucket[i]) {
                    result[idx++] = n;
                    if (idx == k) break;
                }
            }
        }
        return result;
    }

    // ─── 3. Optimized Bucket Sort (no HashMap) ────────────────────────────────
    // Uses int[] for frequency counting instead of HashMap — faster in practice
    // Only works when value range is bounded (here -10^4 to 10^4)
    // Time: O(n), Space: O(range + highFreq)

    public int[] topKFrequentOptimizedBucket(int[] nums, int k) {
        // step 1: find min and max to determine value range
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        // step 2: count frequency using array — index = value - min (0-based)
        int[] freq = new int[max - min + 1];
        int highFreq = 0;
        for (int i : nums) {
            int idx = i - min;           // shift value to 0-based index
            int count = ++freq[idx];
            if (count > highFreq) highFreq = count;
        }

        // step 3: bucket by frequency — freqIdx = freq-1 (0-based)
        List<Integer>[] bucketList = new ArrayList[highFreq];
        for (int i = 0; i < freq.length; i++) {
            int freqIdx = freq[i] - 1;
            if (freqIdx == -1) continue;  // value doesn't exist in nums
            if (bucketList[freqIdx] == null) bucketList[freqIdx] = new ArrayList<>();
            bucketList[freqIdx].add(i + min); // convert index back to original value
        }

        // step 4: collect top k from highest frequency buckets
        int[] res = new int[k];
        int idx = 0;
        for (int i = highFreq - 1; i >= 0; i--) {
            if (bucketList[i] == null) continue;
            for (int num : bucketList[i]) {
                res[idx++] = num;
                if (idx == k) return res;
            }
        }
        return res;
    }

    // ─── Main ─────────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        TopKFrequentElementsOptimal sol = new TopKFrequentElementsOptimal();

        System.out.println("MinHeap:");
        System.out.println(Arrays.toString(sol.topKFrequentMinHeap(new int[]{1,1,1,2,2,3}, 2))); // [1,2]
        System.out.println(Arrays.toString(sol.topKFrequentMinHeap(new int[]{1}, 1)));            // [1]

        System.out.println("Bucket Sort:");
        System.out.println(Arrays.toString(sol.topKFrequentBucketSort(new int[]{1,1,1,2,2,3}, 2))); // [1,2]
        System.out.println(Arrays.toString(sol.topKFrequentBucketSort(new int[]{1}, 1)));            // [1]

        System.out.println("Optimized Bucket Sort:");
        System.out.println(Arrays.toString(sol.topKFrequentOptimizedBucket(new int[]{1,1,1,2,2,3}, 2))); // [1,2]
        System.out.println(Arrays.toString(sol.topKFrequentOptimizedBucket(new int[]{1}, 1)));            // [1]
    }
}

/*Takeaways for Top K Frequent Elements
1. Core Concept

Find k elements with highest frequency in array

Need to count frequencies first, then extract top k

2. Three Approaches

Approach	Time	Space	Best For
Brute Force (Sort)	O(n log n)	O(n)	Simple, small n
MinHeap	O(n log k)	O(n)	k small, memory efficient
Bucket Sort	O(n)	O(n)	Fastest, n moderate
3. Key Insights

Frequency counting is always first step

MinHeap size k keeps only top k → less memory when k << n

Bucket Sort uses frequency as index → O(1) access, no sorting

Max frequency = n (array length) → bucket size = n+1

4. MinHeap Pattern

text
MinHeap of size k:
    add each element
    if size > k: remove smallest (poll)
At end: heap contains top k elements
5. Bucket Sort Pattern

text
bucket[frequency] = list of numbers with that frequency
Collect from highest frequency downward until k elements
6. Trade-offs

MinHeap: Better for streaming data or huge n where k is small

Bucket Sort: Better when n is manageable and speed matters

Brute Sort: Simpler code but slower

7. Edge Cases

k = 1 → return most frequent element

k = number of unique elements → return all

All elements same → return that element

Empty array → return empty array

8. When to Use Which

Small k (< 100): MinHeap

k close to n: Bucket Sort or sorting

One-time query: Sorting is fine

Multiple queries: Preprocess with bucket

*/