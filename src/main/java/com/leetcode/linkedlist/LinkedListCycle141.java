package com.leetcode.linkedlist;

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle141 {

    public boolean hasCycle(ListNode2 head) {
        if (head == null || head.next == null)
            return false;

        ListNode2 slow = head;
        ListNode2 fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move 1 step
            fast = fast.next.next;      // move 2 steps

            if (slow == fast) {
                return true; // cycle detected
            }
        }
        return false; // no cycle
    }

    public static void main(String[] args) {
        // Create nodes
        ListNode2 head = new ListNode2(3);
        ListNode2 second = new ListNode2(2);
        ListNode2 third = new ListNode2(0);
        ListNode2 fourth = new ListNode2(-4);

        // Connect nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // creates a cycle (tail connects to node 2)

        LinkedListCycle141 solution = new LinkedListCycle141();
        boolean hasCycle = solution.hasCycle(head);

        System.out.println("Does linked list have a cycle? " + hasCycle);
    }
}
