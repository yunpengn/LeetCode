package others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ItemStock {
    public static void main(String[] args) throws Exception {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");
        int numItems = Integer.parseInt(tokens[0]);

        // Prepares from the root node.
        TreeNode[] items = new TreeNode[numItems];
        items[0] = new TreeNode(-1, Integer.parseInt(tokens[1]));

        for (int i = 0; i < numItems - 1; i++) {
            tokens = reader.readLine().split(" ");
            int type = Integer.parseInt(tokens[0]);
            int parentIndex = Integer.parseInt(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            items[i + 1] = new TreeNode(quantity, 0);
            if (type == 2) {

            }
        }
    }

    private static class TreeNode {
        int quantity;
        int stock;
        List<TreeNode> children;

        TreeNode(int quantity, int stock) {
            this.quantity = quantity;
            this.stock = stock;
            this.children = new ArrayList<>();
        }

        void addChild(TreeNode child) {
            this.children.add(child);
        }
    }
}
