package leetcode.tree;

import leetcode.helpers.TreeNode;

public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) >= 0;
    }

    // Returns -1 if not balanced, otherwise return the height of the current node.
    private int checkBalance(TreeNode root) {
        // Checks empty node.
        if (root == null) {
            return 0;
        }

        // Checks left sub-tree.
        int left = checkBalance(root.left);
        if (left < 0) {
            return -1;
        }

        // Checks right sub-tree.
        int right = checkBalance(root.right);
        if (right < 0) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
