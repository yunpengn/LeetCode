package others;

import java.util.Stack;

public class UndoDisjointSet {
    // Uses an array to indicate each item belongs to which set.
    private final int[] items;

    // Uses a stack to note all past operations.
    private final Stack<int[]> operations = new Stack<>();

    public UndoDisjointSet(int num) {
        this.items = new int[num];

        // Initially, every item belongs to itself (because of no connectivity).
        for (int i = 0; i < num; i++) {
            this.items[i] = i;
        }
    }

    public void union(int a, int b) {
        // Saves the operation on top of the stack first.
        this.operations.push(new int[]{a, b, items[b]});

        // Merges the 2nd item into the set of the 1st.
        items[b] = a;
    }

    public void undo() {
        // Gets the last operation.
        int[] op = this.operations.pop();

        // Discards the operation.
        items[op[1]] = op[2];
    }

    public int numOfSets() {
        int count = 0;

        // Counts those at the root of their respective set.
        for (int i = 0; i < items.length; i++) {
            if (items[i] == i) {
                count++;
            }
        }

        return count;
    }
}
