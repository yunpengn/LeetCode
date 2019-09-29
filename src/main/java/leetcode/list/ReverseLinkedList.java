package leetcode.list;

import leetcode.helpers.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        pre.next = head;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode current = pre.next;
        ListNode next = current.next;
        for (int i = 0; i < n - m; i++) {
            current.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = current.next;
        }

        return dummyHead.next;
    }
}
