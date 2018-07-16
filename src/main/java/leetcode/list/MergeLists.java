package leetcode.list;

import java.util.Comparator;
import java.util.PriorityQueue;

import leetcode.helpers.ListNode;

public class MergeLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        // Maintains the reference to the starting node.
        ListNode start;
        if (l1.val < l2.val) {
            start = l1;
            l1 = l1.next;
        } else {
            start = l2;
            l2 = l2.next;
        }

        // The node that is being processed right now.
        ListNode current = start;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                current.next = l2;
                l2 = l2.next;
            } else if (l2 == null || l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        return start;
    }

    /**
     * It is quite interesting to analyze the time complexity of this problem. In the solution
     * presented below, we always maintain a {@link PriorityQueue} of size k. Thus, we would
     * achieve a time complexity of O(nk * log k).
     *
     * @param lists is a list of linked lists.
     * @return the list merged all together.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Uses a priority queue to store all elements.
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        // Maintains the reference to the starting node.
        ListNode start = new ListNode(0);
        ListNode tail = start;

        // Adds the starting node of all linked lists into the priority queue.
        for (ListNode node: lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        // Extracts out all the elements in the priority queue. If the node is not the
        // last node of its own original linked list, add its next node into the queue.
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null) {
                queue.add(tail.next);
            }
        }

        return start.next;
    }
}
