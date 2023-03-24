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
        System.out.println(solutionWithoutTemporaryBuffer(removeDups()));
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

        LinkedListSingleNode linkedListForModify = linkedListSingleNode;

        final Set<Integer> nodeCounts = new HashSet<>();
        nodeCounts.add(linkedListSingleNode.data);
        while (linkedListForModify.next != null) {
            int data = linkedListForModify.next.data;
            if (nodeCounts.contains(data)) {
                linkedListForModify.next = linkedListForModify.next.next;
                continue;
            } else {
                nodeCounts.add(data);
            }

            linkedListForModify = linkedListForModify.next;
        }
        return linkedListSingleNode;
    }

    public static LinkedListSingleNode solutionWithTemporaryBufferWithPrevious(final LinkedListSingleNode linkedListSingleNode) {
        if (linkedListSingleNode == null || linkedListSingleNode.next == null) {
            return linkedListSingleNode;
        }

        LinkedListSingleNode linkedListForModify = linkedListSingleNode;

        final Set<Integer> nodeCounts = new HashSet<>();
        LinkedListSingleNode previous = linkedListSingleNode;
        while (linkedListForModify != null) {
            int data = linkedListForModify.data;
            if (nodeCounts.contains(data)) {
                previous.next = linkedListForModify.next;
            } else {
                nodeCounts.add(data);
                previous = linkedListForModify;
            }

            linkedListForModify = linkedListForModify.next;
        }
        return linkedListSingleNode;
    }

    public static LinkedListSingleNode solutionWithoutTemporaryBuffer(final LinkedListSingleNode linkedListSingleNode) {
        if (linkedListSingleNode == null || linkedListSingleNode.next == null) {
            return linkedListSingleNode;
        }
        LinkedListSingleNode firstIterationLinkedList = linkedListSingleNode;
        LinkedListSingleNode secondIterationLinkedList = linkedListSingleNode.next;

        while (firstIterationLinkedList != null) {
            while (secondIterationLinkedList != null) {
                if (firstIterationLinkedList.data == secondIterationLinkedList.data) {
                    firstIterationLinkedList.next = firstIterationLinkedList.next.next;
                    secondIterationLinkedList = secondIterationLinkedList.next;
                }
                secondIterationLinkedList = secondIterationLinkedList.next;
            }
            if (firstIterationLinkedList.next == null) {
                break;
            }

            firstIterationLinkedList = firstIterationLinkedList.next;
            secondIterationLinkedList = firstIterationLinkedList.next;
        }
        return linkedListSingleNode;
    }
}

