package graph;

import java.util.ArrayList;

/**
 * Bellmman Ford's algirhtm works with positive as well as negative weights.
 * Although it won't work when there's cycle.
 */
public class BellmanFord {

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

        BellmanFord bellmanFord = new BellmanFord();
        int[] distance = bellmanFord.shortestPathFromSource(graph, 0, V);
        System.out.println("Distance from 0");
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
    }

    private static class Edge {

        int source;
        int dest;
        int weight;

        Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public int[] shortestPathFromSource(ArrayList<Edge>[] graph, int source, int V) {
        int distance[] = new int[V];
        for (int i = 0; i < distance.length; i++) {
            if (i != source) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        // Loop till V-1
        // The shortest path to destination will be calculated anyhow when you visit V-1
        // vertices.
        // If you run the same loop and still the distance array update, that means the
        // graph has a cycle

        // O(V)
        for (int i = 0; i < V - 1; i++) {
            // Loop though all the vertices O(E)
            for (int j = 0; j < V; j++) {
                // Loop through all the edges
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);

                    int u = e.source;
                    int v = e.dest;

                    // Why Integer.MAX_VALUE check? when you add MAX_VALUE to any positive number,
                    // result would be lesse than MAX_VALUE
                    if (distance[u] != Integer.MAX_VALUE && distance[u] + e.weight < distance[v]) {
                        distance[v] = distance[u] + e.weight;
                    }
                }
            }
        }

        return distance;
    }
}
