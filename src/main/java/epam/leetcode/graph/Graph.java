package epam.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    // Add a vertex
    public void addVertex(int vertex) {
        if (!adjList.containsKey(vertex)) {
            adjList.put(vertex, new ArrayList<>());
        }
    }

    // Add an undirected edge
    public void addEdge(int src, int dest) {
        // Add source vertex if not present
        if (!adjList.containsKey(src)) {
            adjList.put(src, new ArrayList<>());
        }
        // Add destination vertex if not present
        if (!adjList.containsKey(dest)) {
            adjList.put(dest, new ArrayList<>());
        }

        // Add the edge (both ways for undirected graph)
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    // Add a directed edge (one way)
    public void addDirectedEdge(int src, int dest) {
        if (!adjList.containsKey(src)) {
            adjList.put(src, new ArrayList<>());
        }

        if (!adjList.containsKey(dest)) {
            adjList.put(dest, new ArrayList<>());
        }

        adjList.get(src).add(dest);
    }

    // Remove an edge
    public void removeEdge(int src, int dest) {
        if (adjList.containsKey(src)) {
            adjList.get(src).remove(Integer.valueOf(dest));
        }
        if (adjList.containsKey(dest)) {
            adjList.get(dest).remove(Integer.valueOf(src));
        }
    }

    // Remove a vertex
    public void removeVertex(int vertex) {
        if (!adjList.containsKey(vertex)) return;

        // Remove vertex from all adjacency lists
        for (List<Integer> neighbors : adjList.values()) {
            neighbors.remove(Integer.valueOf(vertex));
        }

        // Remove the vertex itself
        adjList.remove(vertex);
    }

    // Print the adjacency list
    public void printGraph() {
        for (int vertex : adjList.keySet()) {
            System.out.println(vertex + " -> " + adjList.get(vertex));
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();

        // Add vertices
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);

        // Add edges
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);

        System.out.println("Graph adjacency list:");
        g.printGraph();

        // Remove an edge
        g.removeEdge(1, 3);
        System.out.println("\nAfter removing edge (1,3):");
        g.printGraph();

        // Remove a vertex
        g.removeVertex(4);
        System.out.println("\nAfter removing vertex 4:");
        g.printGraph();
    }
}