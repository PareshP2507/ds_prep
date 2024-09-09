package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *           7
 *     _1 -------_3_
 *    / |         | \
 *  2/  |         |  \1
 *  /   |         |   \_
 * 0    |1       2|    _5
 *  \   |         |   /
 *  4\  |_        |  /5
 *    \_2 -------_4 /
 *           3
 * 
 * given graph is directed, direction is indicated using _ sign
 */
public class Dijkstras {

    public static void main(String[] args) {
        int V = 6; // no. of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        Dijkstras dijkstras = new Dijkstras();
        dijkstras.dijkstras(graph, 0, V);
    }

    private static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    private static class Pair implements Comparable<Pair> {
        int vertex;
        int distance;

        public Pair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.distance - p2.distance;
        }
    }

    /**
     * Time complexity O(E + ElogV)
     * 
     * @param graph
     * @param source
     * @param V
     */
    public void dijkstras(ArrayList<Edge>[] graph, int source, int V) {
        // Pair is used to keep the track of vertex and its distance
        // PQ will be sorted according to the distance
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(source, 0));

        // Take distance array which will represent distance to all the vertices from
        // the source, initially all the values will be set to Infinite except source
        int[] distance = new int[V];
        for (int i = 0; i < distance.length; i++) {
            if (i != source) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        // Init visited boolean array to keep track of what all the vertices are visited
        boolean[] visited = new boolean[V];

        // Now we will use BFS for traversal
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            visited[curr.vertex] = true;

            for (int i = 0; i < graph[curr.vertex].size(); i++) {
                Edge e = graph[curr.vertex].get(i);

                int u = e.source;
                int v = e.destination;

                // If the distance of a parent + given vertex's weight is less than distance of
                // destination, replace v's distance with distance[u] + e.weight
                if (distance[u] + e.weight < distance[v]) {
                    distance[v] = distance[u] + e.weight;
                    pq.offer(new Pair(v, distance[v]));
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
    }
}
