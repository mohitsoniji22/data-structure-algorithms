package epam.leetcode.linkedlist;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MiddleOfLinkedList876 {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // move by 1
            fast = fast.next.next;    // move by 2
        }

        return slow; // slow is now at the middle
    }

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        MiddleOfLinkedList876 solution = new MiddleOfLinkedList876();
        ListNode middle = solution.middleNode(head);

        System.out.println("Middle node value: " + middle.val);
    }
}
