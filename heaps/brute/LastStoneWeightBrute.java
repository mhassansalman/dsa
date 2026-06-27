package dsa.heaps.brute;

import java.util.*;

// Last Stone Weight - Brute Force
// Brute: Sort array each turn, take last two, smash, reinsert — O(n^2 log n)
// Optimal (my thinking): push into MaxHeap, remove 2 heaviest,
//                        if y-x > 0 reinsert remainder, repeat until ≤1 stone

public class LastStoneWeightBrute {

    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> list = new java.util.ArrayList<>();
        for (int s : stones) list.add(s);

        while (list.size() > 1) {
            Collections.sort(list);                          // sort ascending
            int x = list.remove(list.size() - 1);           // heaviest
            int y = list.remove(list.size() - 1);           // second heaviest
            if (x != y) list.add(x - y);                    // reinsert remainder
        }

        return list.isEmpty() ? 0 : list.get(0);
    }

    public static void main(String[] args) {
        LastStoneWeightBrute sol = new LastStoneWeightBrute();
        System.out.println(sol.lastStoneWeight(new int[]{2,7,4,1,8,1})); // 1
        System.out.println(sol.lastStoneWeight(new int[]{1}));            // 1
    }
}