import java.util.*;

public class WeightedCitiesGraph {
    // Map of city -> list of (neighboring city, distance)
    private Map<String, List<Pair>> adjMap;
    private boolean isDirected;

    public WeightedCitiesGraph(boolean isDirected) {
        this.adjMap = new HashMap<>();
        this.isDirected = isDirected;
    }

    // Add a city if not already present
    public void addCity(String city) {
        adjMap.putIfAbsent(city, new ArrayList<>());
    }

    // Add a road between cities with distance
    public void addRoad(String from, String to, int distance) {
        addCity(from);
        addCity(to);

        adjMap.get(from).add(new Pair(to, distance));
        if (!isDirected) {
            adjMap.get(to).add(new Pair(from, distance));
        }
    }

    // Build graph from edge list
    public void graphFromEdges(Object[][] edges) {
        for (Object[] edge : edges) {
            String from = (String) edge[0];
            String to = (String) edge[1];
            int distance = (int) edge[2];
            addRoad(from, to, distance);
        }
    }

    // Print graph
    public void printGraph() {
        for (String city : adjMap.keySet()) {
            System.out.print("City " + city + " connects to: ");
            for (Pair neighbor : adjMap.get(city)) {
                System.out.print(neighbor.city + " (" + neighbor.distance + " km), ");
            }
            System.out.println();
        }
    }

    // Inner class to represent neighbor and distance
    static class Pair {
        String city;
        int distance;

        Pair(String city, int distance) {
            this.city = city;
            this.distance = distance;
        }
    }

    // Test
    public static void main(String[] args) {
        WeightedCitiesGraph graph = new WeightedCitiesGraph(false); // Undirected

        Object[][] roads = {
                {"Delhi", "Mumbai", 1400},
                {"Delhi", "Agra", 200},
                {"Agra", "Kanpur", 270},
                {"Mumbai", "Pune", 150},
                {"Pune", "Nagpur", 700}
        };

        graph.graphFromEdges(roads);
        graph.printGraph();
    }
}
