package crackingcodinginterview.TreesAndGraphs;

import crackingcodinginterview.TreesAndGraphs.collection.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * First Common Ancestor: Design an algorithm and write code to find the first common ancestor
 * of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
 * necessarily a binary search tree.
 */
public class H_FirstCommonAncestor {

    public static void main(String[] args) {
        firstCommonAncestor();
    }

    public static void firstCommonAncestor() {
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

        leftB11.setParent(rightA1);
        rightB11.setParent(rightA1);

        leftB1.setParent(leftA1);
        rightB1.setParent(leftA1);

        leftC1.setParent(leftB1);
        rightC1.setParent(leftB1);

        System.out.println(solution(leftC1, rightC1));
        System.out.println(solution(leftC1, leftB1));
        System.out.println(solution(leftC1, rightB11));
    }

    private static TreeNode solution(final TreeNode firstNode, final TreeNode secondNode) {
        final List<TreeNode> ancestors = defineAncestors(secondNode);

        TreeNode node = firstNode;
        while (node.getParent() != null) {
            final TreeNode parent = node.getParent();
            if (ancestors.contains(parent)) {
                return parent;
            }
            node = node.getParent();
        }

        return null;
    }

    private static List<TreeNode> defineAncestors(final TreeNode originalNode) {
        final List<TreeNode> ancestors = new ArrayList<>();

        TreeNode node = originalNode;
        while (node.getParent() != null) {
            ancestors.add(node.getParent());
            node = node.getParent();
        }

        return ancestors;
    }
}