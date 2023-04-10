package crackingcodinginterview.TreesAndGraphs.collection;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Suren Kalaychyan
 */
public class Node {

    private static final int INITIAL_NODE_CAPACITY = 1000;

    public Node(final Integer value) {
        this.value = value;
    }

    public Node(final Integer value, final Node... children) {
        this.value = value;
        this.children = children;
    }

    private Integer value;
    private Node[] children = new Node[INITIAL_NODE_CAPACITY];
    private boolean visited;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (visited != node.visited) return false;
        if (!Objects.equals(value, node.value)) return false;
        return Arrays.equals(children, node.children);
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(children);
        result = 31 * result + (visited ? 1 : 0);
        return result;
    }
}
