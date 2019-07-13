package leetcode.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import leetcode.helpers.ListNode;

class RemoveDuplicatesListTest {
    private RemoveDuplicatesList tester = new RemoveDuplicatesList();

    @Test
    void emptyList() {
        ListNode result = tester.deleteDuplicates(null);
        assertNull(result);
    }

    @Test
    void singleList() {
        ListNode input = new ListNode(1);
        ListNode result = tester.deleteDuplicates(input);
        assertEquals(input, result);
    }

    @Test
    void simpleTest() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode result = tester.deleteDuplicates(node1);
        assertEquals("1, 3", result.toString());
    }

    @Test
    void endWithDuplicates() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = tester.deleteDuplicates(node1);
        assertEquals("1, 2, 3", result.toString());
    }
}
