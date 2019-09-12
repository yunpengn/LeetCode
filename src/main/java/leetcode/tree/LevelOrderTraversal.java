package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.helpers.TreeNode;

public class LevelOrderTraversal {
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
