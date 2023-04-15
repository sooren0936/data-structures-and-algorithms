package crackingcodinginterview.TreesAndGraphs;

import crackingcodinginterview.TreesAndGraphs.collection.Node;

import java.util.ArrayList;
import java.util.List;

import static crackingcodinginterview.TreesAndGraphs.B_MinimalTree.solutionNaive;

/**
 * Check Balanced: Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined to be a tree
 * such that the heights of the two subtrees of any node never differ by more than one.
 */
public class D_CheckBalanced {

    public static void main(String[] args) {
        listCheckBalanced();
    }

    public static void listCheckBalanced() {
        final int[] oddedArray = {1, 3, 5, 6, 9, 15, 30};
        final Node bst = solutionNaive(oddedArray);
        System.out.println(solutionDFS(bst));

        Node leftC = new Node(5, new Node[0]);
        Node leftB = new Node(4, leftC);
        Node rightA = new Node(3, leftB);
        Node leftA = new Node(2, new Node[0]);

        Node root = new Node(1, leftA, rightA);

        System.out.println(solutionDFS(root));
    }

    public static boolean solutionDFS(final Node binaryTree) {
        int solution = solutionDFS(binaryTree, 1);
        if (solution > 1) {
            return false;
        }
        return true;
    }

    private static int solutionDFS(final Node binaryTree, final int level) {
        if (binaryTree.getChildren().length == 0) {
            return level;
        }

        final List<Integer> levels = new ArrayList<>();
        for (Node child : binaryTree.getChildren()) {
            int solution = solutionDFS(child, level + 1);
            levels.add(solution);
        }
        final Integer firstBranch = levels.get(0);

        if (levels.size() == 1) {
            return firstBranch - level;
        }
        final Integer secondBranch = levels.get(1);
        return Math.abs(secondBranch - firstBranch);
    }
}