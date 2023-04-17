package crackingcodinginterview.TreesAndGraphs.collection;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author Suren Kalaychyan
 */
public class TreeNode {

    public TreeNode(final Integer value) {
        this.value = value;
    }

    public TreeNode(final Integer value, final TreeNode left, final TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    private Integer value;
    private TreeNode parent;
    private TreeNode left;
    private TreeNode right;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return Objects.equals(value, treeNode.value) && Objects.equals(parent, treeNode.parent) && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, parent, left, right);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TreeNode.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }
}
