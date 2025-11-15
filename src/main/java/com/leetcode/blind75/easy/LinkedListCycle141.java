package com.leetcode.blind75.easy;

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int val) { this.val = val; }
}

public class LinkedListCycle141 {
    public boolean hasCycle(ListNode1 head) {
        if (head == null || head.next == null) return false;

        ListNode1 slow = head;
        ListNode1 fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move 1 step
            fast = fast.next.next;      // move 2 steps

            if (slow == fast) return true; // cycle detected
        }

        return false; // no cycle
    }

    public static void main(String[] args) {
        // Example: 3 -> 2 -> 0 -> -4 -> points back to 2
        ListNode1 head = new ListNode1(3);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(0);
        head.next.next.next = new ListNode1(-4);
        head.next.next.next.next = head.next; // cycle

        LinkedListCycle141 solver = new LinkedListCycle141();
        System.out.println(solver.hasCycle(head)); // true
    }
}

