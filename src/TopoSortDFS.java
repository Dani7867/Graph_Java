import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopoSortDFS {
    public static void main(String[] args) {
        int v = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
            graph.get(5).add(2);
            graph.get(5).add(0);
            graph.get(4).add(0);
            graph.get(4).add(1);
            graph.get(2).add(3);
            graph.get(3).add(1);

        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < v; i++) {
            if(!visited[i]){
                dfs(i,graph,visited,stack);
            }
        }

        System.out.print("Topological Sort (DFS): ");

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    private static void dfs(int i, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;
        for (int neighbour : graph.get(i)){
            if(!visited[neighbour]){
                dfs(neighbour,graph,visited,stack);
            }
        }

        stack.push(i); // push after all children
    }
}



