package com.leetcode.blind75.easy;

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int val) { this.val = val; }
}

public class ReverseLinkedList206 {

    //1 -> 2 -> 3 -> 4 -> 5 -> null
    public ListNode2 reverseList(ListNode2 head) {
        ListNode2 prev = null;
        ListNode2 curr = head;

        while (curr != null) {
            ListNode2 nextNode = curr.next; // store next node
            curr.next = prev;               // reverse pointer
            prev = curr;                    // move prev forward
            curr = nextNode;                // move curr forward
        }

        return prev; // new head
    }

    public static void main(String[] args) {
        // Build linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode2 head = new ListNode2(1);
        head.next = new ListNode2(2);
        head.next.next = new ListNode2(3);
        head.next.next.next = new ListNode2(4);
        head.next.next.next.next = new ListNode2(5);

        ReverseLinkedList206 solver = new ReverseLinkedList206();
        ListNode2 reversed = solver.reverseList(head);

        // Print reversed list
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
    }
}

