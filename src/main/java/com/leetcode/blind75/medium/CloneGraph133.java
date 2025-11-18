package com.leetcode.blind75.medium;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

public class CloneGraph133 {

    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // If already cloned, return from map
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Clone current node
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        // Clone all neighbors recursively
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }

    // Print the graph using BFS traversal
    public void printGraph(Node node) {
        if (node == null) {
            System.out.println("Graph is empty.");
            return;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print("Node " + current.val + " -> ");

            // Print neighbors' values
            for (Node neighbor : current.neighbors) {
                System.out.print(neighbor.val + " ");
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
            System.out.println(); // new line after each node
        }
    }

    // Optional test
    public static void main(String[] args) {
        // Build simple graph: 1 -- 2
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        CloneGraph133 s = new CloneGraph133();
        Node clone = s.cloneGraph(n1);

        System.out.println("Original node val: " + n1.val);
        System.out.println("Cloned node val: " + clone.val);
        System.out.println("Original neighbor: " + n1.neighbors.get(0).val);
        System.out.println("Cloned neighbor: " + clone.neighbors.get(0).val);

        System.out.println("Original graph:");
        s.printGraph(n1);
        System.out.println("Cloned graph:");
        s.printGraph(clone);
    }
}
