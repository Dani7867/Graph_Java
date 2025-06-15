import java.util.ArrayList;
import java.util.List;

/**
 * A graph implementation using an adjacency list.
 * This structure is efficient for sparse graphs with sequentially labeled vertices.
 * Supports both directed and undirected graphs.
 */
public class AdjacencyListGraph {
    private int vertices;                    // Number of vertices in the graph
    private boolean isDirected;             // True for directed graph, false for undirected
    private List<List<Integer>> adjList;    // Adjacency list

    /**
     * Constructs the graph with the specified number of vertices and direction type.
     *
     * @param vertices   Number of vertices (indexed from 0 to vertices-1)
     * @param isDirected True for a directed graph, false for undirected
     */
    public AdjacencyListGraph(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        adjList = new ArrayList<>();

        // Initialize an empty list for each vertex
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    /**
     * Adds an edge from vertex u to vertex v.
     * If the graph is undirected, also adds an edge from v to u.
     *
     * @param u Source vertex
     * @param v Destination vertex
     */
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        if (!isDirected) {
            adjList.get(v).add(u);
        }
    }

    /**
     * Builds the graph from a list of edges.
     *
     * @param edges A 2D array where each element is an edge [u, v]
     */
    public void graphFromEdges(int[][] edges) {
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            addEdge(u, v);
        }
    }

    /**
     * Prints the graph's adjacency list representation.
     */
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Node " + i + " Neighbours: ");
            for (int neighbor : adjList.get(i)) {
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

        AdjacencyListGraph graph = new AdjacencyListGraph(vertices, isDirected);

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
