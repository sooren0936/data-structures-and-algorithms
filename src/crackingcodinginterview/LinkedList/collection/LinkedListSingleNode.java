package crackingcodinginterview.LinkedList.collection;


import java.util.StringJoiner;

/**
 * The code below implements a very basic singly linked list.
 */
public class LinkedListSingleNode {

    public LinkedListSingleNode next = null;
    public int data;

    public LinkedListSingleNode(int d) {
        data = d;
    }

    public void appendToTail(int d) {
        LinkedListSingleNode end = new LinkedListSingleNode(d);
        LinkedListSingleNode n = this;

        while (n.next != null) {
            n = n.next;
        }

        n.next = end;
    }

    public LinkedListSingleNode deleteNode(LinkedListSingleNode head, int d) {
        LinkedListSingleNode n = head;

        if (head.data == d) {
            return head.next; /* moved head */
        }

        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head; /* head didn't change*/
            }
            n = n.next;
        }
        return head;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        LinkedListSingleNode nextToString = this;
        do {
            stringJoiner.add(String.valueOf(nextToString.data));
            nextToString = nextToString.next;
        } while (nextToString != null);


        return stringJoiner.toString();
    }
}