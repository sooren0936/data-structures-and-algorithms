package crackingcodinginterview.LinkedList;

import crackingcodinginterview.LinkedList.collection.LinkedListSingleNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect.
 * Return the intersecting node.
 * Note that the intersection is defined based on reference, not value.
 * That is, if the kth node of the first linked list is the exact same node (by reference)
 * as the jth node of the second linked list, then they are intersecting.
 */
public class G_Intersection {

    public static void main(String[] args) {
        intersection();
    }

    public static void intersection() {
        long currentTimeMillis;

        final LinkedListSingleNode intersectionLinkedList = new LinkedListSingleNode(7);
        intersectionLinkedList.appendToTail(2);
        intersectionLinkedList.appendToTail(1);

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionNaiveWithLoops(makeFirstTestLinkedList(intersectionLinkedList), makeSecondTestLinkedList(intersectionLinkedList)));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionNaiveWithLoops(makeThirdTestLinkedList(), makeFourthTestLinkedList()));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionWithHashTables(makeFirstTestLinkedList(intersectionLinkedList), makeSecondTestLinkedList(intersectionLinkedList)));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionWithHashTables(makeThirdTestLinkedList(), makeFourthTestLinkedList()));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    private static LinkedListSingleNode makeFirstTestLinkedList(final LinkedListSingleNode intersectionLinkedList) {
        final LinkedListSingleNode linkedListSingleNode = new LinkedListSingleNode(3);
        linkedListSingleNode.appendToTail(1);
        linkedListSingleNode.appendToTail(5);
        linkedListSingleNode.appendToTail(9);
        linkedListSingleNode.next.next.next.next = intersectionLinkedList;
        return linkedListSingleNode;
    }

    private static LinkedListSingleNode makeSecondTestLinkedList(final LinkedListSingleNode intersectionLinkedList) {
        final LinkedListSingleNode linkedListSingleNode = new LinkedListSingleNode(4);
        linkedListSingleNode.appendToTail(6);
        linkedListSingleNode.next.next = intersectionLinkedList;
        return linkedListSingleNode;
    }

    private static LinkedListSingleNode makeThirdTestLinkedList() {
        final LinkedListSingleNode linkedListSingleNode = new LinkedListSingleNode(3);
        linkedListSingleNode.appendToTail(1);
        linkedListSingleNode.appendToTail(5);
        linkedListSingleNode.appendToTail(9);
        linkedListSingleNode.appendToTail(7);
        linkedListSingleNode.appendToTail(2);
        linkedListSingleNode.appendToTail(1);
        return linkedListSingleNode;
    }

    private static LinkedListSingleNode makeFourthTestLinkedList() {
        final LinkedListSingleNode linkedListSingleNode = new LinkedListSingleNode(4);
        linkedListSingleNode.appendToTail(6);
        linkedListSingleNode.appendToTail(7);
        linkedListSingleNode.appendToTail(2);
        linkedListSingleNode.appendToTail(1);
        return linkedListSingleNode;
    }

    public static LinkedListSingleNode solutionNaiveWithLoops(LinkedListSingleNode firstLinkedList, LinkedListSingleNode secondLinkedList) {
        if (firstLinkedList == null || secondLinkedList == null) {
            return firstLinkedList;
        }

        LinkedListSingleNode firstHead = firstLinkedList;
        LinkedListSingleNode secondHead = secondLinkedList;

        while (secondHead != null) {
            while (firstHead != null) {
                if (firstHead == secondHead) {
                    return firstHead;
                }
                firstHead = firstHead.next;
            }
            secondHead = secondHead.next;
            firstHead = firstLinkedList.next;
        }

        return null;
    }

    public static LinkedListSingleNode solutionWithHashTables(LinkedListSingleNode firstLinkedList, LinkedListSingleNode secondLinkedList) {
        if (firstLinkedList == null || secondLinkedList == null) {
            return firstLinkedList;
        }

        final Set<LinkedListSingleNode> firstLinkedLists = new HashSet<>();
        final Set<LinkedListSingleNode> secondLinkedLists = new HashSet<>();

        while (firstLinkedList != null) {
            firstLinkedLists.add(firstLinkedList);
            firstLinkedList = firstLinkedList.next;
        }

        while (secondLinkedList != null) {
            secondLinkedLists.add(secondLinkedList);
            secondLinkedList = secondLinkedList.next;
        }

        for (LinkedListSingleNode linkedList : firstLinkedLists) {
            if (secondLinkedLists.contains(linkedList)) {
                return linkedList;
            }
        }

        return null;
    }
}