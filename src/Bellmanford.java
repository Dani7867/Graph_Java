import java.util.Arrays;
/* Single-source shortest path algorithm
Handles negative edge weights
n - 1 times - relax every edge

do one more pass at the end if edge is still relaxing then
negative cycle detected
Time complexity	O(V × E)
Space complexity	O(V)
*/

public class Bellmanford {
    static class Edge{
        int u , v ,w ;
        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    public static int[] bellmanFord(int n , Edge[] edges, int src){
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i <= n - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.u] != Integer.MAX_VALUE &&
                        dist[edge.u] + edge.w < dist[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.w;
                }
            }
        }

        for (int i = 1; i <= n - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.u] != Integer.MAX_VALUE &&
                        dist[edge.u] + edge.w < dist[edge.v]) {
                    System.out.println("Negative weight cycle found");
                    return null;
                }
            }
        }

        return dist;

    }

    public static void main(String[] args) {
        int n = 5 ;
        Edge[] edges = {
                new Edge(0, 1, -1),
                new Edge(0, 2, 4),
                new Edge(1, 2, 3),
                new Edge(1, 3, 2),
                new Edge(1, 4, 2),
                new Edge(3, 2, 5),
                new Edge(3, 1, 1),
                new Edge(4, 3, -3)
        };

        int[] dist = bellmanFord(n,edges,0);
        if (dist != null) {
            System.out.println("Shortest distances from source 0:");
            for (int i = 0; i < n; i++) {
                System.out.println("Node " + i + ": " + dist[i]);
            }
        }
    }
}
