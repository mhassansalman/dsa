package dsa.heaps.optimal;

import java.util.Collections;
import java.util.PriorityQueue;

// Last Stone Weight - Optimal
// My Thinking: MaxHeap always gives heaviest two in O(log n)
//              poll twice → smash → reinsert y-x if not destroyed
//              repeat until ≤1 stone remains
// Time: O(n log n), Space: O(n)

public class LastStoneWeightOptimal {

    // ─── Built-in PriorityQueue (MaxHeap via reverseOrder) ───────────────────

    public int lastStoneWeightBuiltIn(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) maxHeap.offer(s);
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (y != x) maxHeap.offer(y - x);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    // ─── Custom MaxHeap (1-based indexing) ───────────────────────────────────

    static class MaxHeap {
        int[] heap;
        int size;

        MaxHeap(int capacity) {
            heap = new int[capacity + 1];
            size = 0;
        }

        void buildHeap(int[] arr) {
            size = arr.length;
            for (int i = 0; i < arr.length; i++) heap[i + 1] = arr[i];
            for (int i = size / 2; i >= 1; i--) heapifyDown(i);
        }

        void insert(int val) {
            heap[++size] = val;
            heapifyUp(size);
        }

        int poll() {
            int max = heap[1];
            heap[1] = heap[size--];
            heapifyDown(1);
            return max;
        }

        int peek() { return heap[1]; }
        boolean isEmpty() { return size == 0; }

        void heapifyUp(int i) {
            while (i > 1 && heap[i] > heap[i / 2]) {
                swap(i, i / 2);
                i = i / 2;
            }
        }

        void heapifyDown(int i) {
            while (2 * i <= size) {
                int child = 2 * i;
                if (child + 1 <= size && heap[child + 1] > heap[child]) child++;
                if (heap[i] >= heap[child]) break;
                swap(i, child);
                i = child;
            }
        }

        void swap(int a, int b) {
            int tmp = heap[a]; heap[a] = heap[b]; heap[b] = tmp;
        }
    }

    public int lastStoneWeightCustom(int[] stones) {
        MaxHeap maxHeap = new MaxHeap(stones.length + 10);
        maxHeap.buildHeap(stones);
        while (maxHeap.size > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (y != x) maxHeap.insert(y - x);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    // ─── Main ─────────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        LastStoneWeightOptimal sol = new LastStoneWeightOptimal();

        System.out.println("Built-in:");
        System.out.println(sol.lastStoneWeightBuiltIn(new int[]{2,7,4,1,8,1})); // 1
        System.out.println(sol.lastStoneWeightBuiltIn(new int[]{1}));            // 1

        System.out.println("Custom:");
        System.out.println(sol.lastStoneWeightCustom(new int[]{2,7,4,1,8,1})); // 1
        System.out.println(sol.lastStoneWeightCustom(new int[]{1}));            // 1
    }
}
/*Takeaways for Last Stone Weight
1. Core Concept

Smash two heaviest stones

If equal → both destroyed

If unequal → remainder reinserted

Repeat until ≤1 stone remains

2. Two Approaches

Approach	Time	Space	Method
Brute Force	O(n² log n)	O(n)	Sort each turn, take last two
MaxHeap (Optimal)	O(n log n)	O(n)	Always extract two heaviest
3. Key Insight

Need to repeatedly access heaviest two stones

MaxHeap gives O(log n) extraction and insertion

Sorting each turn is O(n log n) per operation

4. MaxHeap Operations

text
while heap.size > 1:
    y = heap.poll()   // heaviest
    x = heap.poll()   // second heaviest
    if y != x: heap.offer(y - x)  // reinsert remainder
5. Built-in vs Custom Implementation

Aspect	Built-in PriorityQueue	Custom MaxHeap
Code Length	Short	Long
Time	O(n log n)	O(n log n)
Space	O(n)	O(n)
Use Case	Production code	Learning/understanding
6. PriorityQueue Details

Java's PriorityQueue is min-heap by default

Use Collections.reverseOrder() for max-heap

offer() = insert, poll() = remove & return, peek() = view top

7. Edge Cases

Single stone → return that stone

Two equal stones → return 0 (both destroyed)

Empty array → return 0

All stones destroyed → return 0

8. Example Walkthrough

text
stones = [2,7,4,1,8,1]
heap = [8,7,4,2,1,1]

smash 8 and 7 → remainder 1 → [4,2,1,1,1]
smash 4 and 2 → remainder 2 → [2,1,1,1]
smash 2 and 1 → remainder 1 → [1,1,1]
smash 1 and 1 → both destroyed → [1]

return 1 ✅
9. Why MaxHeap is Optimal

O(n log n) - best possible for this problem

Always gets two heaviest efficiently

Built-in PriorityQueue makes implementation clean*/