package crackingcodinginterview.TreesAndGraphs.collection;

/**
 * @author Suren Kalaychyan
 */
public class NodeLR {

    public NodeLR(final Integer value) {
        this.value = value;
    }

    public NodeLR(final Integer value, final NodeLR left, final NodeLR right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    private Integer value;
    private NodeLR left;
    private NodeLR right;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public NodeLR getLeft() {
        return left;
    }

    public void setLeft(NodeLR left) {
        this.left = left;
    }

    public NodeLR getRight() {
        return right;
    }

    public void setRight(NodeLR right) {
        this.right = right;
    }
}
