import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// Find if Path Exists in Graph
public class ValidPath {

    static boolean validPath(int n , int s , int d , int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i<n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] neighbours : edges){
            int u = neighbours[0] , v = neighbours[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] isVisited = new boolean[n];
        //bfs(s ,graph ,isVisited );
        dfs(s,graph,isVisited);
        return isVisited[d];
    }

    private static void dfs(int s, List<List<Integer>> graph, boolean[] isVisited) {
        isVisited[s] = true;
        for(int n : graph.get(s)) {
            if (!isVisited[n]) {
                dfs(n, graph, isVisited);
            }
        }
    }

    private static void bfs(int s, List<List<Integer>> graph, boolean[] isVisited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        isVisited[s] = true;
        while (!queue.isEmpty()){
            int curr = queue.poll();
            for(int n : graph.get(curr)){
                if(!isVisited[n]){
                    isVisited[n] = true;
                    queue.offer(n);
                }
            }
        }
    } //Time Complexity: O(V + E) Space Complexity: O(V)

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(validPath(6, 0,5,edges));
    }
}
