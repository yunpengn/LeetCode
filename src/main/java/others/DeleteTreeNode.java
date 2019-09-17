package others;

import leetcode.helpers.TreeNode;

public class DeleteTreeNode {
    void delete(TreeNode root, int val) {
        if (root == null) {
            return;
        } else if (root.left == null) {
            delete(root.right, val);
        } else if (val == root.left.val) {
            root.left = null;
        } else if (root.right == null) {
            delete(root.left, val);
        } else if (val == root.right.val) {
            root.right = null;
        } else if (val < root.val) {
            delete(root.left, val);
        } else {
            delete(root.right, val);
        }
    }
}
