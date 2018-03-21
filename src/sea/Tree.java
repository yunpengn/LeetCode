package sea;

import java.util.ArrayList;

/**
 * A binary search tree. You can also view this class as a `Tree Node`
 *
 * @param <T> must be comparable.
 */
public class Tree<T extends Comparable<T>> {
    private Tree<T> leftChild = null;
    private Tree<T> rightChild = null;

    private T value;

    public Tree(T value) {
        this.value = value;
    }

    public ArrayList<T> inOrderTraversal() {
        ArrayList<T> leftResult = leftChild == null ? leftChild.inOrderTraversal()
                : new ArrayList<>();
        ArrayList<T> rightResult = rightChild == null ? rightChild.inOrderTraversal()
                : new ArrayList<>();

        leftResult.add(value);
        leftResult.addAll(rightResult);

        return leftResult;
    }
}
