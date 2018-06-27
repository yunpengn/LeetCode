package leetcode;

import leetcode.helpers.ListNode;

public class RemoveFromEnd {
    // Pre-condition: assume n is valid, which means the length of the
    // linked list is at least n.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // To maintain reference to the head node.
        ListNode start = new ListNode(-1);
        start.next = head;

        // Defines two pointers.
        ListNode front = start;
        ListNode back = start;

        // Moves the front pointer for n steps first.
        for (int i = 0; i < n; i++) {
            front = front.next;
        }

        // Moves two pointers together until the end of the list.
        while (front != null && front.next != null) {
            front = front.next;
            back = back.next;
        }

        // Removes the expected node from the list.
        ListNode temp;
        if (back.next == null) {
            temp = null;
        } else {
            temp = back.next.next;
            back.next.next = null;
        }
        back.next = temp;

        return start.next;
    }
}
