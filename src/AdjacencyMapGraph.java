import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A graph implementation using an adjacency map (HashMap of ArrayLists).
 * Suitable for sparse graphs or graphs with non-continuous node indices.
 * Supports both directed and undirected graphs.
 */
public class AdjacencyMapGraph {
    private int vertices; // Number of vertices
    private boolean isDirected; // True for directed graph, false for undirected
    private Map<Integer, ArrayList<Integer>> adjMap; // Adjacency map

    /**
     * Constructs a graph with the given number of vertices and direction type.
     *
     * @param vertices   Number of vertices (assumed to be labeled 0 to vertices-1)
     * @param isDirected True for directed graph, false for undirected
     */
    public AdjacencyMapGraph(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        adjMap = new HashMap<>();

        // Initialize adjacency list for each vertex
        for (int i = 0; i < vertices; i++) {
            adjMap.put(i, new ArrayList<>());
        }
    }

    /**
     * Adds an edge from vertex u to vertex v.
     * If the graph is undirected, also adds edge from v to u.
     *
     * @param u Source vertex
     * @param v Destination vertex
     */
    public void addEdge(int u, int v) {
        adjMap.get(u).add(v);
        if (!isDirected) {
            adjMap.get(v).add(u);
        }
    }

    /**
     * Builds the graph from a list of edges.
     *
     * @param edges A 2D array of edges, where each edge is [u, v]
     */
    public void graphFromEdges(int[][] edges) {
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            addEdge(u, v);
        }
    }

    public List<Integer> getNeighbors(int node) {
        return adjMap.getOrDefault(node, new ArrayList<>());
    }

    /**
     * Prints the adjacency list representation of the graph.
     */
    public void printGraph() {
        for (int node : adjMap.keySet()) {
            System.out.print("Node " + node + " Neighbours: ");
            for (int neighbor : adjMap.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    /**
     * Main method to test the graph implementation.
     */
    public static void main(String[] args) {
        int vertices = 5;
        boolean isDirected = false;

        AdjacencyMapGraph graph = new AdjacencyMapGraph(vertices, isDirected);

        int[][] edges = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 2},
                {1, 3}
        };

        graph.graphFromEdges(edges);
        graph.printGraph();
    }
}
