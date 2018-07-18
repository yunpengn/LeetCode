package leetcode.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import leetcode.search.SearchRotated;

class SearchRotatedTest {
    private static final SearchRotated tester = new SearchRotated();

    @Test
    void simpleTest() {
        int[] nums = new int[]{ 4, 5, 6, 7, 0, 1, 2 };
        assertEquals(4, tester.search(nums, 0));
    }
}
