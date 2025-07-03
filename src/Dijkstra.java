import java.util.*;

public class Dijkstra {
    /* Dijkstra's algorithm finds the shortest path from a source node to all other nodes in a
    graph with non-negative edge weights.
      Feature	            Description
    Graph type	        Weighted, directed or undirected
    Edge weights	    Must be non-negative
    Data structure	    Min-heap (PriorityQueue)
    Time complexity	    O((V + E) log V) with heap + adj list
    Output	            Array of shortest distances from source

    Google Maps route planning,Network routing algorithms,Shortest time in transit networks.
     */

    static class Pair{
        int node , weight;
        Pair(int node , int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] dijkstra(int n , List<List<Pair>> graph , int src){
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.offer(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair current  = pq.poll();
            int u = current.node;
            int d = current.weight;

            if(d>dist[u]) continue;

            for (Pair neighbour : graph.get(u)){
                int v = neighbour.node;
                int w = neighbour.weight;

                if(dist[u] + w < dist[v]){
                    dist[v] = dist[u]+w;
                    pq.offer(new Pair(v,dist[v]));
                }
            }
        }
        return dist;
    }

    /*
         Time Complexity  | O((V + E) log V)
         Space Complexity | O(V + E)
*/

    public static void main(String[] args) {
        int n = 5;
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new Pair(1, 2));
        graph.get(1).add(new Pair(0, 2));

        graph.get(0).add(new Pair(3, 6));
        graph.get(3).add(new Pair(0, 6));

        graph.get(1).add(new Pair(2, 3));
        graph.get(2).add(new Pair(1, 3));

        graph.get(1).add(new Pair(3, 8));
        graph.get(3).add(new Pair(1, 8));

        graph.get(1).add(new Pair(4, 5));
        graph.get(4).add(new Pair(1, 5));

        graph.get(2).add(new Pair(4, 7));
        graph.get(4).add(new Pair(2, 7));

        Dijkstra d = new Dijkstra();
        int[] distances = d.dijkstra(n, graph, 0);
        System.out.println("Shortest distances from source 0:");
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + ": " + distances[i]);
        }
    }


}
