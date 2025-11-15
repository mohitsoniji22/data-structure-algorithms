package com.leetcode.linkedlist;

class LinkedListPalindrome234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalf = reverse(slow);

        // Step 3: Compare both halves
        ListNode firstHalf = head;
        ListNode second = secondHalf;
        while (second != null) { // secondHalf may be shorter
            if (firstHalf.val != second.val)
                return false;
            firstHalf = firstHalf.next;
            second = second.next;
        }

        // Optional Step 4: Restore (reverse again)
        // reverse(secondHalf);

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Create a palindrome linked list: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);

        LinkedListPalindrome234 solver = new LinkedListPalindrome234();
        boolean result = solver.isPalindrome(head);

        System.out.println("Is Palindrome: " + result); // Expected: true
    }
}
