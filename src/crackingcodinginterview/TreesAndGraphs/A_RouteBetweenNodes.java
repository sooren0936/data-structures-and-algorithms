package crackingcodinginterview.TreesAndGraphs;

import crackingcodinginterview.TreesAndGraphs.collection.Node;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 */
public class A_RouteBetweenNodes {

    public static void main(String[] args) {
        routeBetweenNodes();
    }

    public static void routeBetweenNodes() {
        final Node finalNode = new Node(0);

        final Node nodeA1 = new Node(1, finalNode);
        final Node nodeA2 = new Node(2, nodeA1);
        final Node nodeA3 = new Node(3, nodeA2);

        final Node nodeB1 = new Node(11, finalNode);
        final Node nodeB2 = new Node(12, nodeB1);
        final Node nodeB3 = new Node(13, nodeB2);

        final Node graph = new Node(100500, nodeA3, nodeB3);

        System.out.println(solutionDeathFirstSearchDFS(graph, finalNode));
        System.out.println(solutionDeathFirstSearchDFS(nodeA1, nodeB1));

        System.out.println(solutionBreadthFirstSearchBFS(graph, finalNode));
        System.out.println(solutionBreadthFirstSearchBFS(nodeA1, nodeB1));
    }

    public static boolean solutionDeathFirstSearchDFS(final Node startNode, final Node endNode) {
        if (startNode == null || endNode == null) {
            return false;
        }

        if (startNode.getVisited()) {
            return false;
        } else {
            startNode.setVisited(true);
        }

        for (final Node node : startNode.getChildren()) {
            if (node.equals(endNode)) {
                return true;
            } else {
                return solutionDeathFirstSearchDFS(node, endNode);
            }
        }
        return false;
    }

    public static boolean solutionBreadthFirstSearchBFS(final Node startNode, final Node endNode) {
        if (startNode == null || endNode == null) {
            return false;
        }

        final Queue<Node> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(startNode);

        while (!nodeQueue.isEmpty()) {
            final Node rootNode = nodeQueue.poll();
            for (final Node childNode : rootNode.getChildren()) {
                if (childNode.getVisited()) {
                    continue;
                } else {
                    childNode.setVisited(true);
                }

                if (childNode.equals(endNode)) {
                    return true;
                }
                nodeQueue.add(childNode);
            }
        }
        return false;
    }
}