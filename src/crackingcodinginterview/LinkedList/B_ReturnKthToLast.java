package crackingcodinginterview.LinkedList;

import crackingcodinginterview.LinkedList.collection.LinkedListSingleNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2.2 Return Kth to Last:
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class B_ReturnKthToLast {

    public static void main(String[] args) {
        long currentTimeMillis;

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionWithArrayList(returnKthToLast(), 1));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionIterative(returnKthToLast(), 1));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionRecursive(returnKthToLast(), 1));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    private static LinkedListSingleNode returnKthToLast() {
        final LinkedListSingleNode linkedListSingleNode = new LinkedListSingleNode(0);
        linkedListSingleNode.appendToTail(1);
        linkedListSingleNode.appendToTail(1);
        linkedListSingleNode.appendToTail(2);
        linkedListSingleNode.appendToTail(3);
        linkedListSingleNode.appendToTail(1);
        linkedListSingleNode.appendToTail(2);
        return linkedListSingleNode;
    }

    public static LinkedListSingleNode solutionWithArrayList(final LinkedListSingleNode linkedListSingleNode, int kth) {
        if (kth == 0) {
            kth = 1;
        }

        if (linkedListSingleNode == null || linkedListSingleNode.next == null || kth < 0) {
            return linkedListSingleNode;
        }
        final List<LinkedListSingleNode> linkedListSingleNodes = new ArrayList<>();
        LinkedListSingleNode head = linkedListSingleNode;
        while (head != null) {
            linkedListSingleNodes.add(head);
            head = head.next;
        }

        return linkedListSingleNodes.get(linkedListSingleNodes.size() - kth);
    }

    public static LinkedListSingleNode solutionIterative(final LinkedListSingleNode linkedListSingleNode, int kth) {
        if (linkedListSingleNode == null || linkedListSingleNode.next == null || kth < 0) {
            return linkedListSingleNode;
        }
        LinkedListSingleNode firstHead = linkedListSingleNode;
        LinkedListSingleNode secondHead = linkedListSingleNode;
        for (int i = 0; i < kth; i++) {
            firstHead = firstHead.next;
        }

        while (firstHead != null) {
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }

        return secondHead;
    }

    public static LinkedListSingleNode solutionRecursive(final LinkedListSingleNode linkedListSingleNode, final int kth) {
        if (linkedListSingleNode == null || linkedListSingleNode.next == null || kth < 0) {
            return linkedListSingleNode;
        }

        return solutionRecursive(linkedListSingleNode, kth, new Counter(0));
    }

    private static LinkedListSingleNode solutionRecursive(final LinkedListSingleNode linkedListSingleNode,
                                                          final int kth, final Counter counter) {
        if (linkedListSingleNode == null) {
            return null;
        }

        LinkedListSingleNode head = solutionRecursive(linkedListSingleNode.next, kth, counter);
        counter.setValue(counter.value() + 1);

        if (counter.value == kth) {
            return linkedListSingleNode;
        }

        return head;
    }

    private static class Counter {
        private int value;

        public int value() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Counter(int value) {
            this.value = value;
        }
    }
}