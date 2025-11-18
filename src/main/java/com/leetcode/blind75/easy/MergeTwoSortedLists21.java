package com.leetcode.blind75.easy;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeTwoSortedLists21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode(-1);
        ListNode curr = mergedList;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        // Attach remaining nodes
        if (list1 != null) curr.next = list1;
        if (list2 != null) curr.next = list2;

        return mergedList.next;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 == null && list2 != null) return list2;
        if(list1 != null && list2 == null) return list1;

        ListNode mergedList = null;
        ListNode curr = mergedList;
        while(list1 != null || list2 != null) {
            ListNode tmp = null;
            if(list1 == null && list2 != null){
                curr.next = list2;
                list2 = list2.next;
            } else if(list1 != null && list2 == null) {
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            } else if(list1.val <= list2.val) {
                if(curr == null) {
                    curr = new ListNode(list1.val, null);
                    list1 = list1.next;
                    mergedList = curr;
                } else {
                    tmp = new ListNode(list1.val, null);
                    curr.next = tmp;
                    curr = curr.next;
                    list1 = list1.next;
                }
            } else if(list1.val > list2.val) {
                if(curr == null) {
                    curr = new ListNode(list2.val, null);
                    list2 = list2.next;
                    mergedList = curr;
                } else {
                    tmp = new ListNode(list2.val);
                    curr.next = tmp;
                    curr = curr.next;
                    list2 = list2.next;
                }
            }
        }

        return mergedList;
    }

    public static void main(String[] args) {
        // Example: list1 = [1,2,4], list2 = [1,3,4]
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        MergeTwoSortedLists21 solver = new MergeTwoSortedLists21();
        ListNode merged = solver.mergeTwoLists(list1, list2);
    //    ListNode merged = solver.mergeTwoLists2(list1, list2);

        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
        // Output: 1 1 2 3 4 4
    }
}
