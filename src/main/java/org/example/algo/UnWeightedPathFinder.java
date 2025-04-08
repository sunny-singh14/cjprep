package org.example.algo;

import java.util.*;

public class UnWeightedPathFinder {

    private final Map<String, List<String>> nodeMap;
    private final Set<String> nodesVisited;
    private final Map<String, String> backTracer;
    private final String from;
    private final String to;

    UnWeightedPathFinder(Map<String, List<String>> nodeMap, String from, String to) {
        this.nodeMap = nodeMap;
        this.nodesVisited = new HashSet<>();
        this.backTracer = new HashMap<>();
        this.from = from;
        this.to = to;
    }

    public void findPath() {
        assertNodeExists(from);
        Queue<String> nodesToVisit = new LinkedList<>(nodeMap.get(from));
        nodesVisited.add(from);
        while (!nodesToVisit.isEmpty()) {
            String currentNode = nodesToVisit.poll();
            if (!nodesVisited.contains(currentNode) && nodeMap.containsKey(currentNode)) {
                if (to.equalsIgnoreCase(currentNode)) {
                    System.out.print("Shortest path: ");
                    printPath(from, to);
                    return;
                }
                List<String> neighbours = nodeMap.get(currentNode);
                updateBackTracer(neighbours, nodesToVisit, currentNode);
                nodesToVisit.addAll(neighbours);
                nodesVisited.add(currentNode);
            }
        }
        System.out.println("No route exists");
    }

    private void updateBackTracer(List<String> neighbours, Queue<String> nodesToVisit, String currentNode) {
        for (String neighbour : neighbours) {
            if (!nodesVisited.contains(neighbour) && !nodesToVisit.contains(neighbour)) {
                backTracer.put(neighbour, currentNode);
            }
        }
    }

    private void printPath(String from, String to) {
        List<String> finalPath = new ArrayList<>();
        for (String at = to; at != null; at = backTracer.get(at))
            finalPath.add(at);
        Collections.reverse(finalPath);
        System.out.print(from);
        finalPath.forEach(node -> System.out.printf(" -> %s", node));
    }

    private void assertNodeExists(String node) {
        if (!nodeMap.containsKey(node)) {
            System.out.println("Out of context input");
            System.exit(1);
        }
    }

    static Map<String, List<String>> getCityData() {
        Map<String, List<String>> cityMap = new HashMap<>();

        // Major cities with multiple connections
        cityMap.put("patna", List.of("kolkata", "delhi"));
        cityMap.put("delhi", List.of("jaipur", "surat", "mumbai"));
        cityMap.put("kolkata", List.of("ranchi", "bhubaneswar"));
        cityMap.put("mumbai", List.of("surat", "bangalore"));
        cityMap.put("bangalore", List.of("chennai", "hyderabad"));

        // Circular connections (cycle)
        cityMap.put("jaipur", List.of("mumbai", "delhi"));
        cityMap.put("surat", List.of("mumbai", "ahmedabad"));
        cityMap.put("ahmedabad", List.of("surat", "indore"));

        // Dead-end cities
        cityMap.put("lucknow", List.of());
        cityMap.put("indore", List.of());

        // Disconnected city (no way to reach from others)
        cityMap.put("puducherry", List.of("coimbatore", "madurai"));

        return cityMap;
    }
}
