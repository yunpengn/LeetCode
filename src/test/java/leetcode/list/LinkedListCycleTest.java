package leetcode.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import leetcode.helpers.ListNode;
import leetcode.list.LinkedListCycle;

class LinkedListCycleTest {
    private static final LinkedListCycle tester = new LinkedListCycle();

    @Test
    void simpleTest() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        assertTrue(tester.hasCycle(node1));
    }
}