package leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LfuCacheTest {
    @Test
    void simpleTest1() {
        LfuCache cache = new LfuCache(2);

        cache.put(1, 1);
        assertEquals(1, cache.get(1));

        cache.put(2, 2);
        assertEquals(2, cache.get(2));

        cache.put(1, 5);
        assertEquals(5, cache.get(1));
        assertEquals(2, cache.get(2));
    }

    @Test
    void simpleTest2() {
        LfuCache cache = new LfuCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);

        assertEquals(-1, cache.get(1));
    }

    @Test
    void simpleTest3() {
        LfuCache cache = new LfuCache(2);

    }
}
