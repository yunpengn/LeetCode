package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

import leetcode.helpers.TreeNode;

public class ConstructTree {
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }

        return buildTree(0, preOrder.length - 1, 0, inOrder.length - 1,
                preOrder, inOrderMap);
    }

    private TreeNode buildTree(int preStart, int preEnd, int inStart, int inEnd,
                               int[] preOrder, Map<Integer, Integer> inOrder) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode current = new TreeNode(preOrder[preStart]);
        int inRootIndex = inOrder.get(current.val);
        int numsLeft = inRootIndex - inStart;

        current.left = buildTree(preStart + 1, preStart + numsLeft,
                inStart, inRootIndex - 1,
                preOrder, inOrder);
        current.right = buildTree(preStart + numsLeft + 1, preEnd,
                inRootIndex + 1, inEnd,
                preOrder, inOrder);

        return current;
    }
}
