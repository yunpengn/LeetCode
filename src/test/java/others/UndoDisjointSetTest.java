package others;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UndoDisjointSetTest {
    @Test
    void simpleTest() {
        UndoDisjointSet set = new UndoDisjointSet(5);
        assertEquals(5, set.numOfSets());

        set.union(0, 1);
        assertEquals(4, set.numOfSets());

        set.union(1, 2);
        assertEquals(3, set.numOfSets());

        set.union(0, 3);
        assertEquals(2, set.numOfSets());

        set.undo();
        assertEquals(3, set.numOfSets());
    }
}
