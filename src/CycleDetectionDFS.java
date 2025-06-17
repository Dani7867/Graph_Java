import java.util.ArrayList;
import java.util.List;

public class CycleDetectionDFS {

    static boolean dfs(int s , List<List<Integer>> g , boolean[] v , int p){
        v[s] = true;
        for(int n : g.get(s)){
            if(!v[n]){
                boolean ans = dfs(n,g,v,s);
                if(ans) return true;
            }
            else if(v[n] && n!=p){
                return true;
            }
        }
        return false;
    }

    static public boolean isCycle(int[][] edges , int n){
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            g.add(new ArrayList<>());
        }
        for(int[] c :edges){
            int u = c[0] , v  = c[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!isVisited[i]){
                boolean ans = dfs(i,g,isVisited,-1);
                if(ans) return true;
            }
        }
        return false;
    } // Time: O(V + E) Space: O(V + E) (for graph + visited array)


    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{1,2},{2,3}};
        System.out.println(isCycle(edges,4));
    }
}
