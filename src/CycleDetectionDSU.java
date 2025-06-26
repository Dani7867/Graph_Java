public class CycleDetectionDSU {

    static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }

        boolean union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);

            if (xRoot == yRoot) return false; // Cycle detected

            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }

            return true;
        }
    }

    public static boolean hasCycle(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return true; // found a cycle
            }
        }

        return false; // no cycle
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {1, 3}
        };

        System.out.println("Has cycle? " + hasCycle(n, edges)); // true
    }
}
