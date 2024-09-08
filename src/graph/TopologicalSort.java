package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear 
 * ordering of vertices such that for every directed edge u-v, 
 * vertex u comes before v in the ordering.
 * 
 * DAG is one which is directed but not cyclic
 * 
 * Note: Topological Sorting for a graph is not possible
 * if the graph is not a DAG.
 */
public class TopologicalSort {

    public static void main(String[] args) {
        int noOfVertices = 6;
        ArrayList<Edge>[] graph = new ArrayList[noOfVertices];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 0));
        graph[5].add(new Edge(5, 0));

        TopologicalSort topSort = new TopologicalSort();
        System.out.println(topSort.sort(graph, noOfVertices));
    }

    public List<Integer> sort(ArrayList<Edge>[] graph, int V) {
        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topSortInternal(graph, i, visited, stack);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private void topSortInternal(ArrayList<Edge>[] graph, int curr,
            boolean[] visited, Stack<Integer> stack) {
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                topSortInternal(graph, e.dest, visited, stack);
            }
        }
        stack.push(curr);
    }
}
