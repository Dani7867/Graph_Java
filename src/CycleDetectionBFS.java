import java.util.*;

public class CycleDetectionBFS {

    static boolean bfs(int s, List<List<Integer>> g, boolean[] v, int[] p) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        v[s] = true;
        p[s] = -1;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neighbor : g.get(curr)) {
                if (!v[neighbor]) {
                    v[neighbor] = true;
                    p[neighbor] = curr;
                    q.offer(neighbor);
                } else if (p[curr] != neighbor) {
                    return true; // Cycle found
                }
            }
        }
        return false;
    }

    static public boolean isCycle(int[][] edges , int n){
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            g.add(new ArrayList<>());
        }
        for(int[] c : edges){
            int u = c[0], v = c[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (bfs(i, g, visited, parent)) return true;
            }
        }
        return false;
    }// Time: O(V + E) — standard BFS traversal Space: O(V + E) — graph + visited + parent arrays

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{1,2},{2,3}};
        System.out.println(isCycle(edges,4));  // Output: true
    }
}
