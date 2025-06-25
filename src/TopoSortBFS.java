import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSortBFS {
    public static void main(String[] args) {
        int v = 6,count=0;
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

        int[] indegree = new int[v];
        for(int i = 0 ; i<v ; i++){
            for (int neighbor : graph.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        System.out.print("Topological Sort (BFS): ");
        while(!queue.isEmpty()){
            int curr = queue.poll();
            System.out.print(curr + " ");
            count++;
            for (int neighbor : graph.get(curr)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }

        if (count != v) {
            System.out.println("\n Cycle detected! Topological sort not possible.");
        }
    }
}
