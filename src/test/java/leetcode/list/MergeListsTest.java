package leetcode.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import leetcode.helpers.ListNode;

class MergeListsTest {
    private static final MergeLists tester = new MergeLists();

    @Test
    void mergeTwoLists() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n6;

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        assertEquals(l1, tester.mergeTwoLists(n1, n4));
    }
}