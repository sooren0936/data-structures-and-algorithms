package crackingcodinginterview.TreesAndGraphs;

import crackingcodinginterview.TreesAndGraphs.collection.Node;

/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an
 * algorithm to create a binary search tree with minimal height.
 */
public class B_MinimalTree {

    public static void main(String[] args) {
        minimalTree();
    }

    public static void minimalTree() {
        int[] oddedArray = {1, 3, 5, 6, 9, 15, 30};
        solutionNaive(oddedArray);
        solutionLittleBitOptimal(oddedArray);

        int[] evenArray = {1, 3, 5, 6, 9, 15, 30, 40};
        solutionNaive(evenArray);
        solutionLittleBitOptimal(evenArray);
    }

    public static Node solutionNaive(final int[] sortedArray) {
        return buildBinarySearchTree(sortedArray, sortedArray.length / 2, sortedArray.length / 2, 0);
    }

    private static Node buildBinarySearchTree(final int[] sortedArray, final int position,
                                              int step, final int count) {
        if (count > (int) Math.sqrt(sortedArray.length)) {
            return null;
        }
        step = (step + 1) / 2;
        final Node childLeft = buildBinarySearchTree(sortedArray, position - step, step, count + 1);
        final Node childRight = buildBinarySearchTree(sortedArray, position + step, step, count + 1);
        final Node root = new Node(sortedArray[position], childLeft, childRight);

        return root;
    }


    public static Node solutionLittleBitOptimal(final int[] sortedArray) {
        return createMinimalBST(sortedArray, 0, sortedArray.length - 2);
    }

    private static Node createMinimalBST(final int[] sortedArray, final int start, final int end) {
        if (end < start) {
            return null;
        }
        int position = (start + end) / 2;
        final Node childLeft = createMinimalBST(sortedArray, start, position - 1);
        final Node childRight = createMinimalBST(sortedArray, position + 1, end);
        final Node root = new Node(sortedArray[position], childLeft, childRight);

        return root;
    }
}