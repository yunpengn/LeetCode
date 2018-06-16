package leetcode;

public class FlattenTree {
    private TreeNode previous = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            // Base case for the recursion.
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = previous;
        root.left = null;
        previous = root;
    }
}
