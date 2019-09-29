package leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.helpers.TreeNode;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();

            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode current = queue.remove();
                level.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            result.add(level);
        }

        return result;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean fromFront = true;

        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            Integer[] level = new Integer[currentLevelSize];

            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode current = queue.remove();
                level[fromFront ? i : currentLevelSize - i - 1] = current.val;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            result.add(Arrays.asList(level));
            fromFront = !fromFront;
        }

        return result;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // Finds the height of the tree.
        int height = findHeight(root);
        List<List<Integer>> result = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            result.add(new ArrayList<>());
        }

        // Uses recursion to do level-order traversal.
        levelOrderBottom(root, height - 1, result);

        return result;
    }

    private void levelOrderBottom(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        result.get(level).add(root.val);

        // Recursively traverse on left & right sub-trees.
        levelOrderBottom(root.left, level - 1, result);
        levelOrderBottom(root.right, level - 1, result);
    }

    private int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(findHeight(root.left) ,findHeight(root.right)) + 1;
        }
    }
}
