package coder.shy.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSortedList {
    public static void main(String[] args) {
        ListNode first = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode second = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode third = new ListNode(2, new ListNode(6));
        ListNode[] lists = new ListNode[]{first, second, third};

        ListNode result = new MergeSortedList().mergeKLists(lists);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // PriorityQueue to store ListNodes based on their value
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // Add the head of each list into the queue
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0); // dummy node
        ListNode tail = dummy; // tail pointer to build the result list

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode; // attach the smallest node
            tail = tail.next; // move the tail

            if (minNode.next != null) {
                pq.add(minNode.next); // add the next node from the same list
            }
        }

        return dummy.next;
    }

    ListNode insert(ListNode root, int item) {
        ListNode temp = new ListNode(item);
        if (root == null) {
            return temp;
        }
        ListNode curr = root;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        return root;
    }
}
