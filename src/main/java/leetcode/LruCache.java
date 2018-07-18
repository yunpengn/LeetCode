package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Designs a LRU (least-frequently-used) cache.
 */
public class LruCache {
    private Map<Integer, Integer> storage;

    public LruCache(int capacity) {
        storage = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
            private static final long serialVersionUID = 519588431431841845L;

            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return storage.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        storage.put(key, value);
    }
}
