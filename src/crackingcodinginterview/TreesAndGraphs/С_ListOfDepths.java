package crackingcodinginterview.TreesAndGraphs;

import crackingcodinginterview.TreesAndGraphs.collection.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static crackingcodinginterview.TreesAndGraphs.B_MinimalTree.solutionNaive;

/**
 * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class С_ListOfDepths {

    public static void main(String[] args) {
        listOfDepths();
    }

    public static void listOfDepths() {
        final int[] oddedArray = {1, 3, 5, 6, 9, 15, 30};
        final Node bst = solutionNaive(oddedArray);

        System.out.println(solutionDFS(bst));
        System.out.println(solutionBFS(bst));
    }

    public static List<LinkedList<Node>> solutionDFS(final Node bst) {
        final LinkedList<Node> linkedListNodes = new LinkedList<>();
        final List<LinkedList<Node>> listOfDepths = new ArrayList<>();
        listOfDepths.add(linkedListNodes);

        fillListOfDepths(bst, linkedListNodes, listOfDepths);
        return listOfDepths;
    }

    private static void fillListOfDepths(final Node bst, final List<Node> linkedListNodes,
                                         final List<LinkedList<Node>> listOfDepths) {
        linkedListNodes.add(bst);

        final LinkedList<Node> nodes = new LinkedList<>();
        for (final Node child : bst.getChildren()) {
            if (child != null) {
                fillListOfDepths(child, nodes, listOfDepths);
            }
        }
        listOfDepths.add(nodes);
    }

    public static List<LinkedList<Node>> solutionBFS(final Node bst) {
        final List<LinkedList<Node>> listOfBreadth = new ArrayList<>();

        fillListOfBreadth(bst, listOfBreadth);
        return listOfBreadth;
    }

    private static void fillListOfBreadth(final Node bst, final List<LinkedList<Node>> listOfDepths) {
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(bst);


        while (!nodes.isEmpty()) {
            listOfDepths.add(nodes);
            LinkedList<Node> currentNodes = nodes;
            nodes = new LinkedList<>();

            for (Node node : currentNodes) {
                if (node != null) {
                    for (Node child : node.getChildren()) {
                        if (child != null) {
                            nodes.add(child);
                        }
                    }
                }
            }
        }
    }
}