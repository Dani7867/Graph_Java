import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void BFSTravel(int s ,AdjacencyMapGraph graph,int n ){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n];

        queue.offer(s);
        isVisited[s] = true;

        while (!queue.isEmpty()){
            int curr = queue.poll();
            System.out.print(curr+" ");
            for(int neighbour : graph.getNeighbors(curr)){
                if(!isVisited[neighbour]){
                    queue.offer(neighbour);
                    isVisited[neighbour] = true;
                }
            }
        }
    } // Time Complexity: O(V + E) Space Complexity: O(V + E)
    public static void main(String[] args) {
        AdjacencyMapGraph graph = new AdjacencyMapGraph(5,false);
        int[][] edges = {{0,1},{1,4},{1,2},{2,3}};
        graph.graphFromEdges(edges);
        graph.printGraph();
        System.out.println("BFS Traversal:");
        BFSTravel(0,graph,5);
    }
}
