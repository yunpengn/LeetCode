package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A binary search tree. You can also view this class as a `Tree Node`.
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

    private ArrayList<T> inOrderTraversal() {
        ArrayList<T> leftResult = leftChild == null ? leftChild.inOrderTraversal()
                : new ArrayList<>();
        ArrayList<T> rightResult = rightChild == null ? rightChild.inOrderTraversal()
                : new ArrayList<>();

        leftResult.add(value);
        leftResult.addAll(rightResult);

        return leftResult;
    }

    private ArrayList<T> levelOrderTraversal() {
        Queue<Tree<T>> queue = new LinkedList<>();
        ArrayList<T> result = new ArrayList<>();

        queue.add(this);
        while (!queue.isEmpty()) {
            Tree<T> current = queue.poll();
            result.add(current.value);
            if (current.leftChild != null) {
                queue.add(current.leftChild);
            }
            if (current.rightChild != null) {
                queue.add(current.rightChild);
            }
        }

        return result;
    }
}
