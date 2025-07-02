import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Edge{
    int u,v,weight;
    public  Edge(int u, int v, int w){
        this.u = u;
        this.v=v;
        this.weight=w;
    }
}

public class KruskalMST {
    static class UnionFind{
        int[] parent, rank;
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY) return false;

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    public  static int kruskal(int V , List<Edge> edges){
        edges.sort(Comparator.comparingInt(e -> e.weight));

        UnionFind uf = new UnionFind(V);
        int mstWeight = 0;
        int edgesUsed = 0;

        for(Edge e : edges){
            if(uf.union(e.u,e.v)){
                mstWeight += e.weight;
                edgesUsed++;
                if(edgesUsed == V-1) break;
            }
        }
        return mstWeight;
    }

    /*      | Operation      | Time               |
            | -------------- | ------------------ |
            | Sorting Edges  | O(E log E)         |
            | DSU Operations | ~O(1) (amortized)  |
            | Total          | O(E log E)         |
    */
// Use Cases -> Network design , Cost-efficient road/electric grid planning ,Clustering problems.
    public static void main(String[] args) {
        int V = 4; // Number of vertices
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        int minCost = kruskal(V, edges);
        System.out.println("Minimum Spanning Tree cost: " + minCost); // Output: 19
    }
}

