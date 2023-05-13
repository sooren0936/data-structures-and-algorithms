package crackingcodinginterview.TreesAndGraphs;

import crackingcodinginterview.TreesAndGraphs.collection.TreeNode;

/**
 * Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
 * binary search tree. You may assume that each node has a link to its parent
 */
public class F_Successor {

    public static void main(String[] args) {
        successor();
    }

    public static void successor() {
        TreeNode leftC1 = new TreeNode(12);
        TreeNode rightC1 = new TreeNode(33);

        TreeNode leftB1 = new TreeNode(25, leftC1, rightC1);
        TreeNode rightB1 = new TreeNode(75);

        TreeNode leftB11 = new TreeNode(150);
        TreeNode rightB11 = new TreeNode(250);

        TreeNode leftA1 = new TreeNode(50, leftB1, rightB1);
        TreeNode rightA1 = new TreeNode(200, leftB11, rightB11);

        TreeNode root1 = new TreeNode(100, leftA1, rightA1);

        leftA1.setParent(root1);
        rightA1.setParent(root1);

        leftB11.setParent(leftA1);
        rightB11.setParent(rightA1);

        leftB1.setParent(leftB11);
        rightB1.setParent(rightB11);

        leftC1.setParent(leftB1);
        rightC1.setParent(rightB1);

        System.out.println(inorderSuccessor(root1));

        TreeNode leftC2 = new TreeNode(5);
        TreeNode leftB2 = new TreeNode(4, null, leftC2);
        TreeNode rightA2 = new TreeNode(3, null, leftB2);
        TreeNode leftA2 = new TreeNode(2);

        TreeNode root2 = new TreeNode(1, leftA2, rightA2);

        System.out.println(inorderSuccessor(root2));
    }

    private static TreeNode inorderSuccessor(final TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }

        if (treeNode.getRight() != null) {
            return leftMostChild(treeNode.getRight());
        } else {
            TreeNode child = treeNode;
            TreeNode parent = child.getParent();

            while (parent != null && parent.getLeft() != child) {
                child = parent;
                parent = parent.getParent();
            }
            return parent;
        }
    }

    private static TreeNode leftMostChild(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        while (treeNode.getLeft() != null) {
            treeNode = treeNode.getLeft();
        }
        return treeNode;
    }
}