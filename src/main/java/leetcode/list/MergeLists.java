package leetcode.list;

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

    public ListNode mergeKLists(ListNode[] lists) {
        return lists[0];
    }
}
