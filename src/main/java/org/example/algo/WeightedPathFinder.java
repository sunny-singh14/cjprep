package org.example.algo;

import java.util.*;

public class WeightedPathFinder {

    private final Map<String, Map<String, Float>> nodeMap;
    private final Set<String> nodesVisited;
    private final Map<String, String> backTracer;
    private final Map<String, Float> costs;
    private final String from;
    private final String to;

    WeightedPathFinder(Map<String, Map<String, Float>> nodeMap, String from, String to) {
        this.nodeMap = nodeMap;
        assertNodeExists(from);
        this.nodesVisited = new HashSet<>();
        this.backTracer = new HashMap<>();
        this.costs = new HashMap<>();
        this.from = from;
        this.to = to;
        this.costs.putAll(nodeMap.get(from));
        this.costs.putIfAbsent(to, Float.POSITIVE_INFINITY);
        this.nodesVisited.add(from);
    }

    public void findPath() {
        String node = findLowestCostNode();
        while (node != null) {
            Float cost = costs.get(node);
            Map<String, Float> neighbours = nodeMap.get(node);
            for (Map.Entry<String, Float> neighbour : neighbours.entrySet()) {
                Float newCost = cost + neighbour.getValue();
                Float costToNeighbour = costs.get(neighbour.getKey());
                if (costToNeighbour == null || costToNeighbour > newCost) {
                    costs.put(neighbour.getKey(), newCost);
                    backTracer.put(neighbour.getKey(), node);
                }
            }
            nodesVisited.add(node);
            node = findLowestCostNode();
        }
        printPath();
    }

    public String findLowestCostNode() {
        Float lowestCost = Float.POSITIVE_INFINITY;
        String lowestCostNode = null;
        for (Map.Entry<String, Float> node : costs.entrySet()) {
            if (node.getValue() < lowestCost && !nodesVisited.contains(node.getKey())) {
                lowestCost = node.getValue();
                lowestCostNode = node.getKey();
            }
        }
        return lowestCostNode;
    }

    private void printPath() {
        List<String> finalPath = new ArrayList<>();
        for (String at = to; at != null; at = backTracer.get(at))
            finalPath.add(at);
        finalPath.add(from);
        Collections.reverse(finalPath);
        for (int i = 0; i < finalPath.size(); i++) {
            String node = finalPath.get(i);
            Map<String, Float> neighbours = nodeMap.get(node);
            Float cost = null;
            if (finalPath.size() > i + 1) {
                cost = neighbours.get(finalPath.get(i + 1));
            }
            if (cost != null)
                System.out.printf("%s--%s-->", node, cost);
            else
                System.out.printf("%s : %s", node, costs.get(to));
        }
        System.out.println();
    }

    private void assertNodeExists(String node) {
        if (!nodeMap.containsKey(node)) {
            System.out.println("Out of context input");
            System.exit(1);
        }
    }

    static Map<String, Map<String, Float>> getSampleData() {
        Map<String, Map<String, Float>> sample = new HashMap<>();

        sample.put("S", Map.of("A", 6F, "B", 2F));
        sample.put("A", Map.of("F", 1F));
        sample.put("B", Map.of("A", 3F, "F", 5F));
        sample.put("F", Map.of());

        return sample;
    }

    static Map<String, Map<String, Float>> getExerciseA() {
        Map<String, Map<String, Float>> sample = new HashMap<>();

        sample.put("S", Map.of("A", 5F, "B", 2F));
        sample.put("A", Map.of("C", 4F, "D", 2F));
        sample.put("B", Map.of("A", 8F, "D", 7F));
        sample.put("C", Map.of("D", 6F, "F", 3F));
        sample.put("D", Map.of("F", 1F));
        sample.put("F", Map.of());

        return sample;
    }

    static Map<String, Map<String, Float>> getExerciseB() {
        Map<String, Map<String, Float>> sample = new HashMap<>();

        sample.put("S", Map.of("A", 10F));
        sample.put("A", Map.of("B", 20F));
        sample.put("B", Map.of("C", 1F, "F", 30F));
        sample.put("C", Map.of("A", 1F));
        sample.put("F", Map.of());

        return sample;
    }

    static Map<String, Map<String, Float>> getExerciseC() {
        Map<String, Map<String, Float>> sample = new HashMap<>();

        sample.put("S", Map.of("A", 2F, "B", 2F));
        sample.put("A", Map.of("C", 2F, "F", 2F));
        sample.put("B", Map.of("A", 2F));
        sample.put("C", Map.of("B", -2F, "F", 2F));
        sample.put("F", Map.of());

        return sample;
    }

    static Map<String, Map<String, Float>> getExerciseD() {
        Map<String, Map<String, Float>> sample = new HashMap<>();

        sample.put("S", Map.of("A", 5F, "B", 0F));
        sample.put("A", Map.of("B", -7F));
        sample.put("B", Map.of("F", 35F));
        sample.put("F", Map.of());

        return sample;
    }
}
