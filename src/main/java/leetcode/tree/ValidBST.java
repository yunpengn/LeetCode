package leetcode.tree;

import leetcode.helpers.TreeNode;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValid(root).isValid;
    }

    private Result isValid(TreeNode node) {
        Result result = new Result();
        if (node.left == null && node.right == null) {
            result.isValid = true;
            result.min = node.val;
            result.max = node.val;
            return result;
        } else if (node.left == null) {
            Result rightResult = isValid(node.right);
            result.isValid = rightResult.isValid && node.val < rightResult.min;
            result.min = node.val;
            result.max = rightResult.max;
            return result;
        } else if (node.right == null) {
            Result leftResult = isValid(node.left);
            result.isValid = leftResult.isValid && leftResult.max < node.val;
            result.min = leftResult.min;
            result.max = node.val;
            return result;
        } else {
            Result leftResult = isValid(node.left);
            Result rightResult = isValid(node.right);
            result.isValid = leftResult.isValid && leftResult.max < node.val
                    && rightResult.isValid && node.val < rightResult.min;
            result.min = leftResult.min;
            result.max = rightResult.max;
            return result;
        }
    }

    private class Result {
        boolean isValid;
        int min;
        int max;
    }
}
