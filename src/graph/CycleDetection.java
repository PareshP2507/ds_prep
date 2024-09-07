package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class CycleDetection {

    public static void main(String[] args) {
        int noOfVertices = 5;
        ArrayList<Edge>[] graph = new ArrayList[noOfVertices];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1)); // 0 to 1
        graph[2].add(new Edge(2, 1)); // 2 to 1
        graph[2].add(new Edge(2, 3)); // 2 to 3
        graph[3].add(new Edge(3, 4)); // 3 to 4
        graph[4].add(new Edge(4, 2)); // 4 to 2

        CycleDetection cycleDetection = new CycleDetection();
        System.out.println("Is cycle exist: " + cycleDetection.isCycleDetectedInDirectedGraph(graph));
    }

    /**
     * Check if the cycle exist for given graph
     * 
     * @param graph graph
     * @return true if there is a cycle else false
     */
    public boolean isCycleDetectedInDirectedGraph(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] recStack = new boolean[graph.length];

        // We are looping through all the unvisited vertices
        // in case, when there is no possibilites to traverse though entire
        // graph starting from only one vertex
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (checkCycleForDirectedGraph(graph, i, visited, recStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Logic:
     * - do the DFS
     * - maintain 1 recursion stack to keep track of what's visited
     * - If you come across the vertex that is visited already [in rec stack],
     * you found a cycle.
     * 
     * @param graph    - Graph for which that cycle needs to be detected.
     * @param curr     - current vertex
     * @param visited  - visited vertices
     * @param recStack - recursion stack of visited vertices
     * @return true if the cycle is there else false
     */
    private boolean checkCycleForDirectedGraph(ArrayList<Edge>[] graph,
            Integer curr, boolean[] visited, boolean[] recStack) {
        visited[curr] = true;
        recStack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            curr = e.dest;
            if (recStack[curr]) {
                return true;
            } else if (!visited[curr]) {
                if (checkCycleForDirectedGraph(graph, curr, visited, recStack)) {
                    return true;
                }
            }
        }

        return false;
    }
}
