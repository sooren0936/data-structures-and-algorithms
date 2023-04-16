package crackingcodinginterview.TreesAndGraphs;

import crackingcodinginterview.TreesAndGraphs.collection.NodeLR;

/**
 * Validate BST: Implement a function to check if a binary tree is a binary search tree.
 */
public class E_ValidateBST {

    public static void main(String[] args) {
        validateBST();
    }

    public static void validateBST() {
        NodeLR leftC1 = new NodeLR(12);
        NodeLR rightC1 = new NodeLR(33);

        NodeLR leftB1 = new NodeLR(25, leftC1, rightC1);
        NodeLR rightB1 = new NodeLR(75);

        NodeLR leftB11 = new NodeLR(150);
        NodeLR rightB11 = new NodeLR(250);

        NodeLR leftA1 = new NodeLR(50, leftB1, rightB1);
        NodeLR rightA1 = new NodeLR(200, leftB11, rightB11);

        NodeLR root1 = new NodeLR(100, leftA1, rightA1);

        System.out.println(solutionDFS(root1));

        NodeLR leftC2 = new NodeLR(5);
        NodeLR leftB2 = new NodeLR(4, null, leftC2);
        NodeLR rightA2 = new NodeLR(3, null, leftB2);
        NodeLR leftA2 = new NodeLR(2);

        NodeLR root2 = new NodeLR(1, leftA2, rightA2);

        System.out.println(solutionDFS(root2));
    }

    public static boolean solutionDFS(final NodeLR binaryTree) {
        return solutionDFS(binaryTree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean solutionDFS(final NodeLR binaryTree, final Integer min, final Integer max) {
        if (binaryTree.getLeft() == null && binaryTree.getRight() == null) {
            return true;
        }

        final NodeLR left = binaryTree.getLeft();
        final NodeLR right = binaryTree.getRight();

        if (left != null
                && (left.getValue() > binaryTree.getValue()
                || left.getValue() < min)) {
            return false;
        }

        if (right != null
                && (right.getValue() > max
                || right.getValue() < binaryTree.getValue())) {
            return false;
        }

        if (left != null) {
            final boolean isLeftBST = solutionDFS(left, min, binaryTree.getValue());
            if (!isLeftBST) {
                return false;
            }
        }
        if (right != null) {
            final boolean isRightBST = solutionDFS(right, binaryTree.getValue(), max);
            if (!isRightBST) {
                return false;
            }
        }

        return true;
    }
}