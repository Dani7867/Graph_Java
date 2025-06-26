public class UnionFind {
    private int[] rank;   // Rank (depth) of the tree
    private int[] parent; // Parent of each node

    public UnionFind(int n) {
        rank = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i; // Each node is its own parent
            rank[i] = 0;
        }
    }

    // Find with Path Compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Compress path
        }
        return parent[x];
    }

    // Union by Rank
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot) return; // Already in same set

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    // Check if two elements are in the same component
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        int n = 5; // Number of nodes (0 to 4)
        UnionFind uf = new UnionFind(n);

        int[][] edges = {{0, 1}, {1, 2}, {3, 4}, {2, 4}};

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        System.out.println(uf.isConnected(0, 2)); // true
        System.out.println(uf.isConnected(0, 3)); // true (after 2-4)
        System.out.println(uf.isConnected(3, 4)); // true
        System.out.println(uf.isConnected(1, 4)); // true
    }
}
