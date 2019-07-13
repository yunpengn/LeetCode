package leetcode.list;

import leetcode.helpers.ListNode;

public class RemoveDuplicatesList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Some initial setup.
        ListNode current = head;
        ListNode next = current.next;

        while (next != null) {
            if (next.val == current.val) {
                next = next.next;
                continue;
            }

            current.next = next;
            current = next;
            next = current.next;
        }
        current.next = null;

        return head;
    }
}
