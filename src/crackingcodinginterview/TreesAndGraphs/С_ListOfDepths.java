package crackingcodinginterview.TreesAndGraphs;

import crackingcodinginterview.TreesAndGraphs.collection.Node;

import java.util.*;

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
        System.out.println(solution(bst));

        int[] evenArray = {1, 3, 5, 6, 9, 15, 30, 40};
        solutionNaive(evenArray);
    }

    public static List<LinkedList<Node>> solution(final Node bst) {
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
        final long childrenCount = Arrays.stream(bst.getChildren())
                .filter(Objects::nonNull)
                .count();

        if (childrenCount != 0) {
            listOfDepths.add(nodes);
        }
    }
}