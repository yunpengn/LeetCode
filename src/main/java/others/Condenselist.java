package others;

import java.util.HashSet;
import java.util.Set;

import leetcode.helpers.ListNode;

public class Condenselist {
    public ListNode condense(ListNode head) {
        // Stores the values occurred so far.
        Set<Integer> values = new HashSet<>();

        // Pointers for the current iteration.
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            if (values.contains(current.val)) {
                previous.next = current.next;
            } else {
                previous = current;
                values.add(current.val);
            }

            current = current.next;
        }

        return head;
    }
}
