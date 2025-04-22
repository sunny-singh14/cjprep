package coder.shy.leetcode;

public class RemoveDuplicate83 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode modified = deleteDuplicates(head);
        while (modified != null) {
            System.out.print(modified.val + " ");
            modified = modified.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            if (prev != null && prev.val == temp.val) {
                if (temp.next != null) {
                    temp.val = temp.next.val;
                    temp.next = temp.next.next != null ? temp.next.next : null;
                } else {
                    temp = null;
                    prev.next = null;
                }
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }


    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
