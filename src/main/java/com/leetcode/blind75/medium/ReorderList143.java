package com.leetcode.blind75.medium;

public class ReorderList143 {

    public static ListNode reverseList(ListNode root) {
        ListNode prev = null;
        ListNode curr = root;

        while(curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode firstHalf = head;
        secondHalf = reverseList(secondHalf);

        ListNode newHead = new ListNode(firstHalf.val);
        newHead.next = null;
        ListNode curr = newHead;
        firstHalf = firstHalf.next;
        while(firstHalf != null || secondHalf != null)  {
            if(secondHalf != null) {
                ListNode tmp = new ListNode(secondHalf.val);
                tmp.next = null;
                curr.next = tmp;
                curr = curr.next;
                secondHalf = secondHalf.next;
            }
            if(firstHalf != null) {
                ListNode tmp = new ListNode(firstHalf.val);
                tmp.next = null;
                curr.next = tmp;
                curr = curr.next;
                firstHalf = firstHalf.next;
            }
        }

        head =  newHead;
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        reorderList(head);

    }
}
