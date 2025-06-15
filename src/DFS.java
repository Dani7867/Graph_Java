public class DFS {

    public static void  DFSTravel(int node , AdjacencyMapGraph graph , int v , boolean[] isVisited){
        System.out.print(node+" ");
        isVisited[node] = true;
        for (int neighbour : graph.getNeighbors(node)){
            if(!isVisited[neighbour]){
                DFSTravel(neighbour,graph,v,isVisited);
            }
        }
    } // Time Complexity: O(V + E) Space Complexity: O(V + E) same as BFS when using Adj List.

    public static void main(String[] args) {
        AdjacencyMapGraph graph = new AdjacencyMapGraph(5,false);
        int[][] edges = {{0,1},{1,4},{1,2},{2,3}};
        graph.graphFromEdges(edges);
        boolean[] isVisited = new boolean[5];
        System.out.print("DFS Traversal:");
        DFSTravel(0,graph,5,isVisited);
    }
}
