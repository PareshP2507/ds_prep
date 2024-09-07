package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class GraphWithMap {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        List<Integer> destOfZero = new ArrayList<>();
        destOfZero.add(1);
        destOfZero.add(2);
        graph.put(0, destOfZero);

        List<Integer> destOfOne = new ArrayList<>();
        destOfOne.add(0);
        destOfOne.add(3);
        graph.put(1, destOfOne);

        List<Integer> destOfTwo = new ArrayList<>();
        destOfTwo.add(0);
        destOfTwo.add(4);
        graph.put(2, destOfTwo);

        List<Integer> destOfThree = new ArrayList<>();
        destOfThree.add(1);
        destOfThree.add(4);
        destOfThree.add(5);
        graph.put(3, destOfThree);

        List<Integer> destOfFour = new ArrayList<>();
        destOfFour.add(2);
        destOfFour.add(3);
        destOfFour.add(5);
        graph.put(4, destOfFour);

        List<Integer> destOfFive = new ArrayList<>();
        destOfFive.add(3);
        destOfFive.add(4);
        destOfFive.add(6);
        graph.put(5, destOfFive);

        List<Integer> destOfSix = new ArrayList<>();
        destOfSix.add(5);
        graph.put(6, destOfSix);

        GraphWithMap graphWithMap = new GraphWithMap();
        graphWithMap.dfs(graph);
    }

    public void dfs(Map<Integer, List<Integer>> graph) {
        int vertices = graph.keySet().size();
        boolean[] visited = new boolean[vertices];

        dfsInternal(graph, visited, (Integer) graph.keySet().toArray()[0]);
    }

    private void dfsInternal(Map<Integer, List<Integer>> graph, boolean[] visited, Integer curr) {
        System.out.println(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph.get(curr).size(); i++) {
            Integer dest = graph.get(curr).get(i);

            if (!visited[dest]) {
                curr = dest;
                dfsInternal(graph, visited, curr);
            }
        }
    }
}
