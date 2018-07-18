package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    // This problem is equivalent to finding if a cycle exists in a directed graph.
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Makes use of Kahn algorithm to do BFS topological sorting.
        int[] inDegree = new int[numCourses];
        // Creates an adjacency matrix to represent the graph.
        int[][] matrix = new int[numCourses][numCourses];

        for (int[] edge: prerequisites) {
            if (matrix[edge[0]][edge[1]] == 0) {
                // To avoid duplicate edges.
                inDegree[edge[1]]++;
            }
            matrix[edge[0]][edge[1]] = 1;
        }

        int count = 0;
        Queue<Integer> toVisit = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                toVisit.add(i);
            }
        }

        while(!toVisit.isEmpty()) {
            int current = toVisit.poll();
            count++;

            for (int i = 0; i < numCourses; i++) {
                if (matrix[current][i] != 0) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        toVisit.add(i);
                    }
                }
            }
        }

        return count == numCourses;
    }
}
