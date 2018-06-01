package leetcode;

public class MergeLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return lists[0];
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}