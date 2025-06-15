/**
 * A graph implementation using an adjacency matrix.
 * Supports both directed and undirected graphs.
 */
public class AdjacencyMatrixGraph {
    private int[][] adjMatrix;  // Adjacency matrix to store edges
    private int numVertices;    // Number of vertices in the graph
    private boolean isDirected; // Flag to indicate if the graph is directed

    /**
     * Constructs a graph with the given number of vertices and direction type.
     *
     * @param numVertices Number of vertices in the graph (0-indexed)
     * @param isDirected  True if the graph is directed, false if undirected
     */
    public AdjacencyMatrixGraph(int numVertices, boolean isDirected) {
        this.numVertices = numVertices;
        this.isDirected = isDirected;
        adjMatrix = new int[numVertices][numVertices];
    }

    /**
     * Adds an edge between vertex u and vertex v.
     *
     * @param u Source vertex
     * @param v Destination vertex
     */
    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        if (!isDirected) {
            adjMatrix[v][u] = 1;
        }
    }

    /**
     * Removes the edge between vertex u and vertex v.
     *
     * @param u Source vertex
     * @param v Destination vertex
     */
    public void removeEdge(int u, int v) {
        adjMatrix[u][v] = 0;
        if (!isDirected) {
            adjMatrix[v][u] = 0;
        }
    }

    /**
     * Builds the graph from a list of edges.
     *
     * @param edges A 2D array of edges, where each edge is [u, v]
     */
    public void graphFromEdges(int[][] edges) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            addEdge(u, v);
        }
    }

    /**
     * Prints the adjacency list representation of the graph.
     * Outputs each vertex and its direct neighbors.
     */
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Node " + i + " Neighbours: ");
            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Main method to test the graph functionality.
     */
    public static void main(String[] args) {
        int nodes = 5;
        boolean isDirected = false;

        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(nodes, isDirected);

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
