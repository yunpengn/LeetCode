package leetcode.list;

import leetcode.helpers.ListNode;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int length = 1;
        ListNode fast = head;
        while (fast.next != null) {
            length++;
            fast = fast.next;
        }

        ListNode slow = head;
        for (int remain = length - k % length; remain > 1; remain--) {
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}
