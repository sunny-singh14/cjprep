package coder.shy.leetcode;

public class PartitionList86 {
    public static void main(String[] args) {
        ListNode _ = new PartitionList86().partition(
                new ListNode(1,
                        new ListNode(4,
                                new ListNode(3,
                                        new ListNode(2,
                                                new ListNode(5,
                                                        new ListNode(2)))))), 3);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode();
        ListNode beforeHead = before;
        ListNode after = new ListNode();
        ListNode afterHead = after;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */