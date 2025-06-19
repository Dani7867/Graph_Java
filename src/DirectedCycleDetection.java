import java.util.ArrayList;
import java.util.List;

public class DirectedCycleDetection {

    static boolean dfs(int node, List<List<Integer>> graph, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, graph, visited, recStack))
                    return true;
            } else if (recStack[neighbor]) {
                return true; // back edge found
            }
        }

        recStack[node] = false;
        return false;
    }

    public static boolean isCycle(int[][] edges, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]); // directed edge
        }

        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n]; // track curr path

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, graph, visited, recStack))
                    return true;
            }
        } // ime: O(V + E) | Space: O(V) for visited + recStack + recursion stack

        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(isCycle(edges, 3)); // true
    }
}

//public class Solution {
//    public boolean hasCycle(int[] edges) {
//        int n = edges.length;
//        boolean[] visited = new boolean[n];
//        boolean[] recStack = new boolean[n];
//
//        for (int i = 0; i < n; i++) {
//            if (!visited[i]) {
//                if (dfs(i, edges, visited, recStack)) {
//                    return true; // Cycle found
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean dfs(int node, int[] edges, boolean[] visited, boolean[] recStack) {
//        visited[node] = true;
//        recStack[node] = true;
//
//        int next = edges[node];
//        if (next != -1) {
//            if (!visited[next]) {
//                if (dfs(next, edges, visited, recStack)) return true;
//            } else if (recStack[next]) {
//                return true; // cycle found
//            }
//        }
//
//        recStack[node] = false;
//        return false;
//    }
//
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[] edges = {1, 2, 0, 4, -1};
//        System.out.println(s.hasCycle(edges)); // true
//    }
//}

