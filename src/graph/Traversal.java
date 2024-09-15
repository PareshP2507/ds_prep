package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class used to traverse through the graph
 * Example of graph
 * 
 *    1 -- 3
 *  /      | \
 * 0       |   5 -- 6
 *  \      | /
 *    2 -- 4
 */
public class Traversal {

    public static void main(String[] args) {

        // Create an adjacency list for the graph above
        int noOfVertices = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[noOfVertices];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));

        Traversal traversal = new Traversal();
        System.out.println("DFS: " + traversal.dfs(graph, 0, noOfVertices));
        System.out.println("BFS: " + traversal.bfs(graph, 0));
    }

    /**
     * Depth-First-Traversal of a graph
     * 
     * @param graph given graph for which the traversal needs to be done
     * @param start starting vertex of graph
     * @param V     no of vertices
     * @return a list contained traversed vertices
     */
    public List<Integer> dfs(ArrayList<Edge> graph[], Integer start, int V) {
        List<Integer> result = new ArrayList<>();

        boolean[] visited = new boolean[V];
        dfsInternal(graph, result, start, visited);

        return result;
    }

    private void dfsInternal(
            ArrayList<Edge> graph[],
            List<Integer> result,
            Integer curr,
            boolean[] visited) {
        visited[curr] = true;
        result.add(curr);

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (visited[e.dest] == false) {
                curr = e.dest;
                dfsInternal(graph, result, curr, visited);
            }
        }
    }

    /**
     * Breadth-First-Traversal of a graph
     * 
     * @param graph given graph for which the traversal needs to be done
     * @param start starting vertex of graph
     * @return a list contained traversed vertices
     */
    public List<Integer> bfs(ArrayList<Edge> graph[], Integer start) {
        List<Integer> result = new ArrayList<>();
        // Array to track which vertex is visited
        boolean[] visited = new boolean[graph.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            if (visited[curr] == false) {
                result.add(curr);
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    queue.offer(graph[curr].get(i).dest);
                }
            }
        }

        return result;
    }
}
