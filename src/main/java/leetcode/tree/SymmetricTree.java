package leetcode.tree;

import leetcode.helpers.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        } else if (left.val != right.val) {
            return false;
        } else {
            return helper(left.left, right.right) && helper(left.right, right.left);
        }
    }
}
