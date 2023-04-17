package crackingcodinginterview.TreesAndGraphs;

import crackingcodinginterview.TreesAndGraphs.collection.TreeNode;

/**
 * Validate BST: Implement a function to check if a binary tree is a binary search tree.
 */
public class E_ValidateBST {

    public static void main(String[] args) {
        validateBST();
    }

    public static void validateBST() {
        TreeNode leftC1 = new TreeNode(12);
        TreeNode rightC1 = new TreeNode(33);

        TreeNode leftB1 = new TreeNode(25, leftC1, rightC1);
        TreeNode rightB1 = new TreeNode(75);

        TreeNode leftB11 = new TreeNode(150);
        TreeNode rightB11 = new TreeNode(250);

        TreeNode leftA1 = new TreeNode(50, leftB1, rightB1);
        TreeNode rightA1 = new TreeNode(200, leftB11, rightB11);

        TreeNode root1 = new TreeNode(100, leftA1, rightA1);

        System.out.println(solutionDFS(root1));

        TreeNode leftC2 = new TreeNode(5);
        TreeNode leftB2 = new TreeNode(4, null, leftC2);
        TreeNode rightA2 = new TreeNode(3, null, leftB2);
        TreeNode leftA2 = new TreeNode(2);

        TreeNode root2 = new TreeNode(1, leftA2, rightA2);

        System.out.println(solutionDFS(root2));
    }

    public static boolean solutionDFS(final TreeNode binaryTree) {
        return solutionDFS(binaryTree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean solutionDFS(final TreeNode binaryTree, final Integer min, final Integer max) {
        if (binaryTree.getLeft() == null && binaryTree.getRight() == null) {
            return true;
        }

        final TreeNode left = binaryTree.getLeft();
        final TreeNode right = binaryTree.getRight();

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