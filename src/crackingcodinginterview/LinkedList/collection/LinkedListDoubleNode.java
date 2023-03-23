package crackingcodinginterview.LinkedList.collection;

/**
 * Like the TreeNode class, we often needed access to the internals of a linked list in a way that the built-in
 * linked list class wouldn't support. For this reason, we implemented our own class and used it for many
 * problems.
 */
public class LinkedListDoubleNode {

    public LinkedListDoubleNode next, prev, last;

    public int data;

    public LinkedListDoubleNode(int d, LinkedListDoubleNode n, LinkedListDoubleNode p) {
        data = d;
        setNext(n);
        setPrevious(p);
    }

    public LinkedListDoubleNode(int d) {
        data = d;
    }

    public LinkedListDoubleNode() {
    }

    public void setNext(LinkedListDoubleNode n) {
        next = n;
        if (this == last) {
            last = n;
            if (n != null && n.prev != this) {
                n.setPrevious(this);
            }
        }
    }

    public void setPrevious(LinkedListDoubleNode p) {
        prev = p;
        if (p != null && p.next != this) {
            p.setNext(this);
        }
    }

    public LinkedListDoubleNode clone() {
        LinkedListDoubleNode next2 = null;
        if (next != null) {
            next2 = next.clone();
        }

        LinkedListDoubleNode head2 = new LinkedListDoubleNode(data, next2, null);
        return head2;
    }
}
