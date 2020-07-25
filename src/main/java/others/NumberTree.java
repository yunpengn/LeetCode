package others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberTree {
    public static void main(String[] args) throws Exception {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        // Checks the number of nodes.
        final int N = Integer.parseInt(line);
        final Map<Integer, Map<Integer, String>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new HashMap<>());
        }

        // Reads the input.
        for (int i = 0; i < N - 1; i++) {
            line = reader.readLine();
            final int start = Integer.parseInt(line.split(" ")[0]);
            final int end = Integer.parseInt(line.split(" ")[1]);
            final String value = line.split(" ")[2];

            graph.get(start).put(end, value);
            graph.get(end).put(start, value);
        }

        // Performs DFS and finds all paths.
        final Map<int[], String> paths = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            final Set<Integer> visited = new HashSet<>();
            traverse(graph, paths, visited, "", i, i);
        }

        // Gets the sum.
        int sum = 0;
        for (String distance: paths.values()) {
            sum += Integer.parseInt(distance);
            sum = sum % 10_0000_0000;
        }
        System.out.println(sum % 10_0000_0000);
    }

    private static void traverse(final Map<Integer, Map<Integer, String>> graph,
        final Map<int[], String> paths, final Set<Integer> visited,
        final String distance, final int start, final int current) {
        // Skips if this node has been visited before.
        if (visited.contains(current)) {
            return;
        }

        // Marks the current node as visited.
        visited.add(current);

        // Checks whether start -> current can form a path.
        if (current > start) {
            final int startIndex = Math.max(0, distance.length() - 9);
            paths.put(new int[]{start, current}, distance.substring(startIndex));
        }

        // Visits each neighbor.
        for (Map.Entry<Integer, String> next: graph.get(current).entrySet()) {
            final String nextDistance = distance + next.getValue();
            traverse(graph, paths, visited, nextDistance, start, next.getKey());
        }
    }
}
