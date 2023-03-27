package crackingcodinginterview.LinkedList;

import crackingcodinginterview.LinkedList.collection.LinkedListSingleNode;

/**
 * Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
 * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
 * that node.
 * EXAMPLE
 * Input: the node c from the linked list a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like a->b->  d->e->f
 */
public class C_DeleteMiddleNode {

    public static void main(String[] args) {
        deleteMiddleNode();
    }

    public static void deleteMiddleNode() {
        long currentTimeMillis;

        currentTimeMillis = System.currentTimeMillis();
        final LinkedListSingleNode solutionNativeLinkedList = makeTestLinkedList();
        solutionNative(solutionNativeLinkedList);
        System.out.println(solutionNativeLinkedList);
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentTimeMillis = System.currentTimeMillis();
        final LinkedListSingleNode solutionNativeSolutionRandomize = makeTestLinkedList();
        solutionRandomize(solutionNativeSolutionRandomize);
        System.out.println(solutionNativeSolutionRandomize);
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    private static LinkedListSingleNode makeTestLinkedList() {
        final LinkedListSingleNode linkedListSingleNode = new LinkedListSingleNode(0);
        linkedListSingleNode.appendToTail(1);
        linkedListSingleNode.appendToTail(1);
        linkedListSingleNode.appendToTail(2);
        linkedListSingleNode.appendToTail(3);
        linkedListSingleNode.appendToTail(1);
        linkedListSingleNode.appendToTail(2);
        return linkedListSingleNode;
    }

    public static void solutionNative(final LinkedListSingleNode linkedListSingleNode) {
        if (linkedListSingleNode == null || linkedListSingleNode.next == null || linkedListSingleNode.next.next == null) {
            return;
        }

        linkedListSingleNode.next = linkedListSingleNode.next.next;
    }

    public static void solutionRandomize(final LinkedListSingleNode linkedListSingleNode) {
        if (linkedListSingleNode == null || linkedListSingleNode.next == null || linkedListSingleNode.next.next == null) {
            return;
        }
        LinkedListSingleNode head = linkedListSingleNode;

        int linkedListSizeForDeleteElements = 0;
        while (head.next.next != null) {
            linkedListSizeForDeleteElements++;
            head = head.next;
        }

        LinkedListSingleNode head1 = linkedListSingleNode;

        int numberOfCandidate = defineCandidateForDelete(linkedListSizeForDeleteElements);

        for (int i = 0; i < linkedListSizeForDeleteElements; i++) {
            if (i == numberOfCandidate) {
                head1.next = head1.next.next;
                return;
            }
            head1 = head1.next;
        }
    }

    private static int defineCandidateForDelete(final int linkedListSizeForDeleteElements) {
        return (int) (Math.random() * linkedListSizeForDeleteElements);
    }
}