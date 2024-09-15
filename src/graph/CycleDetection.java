package graph;

import java.util.ArrayList;

public class CycleDetection {

    public static void main(String[] args) {
        int noOfVertices = 5;
        @SuppressWarnings("unchecked")
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

        /**
         *    1 --- 2 
         *   /|     |
         *  / |     |
         * 0  |     |
         *  \ |     |
         *   \|     |
         *    4     3
         *     \
         *      \
         *       5
         * 
         * cycle is available between 0-1-4
         */
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] undirectedGraph = new ArrayList[V];
        for (int i = 0; i < undirectedGraph.length; i++) {
            undirectedGraph[i] = new ArrayList<>();
        }

        undirectedGraph[0].add(new Edge(0, 1));
        undirectedGraph[0].add(new Edge(0, 4));

        undirectedGraph[1].add(new Edge(1, 0));
        undirectedGraph[1].add(new Edge(1, 2));
        undirectedGraph[1].add(new Edge(1, 4)); // Remove this to break the cycle

        undirectedGraph[2].add(new Edge(2, 1));
        undirectedGraph[2].add(new Edge(2, 3));
        
        undirectedGraph[3].add(new Edge(3, 2));
        
        undirectedGraph[4].add(new Edge(4, 0));
        undirectedGraph[4].add(new Edge(4, 1)); // Remove this to break the cycle
        undirectedGraph[4].add(new Edge(4, 5));

        undirectedGraph[5].add(new Edge(5, 4));

        System.out.println("Is cycle available in undirected graph: "
                + cycleDetection.isCycleExistInUnDirectedGraph(undirectedGraph, V));
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

    public boolean isCycleExistInUnDirectedGraph(ArrayList<Edge>[] graph, int V) {
        boolean[] visited = new boolean[V];

        // We are looping through all the unvisited vertices
        // in case, when there is no possibilites to traverse though entire
        // graph starting from only one vertex
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (isCycleExistInUnDirectedGraphInternal(graph, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isCycleExistInUnDirectedGraphInternal(ArrayList<Edge>[] graph, boolean[] visited, int curr, int parent) {
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // IMPORTANT: vertex is visited but it is not the parent of current 
            if (visited[e.dest] && parent != e.dest) {
                return true;
            } else if (!visited[e.dest]) {
                if(isCycleExistInUnDirectedGraphInternal(graph, visited, e.dest, curr)) {
                    return true;
                }
            }
        }

        return false;
    }
}
