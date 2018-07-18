package leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import leetcode.helpers.UndirectedGraphNode;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        // Records a mapping from nodes in the original graph to those in the new graph.
        Map<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        mapping.put(node, new UndirectedGraphNode(node.label));

        // Performs a standard BFS (breadth-first search).
        Queue<UndirectedGraphNode> toVisit = new LinkedList<>();
        toVisit.add(node);

        while (!toVisit.isEmpty()) {
            UndirectedGraphNode current = toVisit.poll();
            UndirectedGraphNode cloned = mapping.get(current);

            for (UndirectedGraphNode neighbor: current.neighbors) {
                UndirectedGraphNode clonedNeighbor = mapping.get(neighbor);
                if (clonedNeighbor == null) {
                    toVisit.add(neighbor);
                    clonedNeighbor = new UndirectedGraphNode(neighbor.label);
                    mapping.put(neighbor, clonedNeighbor);
                }
                cloned.neighbors.add(clonedNeighbor);
            }
        }

        return mapping.get(node);
    }
}
