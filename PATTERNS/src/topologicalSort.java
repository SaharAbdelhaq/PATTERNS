import java.util.*;

public class topologicalSort {
    private static void addEdge(Map<Integer, List<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
    }

    private static List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int n) {
        int[] inDegree = new int[n];
        for (int u = 0; u < n; u++) {
            for (int v : graph.get(u)) {
                inDegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);
            for (int v : graph.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            graph.put(i, new ArrayList<>());
        }
        addEdge(graph, 5, 2);
        addEdge(graph, 5, 0);
        addEdge(graph, 4, 0);
        addEdge(graph, 4, 1);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 1);

        List<Integer> result = topologicalSort(graph, 6);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
