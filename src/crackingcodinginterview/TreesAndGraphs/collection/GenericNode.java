package crackingcodinginterview.TreesAndGraphs.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author Suren Kalaychyan
 */
public class GenericNode<T> {

    private T value;
    private List<GenericNode<T>> children = new ArrayList<>();
    private List<GenericNode<T>> parents;

    public GenericNode(final T value) {
        this.value = value;
    }

    public GenericNode(final T value, final List<GenericNode<T>> children) {
        final List<GenericNode<T>> notNullChildren = children.stream()
                .filter(Objects::nonNull)
                .toList();

        this.value = value;
        this.children = notNullChildren;
    }

    public GenericNode(final T value, final List<GenericNode<T>> parents, final List<GenericNode<T>> children) {
        final List<GenericNode<T>> notNullChildren = children.stream()
                .filter(Objects::nonNull)
                .toList();

        this.value = value;
        this.parents = parents;
        this.children = notNullChildren;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<GenericNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<GenericNode<T>> children) {
        this.children = children;
    }

    public List<GenericNode<T>> getParents() {
        return parents;
    }

    public void setParents(List<GenericNode<T>> parents) {
        this.parents = parents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericNode<?> that = (GenericNode<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GenericNode.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }
}
