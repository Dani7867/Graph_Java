import java.util.Comparator;
import java.util.PriorityQueue;
// Prim’s Algorithm?
/*A greedy algorithm that grows the MST from any starting node,
 always picking the minimum weight edge that connects to a new (unvisited) node. */
public class PrimMST{
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] isVisited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.offer(new int[]{0,0});
        int totalCost = 0 ,  edgesUsed = 0;

        while(edgesUsed < n){
            int[] current = pq.poll();
            int cost = current[0],node= current[1];

            if(isVisited[node]) continue;

            isVisited[node] = true;
            totalCost += cost;
            edgesUsed++;

            for (int i = 0; i <n ; i++) {
                if(!isVisited[i]){
                    int dist = Math.abs(points[node][0] - points[i][0]) + Math.abs(points[node][1] - points[i][1]);
                    pq.offer(new int[]{dist, i});
                }
            }
        }
        return totalCost;
    }
    public static void main(String[] args) {
        PrimMST prim = new PrimMST();
        int[][] points = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };

        int result = prim.minCostConnectPoints(points);
        System.out.println("Minimum cost to connect all points: " + result); // Output: 20
    }
}
