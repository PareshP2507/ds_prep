package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 
 * Prim's algorith is used to get the MST(Minimum-spanning-tree) out of the
 * graph.
 * 
 * MST A minimum spanning tree (MST) is defined as a spanning tree that has the
 * minimum weight among all the possible spanning trees
 * 
 * MST has all the vertices, connected and the sum of weight is minimum
 * 
 * For example: for the graph below:
 *   0
 *  /|\
 * 1 | 2
 *  \|/
 *   3
 * 
 * where wieights are 0-1=10, 0-2=15, 0-3=30, 1-3=40, 2-3=50
 * 
 * MST is
 *   0
 *  /|\
 * 1 | 2
 *   3
 * Total cost is = 10 + 15 + 30 = 55
 */
public class Prims {
    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

        Prims prim = new Prims();
        System.out.println("MST cost: " + prim.findMST(graph, V, 0));
    }

    private static class Edge {
        int source;
        int desination;
        int weight;

        Edge(int source, int desination, int weight) {
            this.source = source;
            this.desination = desination;
            this.weight = weight;
        }
    }

    private static class Pair implements Comparable<Pair> {

        int node;
        int cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    /**
     * Idea here is to make two sets 1) Non-MST vertices 2) MST vertices
     * I'll grab the vertex with smallest distance from Non-MST vertices to MST
     * vertices
     * 
     * Since we need smallest element from the Non-MST set, we can PQ there
     * 
     * @param graph  graph
     * @param V      no of vertices
     * @param source source vertex to start from
     * 
     * @return total cost of minimum spanning tree
     */
    public int findMST(ArrayList<Edge>[] graph, int V, int source) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // Non-MST set
        pq.offer(new Pair(source, 0));

        boolean[] visited = new boolean[V]; // MST set

        int mstCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll(); // Pair with minimum cost
            if (!visited[curr.node]) {
                visited[curr.node] = true;
                mstCost += curr.cost;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if (!visited[e.desination]) {
                        pq.offer(new Pair(e.desination, e.weight));
                    }
                }
            }
        }

        return mstCost;
    }
}
