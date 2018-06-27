package leetcode.list;

import leetcode.helpers.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode start = new ListNode(-1);
        start.next = head;

        head = start;
        while (head.next != null && head.next.next != null) {
            ListNode next1 = head.next;
            ListNode next2 = head.next.next;

            head.next = next2;
            next1.next = next2.next;
            next2.next = next1;

            head = head.next.next;
        }

        return start.next;
    }
}
