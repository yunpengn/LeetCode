package leetcode.tree;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import leetcode.helpers.TreeNode;

class SymmetricTreeTest {
    private SymmetricTree tester = new SymmetricTree();

    @Test
    void nullTest() {
        boolean result = tester.isSymmetric(null);
        assertTrue(result);

        TreeNode root = new TreeNode(1);
        result = tester.isSymmetric(root);
        assertTrue(result);
    }
}
