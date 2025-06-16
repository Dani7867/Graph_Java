import java.util.ArrayList;
import java.util.List;

public class ReorderRoutes {
    static int minReorder(int[][] connections , int n){
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] ne : connections){
            int u = ne[0] , v = ne[1];
            graph.get(u).add(new int[]{v,1});
            graph.get(v).add(new int[]{u,0});
        }

        boolean[] isVisited = new boolean[n];
        return dfs( 0,graph , isVisited);
    }

    private static int dfs(int s, List<List<int[]>> graph, boolean[] isVisited) {
        int changes = 0;
        isVisited[s] = true;
        for(int[] n : graph.get(s)){
            int next = n[0] , needChanges = n[1];
            if(!isVisited[n[0]]){
                changes += needChanges + dfs(next,graph,isVisited);
            }
        }
        return changes;
    }// Time Complexity: O(N), Space Complexity: O(N)


    public static void main(String[] args) {
        int n = 6;
        int[][] c = {{1,0},{1,2},{3,2},{3,4}};
        System.out.println(minReorder(c,n));
    }
}
