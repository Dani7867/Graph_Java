public class ConnectedComponents {
    private int[] parent;
    private int[] rank;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        // Initially, every node is its own parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // Union the nodes
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        // Count unique roots (i.e., parents of components)
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) components++;
        }

        return components;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public static void main(String[] args) {
        ConnectedComponents cc = new ConnectedComponents();

        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int n = 5;

        System.out.println("Connected Components: " + cc.countComponents(n, edges)); // Output: 2
    }
}
