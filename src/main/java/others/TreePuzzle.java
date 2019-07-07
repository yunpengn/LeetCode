package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TreePuzzle {
    private static class TreeNode {
        int index;
        int value;
        int maxValue = 0;
        String bestPath = "";
        HashMap<String, ArrayList<TreeNode>> links = new HashMap<>();
        Set<TreeNode> children = new HashSet<>();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();

        // Initializes the tree.
        TreeNode[] nodes = new TreeNode[N];
        for (int i = 0; i < N; i++) {
            TreeNode node = new TreeNode();
            node.index = i;
            node.value = sc.nextInt();
            nodes[i] = node;
        }
        for (int i = 0; i < N - 1; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            String pathName = sc.next();

            TreeNode parent = nodes[from - 1];
            TreeNode child = nodes[to - 1];
            parent.children.add(child);
            if (!parent.links.containsKey(pathName)) {
                parent.links.put(pathName, new ArrayList<>());
            }
            parent.links.get(pathName).add(child);
        }

        // Performs a post-order traversal (we assume the first node is the root node).
        traverse(nodes[0], nodes);

        // Answers the queries.
        int[] results = new int[Q];
        for (int i = 0; i < Q; i++) {
            int startNode = sc.nextInt();
            results[i] = nodes[startNode - 1].maxValue;
        }
        for (int result: results) {
            System.out.println(result);
        }
    }

    private static void traverse(TreeNode root, TreeNode[] nodes) {
        // Returns directly for leaf nodes.
        if (root.children.isEmpty()) {
            root.maxValue = root.value;
            root.bestPath = "";
            return;
        }

        // Asks all children to traverse first.
        for (TreeNode child: root.children) {
            traverse(child, nodes);
        }

        // Finds out the maximum for the current node.
        int globalMax = -1;
        String bestPath = "";
        for (String pathName: root.links.keySet()) {
            ArrayList<TreeNode> group = root.links.get(pathName);

            HashMap<String, Integer> maxByPath = new HashMap<>();
            for (TreeNode node: group) {
                if (!maxByPath.containsKey(node.bestPath)) {
                    maxByPath.put(node.bestPath, 0);
                }
                int current = maxByPath.get(node.bestPath);
                maxByPath.put(node.bestPath, current + node.maxValue);
            }

            int localMax = -1;
            String localBestPath = "";
            for (String path: maxByPath.keySet()) {
                int current = maxByPath.get(path);
                if (current > localMax) {
                    localMax = current;
                    localBestPath = path;
                }
            }

            if (localMax > globalMax) {
                globalMax = localMax;
                bestPath = pathName + localBestPath;
            }
        }
        root.maxValue = globalMax;
        root.bestPath = bestPath;
    }
}
