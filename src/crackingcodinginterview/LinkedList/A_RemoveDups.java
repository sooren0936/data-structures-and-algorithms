package crackingcodinginterview.LinkedList;

import crackingcodinginterview.LinkedList.collection.LinkedListSingleNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class A_RemoveDups {

    public static void main(String[] args) {
        long currentTimeMillis;

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionWithTemporaryBufferWithNextNext(removeDups()));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionWithTemporaryBufferWithPrevious(removeDups()));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionWithoutTemporaryBufferWithPrevious(removeDups()));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionWithoutTemporaryBufferWithNextNext(removeDups()));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    private static LinkedListSingleNode removeDups() {
        final LinkedListSingleNode linkedListSingleNode = new LinkedListSingleNode(0);
        linkedListSingleNode.appendToTail(1);
        linkedListSingleNode.appendToTail(1);
        linkedListSingleNode.appendToTail(2);
        linkedListSingleNode.appendToTail(3);
        linkedListSingleNode.appendToTail(1);
        linkedListSingleNode.appendToTail(2);
        return linkedListSingleNode;
    }

    public static LinkedListSingleNode solutionWithTemporaryBufferWithNextNext(final LinkedListSingleNode linkedListSingleNode) {
        if (linkedListSingleNode == null || linkedListSingleNode.next == null) {
            return linkedListSingleNode;
        }

        LinkedListSingleNode head = linkedListSingleNode;

        final Set<Integer> nodeCounts = new HashSet<>();
        nodeCounts.add(linkedListSingleNode.data);
        while (head.next != null) {
            int data = head.next.data;
            if (nodeCounts.contains(data)) {
                head.next = head.next.next;
                continue;
            } else {
                nodeCounts.add(data);
            }

            head = head.next;
        }
        return linkedListSingleNode;
    }

    public static LinkedListSingleNode solutionWithTemporaryBufferWithPrevious(final LinkedListSingleNode linkedListSingleNode) {
        if (linkedListSingleNode == null || linkedListSingleNode.next == null) {
            return linkedListSingleNode;
        }

        LinkedListSingleNode head = linkedListSingleNode;

        final Set<Integer> nodeCounts = new HashSet<>();
        LinkedListSingleNode previous = linkedListSingleNode;
        while (head != null) {
            int data = head.data;
            if (nodeCounts.contains(data)) {
                previous.next = head.next;
            } else {
                nodeCounts.add(data);
                previous = head;
            }

            head = head.next;
        }
        return linkedListSingleNode;
    }

    public static LinkedListSingleNode solutionWithoutTemporaryBufferWithPrevious(final LinkedListSingleNode linkedListSingleNode) {
        if (linkedListSingleNode == null || linkedListSingleNode.next == null) {
            return linkedListSingleNode;
        }
        LinkedListSingleNode head = linkedListSingleNode;

        LinkedListSingleNode previous = linkedListSingleNode;
        while (head != null) {

            LinkedListSingleNode next = head.next;
            while (next != null) {
                if (head.data == next.data) {
                    previous.next = next.next;
                } else {
                    previous = previous.next;
                }
                next = next.next;
            }
            if (head.next == null) {
                break;
            }

            head = head.next;
            previous = head;
        }
        return linkedListSingleNode;
    }

    public static LinkedListSingleNode solutionWithoutTemporaryBufferWithNextNext(final LinkedListSingleNode linkedListSingleNode) {
        if (linkedListSingleNode == null || linkedListSingleNode.next == null) {
            return linkedListSingleNode;
        }
        LinkedListSingleNode head = linkedListSingleNode;
        while (head != null) {

            LinkedListSingleNode next = head;
            while (next != null && next.next != null) {
                if (head.data == next.next.data) {
                    next.next = next.next.next;
                }
                next = next.next;
            }

            head = head.next;
        }
        return linkedListSingleNode;
    }
}

