package dsa.linked_lists.brute;

import java.util.HashSet;

// Linked List Cycle - Brute Force
// Brute: Store visited nodes in a HashSet — O(n) time, O(n) space
// Optimal (my thinking): slow pointer moves 1 step, fast moves 2 steps
//                        if they meet -> cycle detected

public class LinkedListCycleBrute {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    // Brute: store every visited node in set
    // Time: O(n), Space: O(n)
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> seen = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (!seen.add(curr)) return true;  // already visited -> cycle
            curr = curr.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycleBrute sol = new LinkedListCycleBrute();

        // List with cycle: 3->2->0->-4->back to 2
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // cycle

        System.out.println(sol.hasCycle(head)); // true

        // No cycle: 1->2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println(sol.hasCycle(head2)); // false
    }
}